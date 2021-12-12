package com.example.kehou.service;

import com.example.kehou.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ShuangLian
 * @date 2021/12/12 21:49
 */
@SpringBootTest
//当一个类用@RunWith注释或继承一个用@RunWith注释的类时，JUnit将调用它所引用的类来运行该类中的测试而不是开发者去在junit内部去构建它。我们在开发过程中使用这个特性。
//@RunWith(SpringRunner.class)
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void getUserByUsername() {
        User lian = userService.getUserByUsername("lian");
        System.out.println(lian);

    }

    @Test
    void register() {
    }
}