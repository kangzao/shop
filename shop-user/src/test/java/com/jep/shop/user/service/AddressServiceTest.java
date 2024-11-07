package com.jep.shop.user.service;

import com.jep.shop.user.UserApplication;
import com.jep.shop.user.vo.AddressVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author enping
 * @date 2024/9/28 17:17
 **/
@RunWith(SpringRunner.class)  //在 Spring 4 之后，SpringRunner 作为 JUnit4 的一个扩展，提供了对 Spring 测试上下文的集成支持。
@SpringBootTest(classes = UserApplication.class)
//@SpringBootTest 是 Spring Boot 提供的一个注解，用于指示 Spring Boot 测试框架加载完整的 Spring 应用程序上下文
@Slf4j
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;


    @Test
    public void testAddressDetail() {

        AddressVO addressvO = addressService.detail(Long.valueOf(1L));
        log.info(addressvO.toString());

        Assert.assertNotNull(addressvO);

    }
}
