package com.jep.shop.user.service;

import com.jep.shop.common.enums.SendCodeEnum;
import com.jep.shop.common.util.JsonData;

public interface NotifyService {

    /**
     * 发送验证码
     */
    JsonData sendCode(SendCodeEnum sendCodeEnum, String to );


    /**
     * 判断验证码是否一样
     */
    boolean checkCode(SendCodeEnum sendCodeEnum,String to, String code);

}
