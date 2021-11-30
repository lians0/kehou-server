package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.service.CourseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2021-11-30 17:36:43
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

    @GetMapping("/")
    public Result getCourseByUsername(HttpServletRequest request){
        String username = (String) request.getAttribute("account");

        return null;
    }



}