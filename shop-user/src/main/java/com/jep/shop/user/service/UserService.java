package com.jep.shop.user.service;

import com.jep.shop.common.util.JsonData;
import com.jep.shop.user.model.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jep.shop.user.request.UserLoginRequest;
import com.jep.shop.user.request.UserRegisterRequest;
import com.jep.shop.user.vo.UserVO;

/**
 *  服务类
 * @author enping.jep
 * @since 2024-09-28
 */
public interface UserService {

    /**
     * 用户注册
     * @param registerRequest
     * @return
     */
    JsonData register(UserRegisterRequest registerRequest);

    /**
     * 用户登录
     * @param userLoginRequest
     * @return
     */
    JsonData login(UserLoginRequest userLoginRequest);

    /**
     * 查询用户详情
     * @return
     */
    UserVO findUserDetail();

}
