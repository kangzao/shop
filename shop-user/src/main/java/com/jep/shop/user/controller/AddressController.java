package com.jep.shop.user.controller;


import com.jep.shop.common.enums.BizCodeEnum;
import com.jep.shop.common.util.JsonData;
import com.jep.shop.user.service.AddressService;
import com.jep.shop.user.vo.AddressVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 电商-公司收发货地址表 前端控制器
 * </p>
 *
 * @author enping.jep
 * @since 2024-09-28
 */
@Api(tags = "收货地址模块")
@RestController
@RequestMapping("/api/address/v1/")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /**
     * 根据id查找地址详情
     *
     * @param addressId
     * @return
     */
    @ApiOperation("根据id查找地址详情")
    @GetMapping("/find/{address_id}")
    public JsonData detail(@ApiParam(value = "地址id", required = true) @PathVariable("address_id") long addressId) {
        AddressVO addressVO = addressService.detail(addressId);
        return addressVO == null ? JsonData.buildResult(BizCodeEnum.ADDRESS_NO_EXITS) : JsonData.buildSuccess(addressVO);
    }
}

