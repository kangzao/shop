package com.jep.shop.user.controller;

import com.jep.shop.common.enums.BizCodeEnum;
import com.jep.shop.common.enums.SendCodeEnum;
import com.jep.shop.common.util.CommonUtil;
import com.jep.shop.common.util.JsonData;
import com.jep.shop.user.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.jep.shop.common.enums.SendCodeEnum;

/**
 * @author enping.jep
 * @date 2024/11/14 23:35
 **/
@Api(tags = "通知模块")
@RestController
@RequestMapping("/api/user/v1")
@Slf4j
public class NotifyController {


    @Autowired
    private Producer captchaProducer;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private NotifyService notifyService;

    /**
     * 图形验证码有效期10分钟
     */
    private static final long CAPTCHA_CODE_EXPIRED = 60 * 1000 * 10;

    /**
     * 获取图形验证码
     *
     * @param request
     * @param response
     */
    @ApiOperation("获取图形验证码")
    @GetMapping("captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {

        String captchaText = captchaProducer.createText();
        log.info("图形验证码:{}", captchaText);

        //存储
        redisTemplate.opsForValue().set(getCaptchaKey(request), captchaText, CAPTCHA_CODE_EXPIRED, TimeUnit.MILLISECONDS);

        BufferedImage bufferedImage = captchaProducer.createImage(captchaText);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("获取图形验证码异常:{}", e);
        }

    }


    /**
     * 发送验证码
     * 1、匹配图形验证码是否正常
     * 2、发送验证码
     *
     * @param to
     * @param captcha
     * @return
     */
    @ApiOperation("发送邮箱注册验证码")
    @GetMapping("send_code")
    public JsonData sendRegisterCode(@RequestParam(value = "to", required = true) String to, @RequestParam(value = "captcha", required = true) String captcha, HttpServletRequest request) {

        String key = getCaptchaKey(request);
        String cacheCaptcha = redisTemplate.opsForValue().get(key);

        //匹配图形验证码是否一样
        if (captcha != null && cacheCaptcha != null && captcha.equalsIgnoreCase(cacheCaptcha)) {
            //成功
            redisTemplate.delete(key);
            JsonData jsonData = notifyService.sendCode(SendCodeEnum.USER_REGISTER, to);
            return jsonData;

        } else {
            return JsonData.buildResult(BizCodeEnum.CODE_CAPTCHA_ERROR);
        }

    }


    /**
     * 获取缓存的key
     *
     * @param request
     * @return
     */
    private String getCaptchaKey(HttpServletRequest request) {

        String ip = CommonUtil.getIpAddr(request);
        String userAgent = request.getHeader("User-Agent");

        String key = "user-service:captcha:" + CommonUtil.MD5(ip + userAgent);

        log.info("ip={}", ip);
        log.info("userAgent={}", userAgent);
        log.info("key={}", key);

        return key;

    }


}
