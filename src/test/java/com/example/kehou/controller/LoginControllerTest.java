package com.example.kehou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kehou.domain.model.LoginBody;
import com.example.kehou.service.system.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author ShuangLian
 * @date 2021/12/12 22:05
 */

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    public MockMvc mockMvc;


    @Test
    void login() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/login")
                                .param("username", "lian")
                                .param("password", "123")
                                .contentType("application/json")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print()); //输出MvcResult到控制台
    }
}