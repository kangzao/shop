package com.jep.shop.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author enping.jep
 * @date 2025/1/1 22:53
 **/
@Data
@ApiModel(value = "登录对象", description = "用户登录请求对象")
public class UserLoginRequest {


    @ApiModelProperty(value = "邮箱", example = "58761173@qq.com")
    private String mail;

    @ApiModelProperty(value = "密码", example = "123456")
    private String pwd;


}
