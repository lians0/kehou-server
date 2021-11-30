package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Subject;
import com.example.kehou.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Subject)表控制层
 *
 * @author makejava
 * @since 2021-11-30 17:36:41
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectService subjectService;

    @GetMapping("/")
    public Result getSubjectByUsername(HttpServletRequest request){


        return null;
    }
}