package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.model.LoginBody;
import com.example.kehou.service.system.LoginService;
import com.example.kehou.service.system.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ShuangLian
 * @date 2021/11/23 10:22
 */
@Controller
@RequestMapping
public class LoginController {

    @Resource
    private LoginService loginService;

    @ResponseBody
    @PostMapping("/login")
    public Result login(@RequestBody LoginBody loginBody) {

        System.out.println(loginBody);

        String login = loginService.login(loginBody);


        return Result.success(login);
    }
}
