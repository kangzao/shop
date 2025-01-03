package com.jep.shop.user.service.impl;

import com.jep.shop.common.constant.CacheKey;
import com.jep.shop.common.enums.BizCodeEnum;
import com.jep.shop.common.enums.SendCodeEnum;
import com.jep.shop.common.util.CheckUtil;
import com.jep.shop.common.util.CommonUtil;
import com.jep.shop.common.util.JsonData;
import com.jep.shop.user.service.MailService;
import com.jep.shop.user.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author enping.jep
 * @date 2024/11/14 23:52
 **/
@Service
@Slf4j
public class NotifyServiceImpl implements NotifyService {


    @Autowired
    private MailService mailService;

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 验证码的标题
     */
    private static final String SUBJECT = "验证码";

    /**
     * 验证码的内容
     */
    private static final String CONTENT = "您的验证码是%s,有效时间是10分钟,不要告诉任何人";

    /**
     * 验证码10分钟有效
     */
    private static final int CODE_EXPIRED = 60 * 1000 * 10;

    /**
     * 前置：判断是否重复发送
     * <p>
     * 1、存储验证码到缓存
     * <p>
     * 2、发送邮箱验证码
     * <p>
     * 后置：存储发送记录
     *
     * @param sendCodeEnum
     * @param to
     * @return
     */
    @Override
    public JsonData sendCode(SendCodeEnum sendCodeEnum, String to) {

        String cacheKey = String.format(CacheKey.CHECK_CODE_KEY, sendCodeEnum.name(), to);

        String cacheValue = redisTemplate.opsForValue().get(cacheKey);

        //如果不为空，则判断是否60秒内重复发送
        if (StringUtils.isNotBlank(cacheValue)) {
            long ttl = Long.parseLong(cacheValue.split("_")[1]);
            //当前时间戳-验证码发送时间戳，如果小于60秒，则不给重复发送
            if (CommonUtil.getCurrentTimestamp() - ttl < 1000 * 60) {
                log.info("重复发送验证码,时间间隔:{} 秒", (CommonUtil.getCurrentTimestamp() - ttl) / 1000);
                return JsonData.buildResult(BizCodeEnum.CODE_LIMITED);
            }
        }

        //拼接验证码 2322_324243232424324
        String code = CommonUtil.getRandomCode(6);

        String value = code + "_" + CommonUtil.getCurrentTimestamp();

        redisTemplate.opsForValue().set(cacheKey, value, CODE_EXPIRED, TimeUnit.MILLISECONDS);

        if (CheckUtil.isEmail(to)) {
            //邮箱验证码
            mailService.sendMail(to, SUBJECT, String.format(CONTENT, code));

            return JsonData.buildSuccess();

        } else if (CheckUtil.isPhone(to)) {
            //短信验证码

        }

        return JsonData.buildResult(BizCodeEnum.CODE_TO_ERROR);
    }


    /**
     * 校验验证码
     *
     * @param sendCodeEnum
     * @param to
     * @param code
     * @return
     */
    @Override
    public boolean checkCode(SendCodeEnum sendCodeEnum, String to, String code) {
        String cacheKey = String.format(CacheKey.CHECK_CODE_KEY, sendCodeEnum.name(), to);

        String cacheValue = redisTemplate.opsForValue().get(cacheKey);
        if (StringUtils.isNotBlank(cacheValue)) {

            String cacheCode = cacheValue.split("_")[0];
            if (cacheCode.equals(code)) {
                //删除验证码
                redisTemplate.delete(cacheKey);
                return true;
            }

        }
        return false;
    }
}

