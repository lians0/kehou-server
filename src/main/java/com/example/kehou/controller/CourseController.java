package com.example.kehou.controller;

import com.alibaba.fastjson.JSON;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.domain.entity.Record;
import com.example.kehou.domain.entity.User;
import com.example.kehou.domain.vo.CourseAndIsJoinVO;
import com.example.kehou.domain.vo.SubjectAndSubjectInfoVO;
import com.example.kehou.domain.vo.SubjectDetailVO;
import com.example.kehou.service.CourseService;
import com.example.kehou.service.RecordService;
import com.example.kehou.service.SubjectService;
import com.example.kehou.service.UserService;
import com.mysql.cj.xdevapi.JsonArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @Resource
    private UserService userService;
    @Resource
    private HttpServletRequest autowiredRequest;
    @Resource
    private RecordService recordService;

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

    @ApiOperation("根据学科id查课程列表和学生参与情况")
    @GetMapping("/getCourseList/{subjectId}")
    public Result getCourseListByCourseId(@PathVariable String subjectId) {
        String username = (String) autowiredRequest.getAttribute("username");
        User user = userService.getUserByUsername(username);
        // 查出课程id
        List<Course> courseList = courseService.getCourseListByCourseId(subjectId);
        // 查出该用户参加的所有课程记录
        List<Record> recordList = recordService.getRecordListByUserid(user.getUserId().toString());
        ArrayList<CourseAndIsJoinVO> courseAndIsJoinVOList = new ArrayList<>();
        for (Course course : courseList) {
            CourseAndIsJoinVO courseAndIsJoinVO = new CourseAndIsJoinVO();
            BeanUtils.copyProperties(course, courseAndIsJoinVO);
            courseAndIsJoinVO.setIsJoin(false);
            for (Record record : recordList) {
                if (Objects.equals(record.getCourseId(), course.getCourseId())) {
                    courseAndIsJoinVO.setIsJoin(true);
                    break;
                }
            }
            courseAndIsJoinVOList.add(courseAndIsJoinVO);
        }
        return Result.success(courseAndIsJoinVOList);
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
    public Result getCourseListByCourseId(String subjectId, @Nullable Integer pageSize,
                                          @Nullable Integer pageNum, @Nullable Integer orderBy) {
        if (pageNum == null || pageNum <= 0) {
            return Result.error("pageNum必须>0");
        }
        List<Course> courseList = courseService.getCourseListByCourseId(subjectId, pageSize, pageNum, orderBy);
        return Result.success(courseList);
    }

    // todo: 与/course/getCourseList/{{subjectId}}整合
    @ApiOperation("根据学科id查课程列表和上课记录")
    @GetMapping("/getCourseListAndSubjectInfo/{subjectId}")
    public Result getCourseListAndSubjectInfoByCourseId(@PathVariable String subjectId) {
        SubjectAndSubjectInfoVO courseListAndSubjectInfo =
                courseService.getCourseListAndSubjectInfoByCourseId(subjectId);
        return Result.success(courseListAndSubjectInfo);
    }

}