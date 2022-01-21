package com.example.kehou.controller;

import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.domain.vo.SubjectAndSubjectInfoVO;
import com.example.kehou.service.CourseService;
import com.example.kehou.service.SubjectService;
import com.example.kehou.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (Course)表控制层
 *
 * @author ShuangLian
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
    @Resource
    private UserService userService;
    @Resource
    private HttpServletRequest autowiredRequest;

    @GetMapping("/")
    public Result getCourseByUsername(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");

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

    /**
     * 根据学科id查课程列表 可分页
     *
     * @param subjectId 课程id
     * @param pageSize  分页大小
     * @param pageNum   当前是第几页
     * @param orderBy   todo:暂时没用
     * @return com.example.kehou.domain.Result
     * @author ShuangLian
     * @date 2022/1/13
     */
    @ApiOperation("根据学科id查课程列表 可分页")
    @PostMapping("/getCourseList")
    public Result getCourseListByCourseId(String subjectId, @Nullable Integer pageSize, @Nullable Integer pageNum, @Nullable Integer orderBy) {
        if (pageNum == null || pageNum <= 0) {
            return Result.error("pageNum必须>0");
        }
        List<Course> courseList = courseService.getCourseListBySubjectId(subjectId, pageSize, pageNum, orderBy);
        return Result.success(courseList);
    }

    /**
     * 根据学科id查学科详情和上课记录
     * <p>
     * todo: 与/course/getCourseList/{{subjectId}}整合
     *
     * @param subjectId 学科Id
     * @return 学科详情和上课记录列表
     * @author ShuangLian
     * @date 2022/1/14
     */
    @ApiOperation("根据学科id查学科详情和上课记录列表")
    @GetMapping("/getCourseListAndSubjectInfo/{subjectId}")
    public Result getCourseListAndSubjectInfoByCourseId(@PathVariable String subjectId) {
        SubjectAndSubjectInfoVO courseListAndSubjectInfo = courseService.getCourseListAndSubjectInfoByCourseId(subjectId);
        return Result.success(courseListAndSubjectInfo);
    }

}