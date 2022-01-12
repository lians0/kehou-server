package com.example.kehou.controller;

import com.example.kehou.domain.entity.CommentCourse;
import com.example.kehou.service.CommentCourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 课程评价(CommentCourse)表控制层
 *
 * @author makejava
 * @since 2022-01-12 10:30:26
 */
@RestController
@RequestMapping("commentCourse")
public class CommentCourseController {
    /**
     * 服务对象
     */
    @Resource
    private CommentCourseService commentCourseService;



}