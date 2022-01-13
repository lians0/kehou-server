package com.example.kehou.controller;

import com.alibaba.fastjson.JSON;
import com.example.kehou.domain.Result;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ShuangLian
 * @date 2022/1/13 17:09
 */
class CourseControllerTest {


    @Test
    void getCourseListByCourseId() {
        ArrayList<Object> objects = new ArrayList<>();
        Result result = new Result();
        System.out.println(JSON.toJSONString(result));
    }
}