package com.jep.shop.user.service;

import com.jep.shop.user.model.AddressDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jep.shop.user.request.AddressAddReqeust;
import com.jep.shop.user.vo.AddressVO;

import java.util.List;

/**
 * <p>
 * 电商-公司收发货地址表 服务类
 * </p>
 *
 * @author enping.jep
 * @since 2024-09-28
 */
public interface AddressService {

    /**
     * 查找指定地址详情
     *
     * @param id
     * @return
     */
    AddressVO detail(Long id);

    /**
     * 新增收货地址
     *
     * @param addressAddReqeust
     */
    void add(AddressAddReqeust addressAddReqeust);

    /**
     * 根据id删除地址
     *
     * @param addressId
     * @return
     */
    int del(int addressId);

    /**
     * 查找用户全部收货地址
     *
     * @return
     */
    List<AddressVO> listUserAllAddress();

}