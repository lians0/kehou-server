package com.example.kehou.controller;


import com.example.kehou.domain.Result;
import com.example.kehou.domain.model.LoginBody;
import com.example.kehou.service.UserService;
import com.example.kehou.service.system.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * 用户表(User)表控制层
 *
 * @author LianShuang
 * @since 2022-01-12 10:50:31
 */
@Api(tags = "用户操作")
@RestController
@RequestMapping()
public class UserController {
    @Resource
    private LoginService loginService;

    @Resource
    private UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid LoginBody loginBody) {

        System.out.println(loginBody);

        String login = loginService.login(loginBody);
        return Result.success("登录成功",login);
    }


    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result register(@RequestBody LoginBody loginBody){
        userService.register(loginBody);
        String token = loginService.login(loginBody);
        return Result.success("注册成功",token);
    }
}