package com.jep.shop.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jep.shop.user.model.AddressDO;
import com.jep.shop.user.mapper.AddressMapper;
import com.jep.shop.user.request.AddressAddReqeust;
import com.jep.shop.user.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jep.shop.user.vo.AddressVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 电商-公司收发货地址表 服务实现类
 * </p>
 *
 * @author enping.jep
 * @since 2024-09-28
 */
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressVO detail(Long id) {
        AddressDO addressDO = addressMapper.selectOne(new QueryWrapper<AddressDO>().eq("id", id));

        if (addressDO == null) {
            return null;
        }
        AddressVO addressVO = new AddressVO();
        BeanUtils.copyProperties(addressDO, addressVO);
        return addressVO;
    }

    @Override
    public void add(AddressAddReqeust addressAddReqeust) {

    }

    @Override
    public int del(int addressId) {
        return 0;
    }

    @Override
    public List<AddressVO> listUserAllAddress() {
        return List.of();
    }
}
