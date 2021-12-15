package com.example.kehou.controller;

import com.alibaba.fastjson.JSON;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.service.CourseService;
import com.mysql.cj.xdevapi.JsonArray;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @ApiOperation("根据课程id查课程")
    @GetMapping("/getCourse/{courseId}")
    public Result getCourseByCourseId(@PathVariable String courseId){

        Course course = courseService.getCourseByCourseId(courseId);
        if(BeanUtils.isNotNull(course)) {
            return Result.success(JSON.toJSONString(course));
        }else{
            return Result.success("{e}");
        }
    }

    @ApiOperation("根据学科id查课程列表")
    @GetMapping("/getCourseList/{subjectId}")
    public Result getCourseListByCourseId(@PathVariable String subjectId){

        List<Course> courseList = courseService.getCourseListByCourseId(subjectId);
        if(BeanUtils.isNotNull(courseList)) {
            return Result.success(JSON.toJSONString(courseList));
        }else{
            return Result.success("[]");
        }
    }


}