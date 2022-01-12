package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShuangLian
 * @date 2022/1/11 19:21
 */
@RestController
@Api(tags = "测试接口")
public class TestController {
    @PostMapping("test")
    public Result test(String name,int age){
        System.out.println(name);
        System.out.println(age);

        return null;
    }
}
