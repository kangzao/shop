package com.jep.shop.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author enping.jep
 * @date 2025/1/1 22:48
 **/
@ApiModel(value = "用户注册对象", description = "用户注册请求对象")
@Data
public class UserRegisterRequest {


    @ApiModelProperty(value = "昵称", example = "Anna小姐姐")
    private String name;

    @ApiModelProperty(value = "密码", example = "12345")
    private String pwd;


    @ApiModelProperty(value = "头像", example = "")
    @JsonProperty("head_img")
    private String headImg;

    @ApiModelProperty(value = "用户个人性签名", example = "人生需要动态规划，学习需要贪心算法")
    private String slogan;

    @ApiModelProperty(value = "0表示女，1表示男", example = "1")
    private Integer sex;

    @ApiModelProperty(value = "邮箱", example = "58761173@qq.com")
    private String mail;

    @ApiModelProperty(value = "验证码", example = "232343")
    private String code;


}
