package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.model.LoginBody;
import com.example.kehou.service.UserService;
import com.example.kehou.service.system.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ShuangLian
 * @date 2021/11/24 16:27
 */
@RestController
public class RegisterController {

    @Resource
    private UserService userService;

    @Resource
    private LoginService loginService;

    @PostMapping("/register")
    public Result register(@RequestBody LoginBody loginBody){
        userService.register(loginBody);
        String token = loginService.login(loginBody);
        return Result.success("注册成功",token);
    }
}
