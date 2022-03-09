package com.example.kehou.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 将过滤器中的异常重新抛到Controller层
 *
 * @author ShuangLian
 * @date 2021/11/30 15:49
 */
@RestController
@Api(tags = "异常处理")
public class ExceptionController {

//    @Resource
//    private HttpServletRequest request;

    @RequestMapping("/err")
    public void rethrow(HttpServletRequest request) throws Exception {
        throw (Exception) request.getAttribute("exception");
    }
}
