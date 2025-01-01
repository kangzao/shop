package com.jep.shop.user.service.impl;

import com.jep.shop.common.util.JsonData;
import com.jep.shop.user.model.UserDO;
import com.jep.shop.user.mapper.UserMapper;
import com.jep.shop.user.request.UserLoginRequest;
import com.jep.shop.user.request.UserRegisterRequest;
import com.jep.shop.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jep.shop.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author enping.jep
 * @since 2024-09-28
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public JsonData register(UserRegisterRequest registerRequest) {
        return null;
    }

    @Override
    public JsonData login(UserLoginRequest userLoginRequest) {
        return null;
    }

    @Override
    public UserVO findUserDetail() {
        return null;
    }
}
