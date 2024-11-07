package com.jep.shop.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author enping
 * @date 2024/9/28 09:53
 **/

@SpringBootApplication(scanBasePackages = {"com.jep.shop"})
@MapperScan("com.jep.shop.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
