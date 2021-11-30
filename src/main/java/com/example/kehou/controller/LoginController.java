package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.model.LoginBody;
import com.example.kehou.service.system.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 登录模块
 * @author ShuangLian
 * @date 2021/11/23 10:22
 */
@RestController
@RequestMapping
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginBody loginBody) {

        System.out.println(loginBody);

        String login = loginService.login(loginBody);
        return Result.success("登录成功",login);
    }


}
