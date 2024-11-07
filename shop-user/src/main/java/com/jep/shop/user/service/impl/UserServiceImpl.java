package com.jep.shop.user.service.impl;

import com.jep.shop.user.model.UserDO;
import com.jep.shop.user.mapper.UserMapper;
import com.jep.shop.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
