package com.jep.shop.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author enping
 * @date 2024/9/28 11:31
 **/
@Data
@ApiModel(value = "地址对象", description = "新增收货地址对象")
public class AddressAddReqeust {


    /**
     * 是否默认收货地址：0->否；1->是
     */
    @ApiModelProperty(value = "是否是否默认收货地址，0->否；1->是", example = "0")
    @JsonProperty("default_status")
    private Integer defaultStatus;

    /**
     * 收发货人姓名
     */
    @ApiModelProperty(value = "收发货人姓名", example = "山海")
    @JsonProperty("receive_name")
    private String receiveName;

    /**
     * 收货人电话
     */
    @ApiModelProperty(value = "收货人电话", example = "12321312321")
    private String phone;

    /**
     * 省/直辖市
     */
    @ApiModelProperty(value = "省/直辖市", example = "四川")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value = "城市", example = "成都")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty(value = "区", example = "天河区")
    private String region;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址", example = "运营中心-老王隔壁1号")
    @JsonProperty("detail_address")
    private String detailAddress;


}