package com.example.kehou.controller;

import com.alibaba.fastjson.JSON;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.domain.vo.SubjectAndSubjectInfoVO;
import com.example.kehou.domain.vo.SubjectDetailVO;
import com.example.kehou.service.CourseService;
import com.example.kehou.service.SubjectService;
import com.mysql.cj.xdevapi.JsonArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
@Api(tags = "课程相关接口")
public class CourseController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;
    @Resource
    private SubjectService subjectService;

    @GetMapping("/")
    public Result getCourseByUsername(HttpServletRequest request) {
        String username = (String) request.getAttribute("account");

        return null;
    }

    @ApiOperation("根据课程id查课程")
    @GetMapping("/getCourse/{courseId}")
    public Result getCourseByCourseId(@PathVariable String courseId) {

        Course course = courseService.getCourseByCourseId(courseId);
        if (BeanUtils.isNotNull(course)) {
            return Result.success(course);
        } else {
            return Result.success("{}");
        }
    }

    // todo: 分页查询
    @ApiOperation("根据学科id查课程列表")
    @GetMapping("/getCourseList/{subjectId}")
    public Result getCourseListByCourseId(@PathVariable String subjectId) {
        List<Course> courseList = courseService.getCourseListByCourseId(subjectId);
        if (BeanUtils.isNotNull(courseList)) {
            return Result.success(courseList);
        } else {
            return Result.success("[]");
        }
    }

    @ApiOperation("根据学科id查课程列表 可分页")
    @PostMapping("/getCourseList")
    public Result getCourseListByCourseId(String subjectId, @Nullable Integer pageSize,@Nullable Integer pageNum,@Nullable Integer orderBy) {
        if (pageNum<=0) {
            return Result.error("pageNum必须>0");
        }
        List<Course> courseList = courseService.getCourseListByCourseId(subjectId,pageSize,pageNum,orderBy);
        if (BeanUtils.isNotNull(courseList)) {
            return Result.success(courseList);
        } else {
            return Result.success("[]");
        }
    }

    @ApiOperation("根据学科id查课程列表和上课记录")
    @GetMapping("/getCourseListAndSubjectInfo/{subjectId}")
    public Result getCourseListAndSubjectInfoByCourseId(@PathVariable String subjectId) {
        SubjectAndSubjectInfoVO courseListAndSubjectInfo = courseService.getCourseListAndSubjectInfoByCourseId(subjectId);
        if (BeanUtils.isNotNull(courseListAndSubjectInfo)) {
            return Result.success(courseListAndSubjectInfo);
        } else {
            return Result.success("{}");
        }
    }

}