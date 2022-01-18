package com.example.kehou.controller;

import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.CommentCourse;
import com.example.kehou.domain.entity.User;
import com.example.kehou.domain.model.CommentCourseBody;
import com.example.kehou.service.CommentCourseService;
import com.example.kehou.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程评价(CommentCourse)表控制层
 *
 * @author makejava
 * @since 2022-01-12 10:30:26
 */
@Api(tags = "课程评价接口")
@RestController
@RequestMapping("commentCourse")
public class CommentCourseController {
    /**
     * 服务对象
     */
    @Resource
    private CommentCourseService commentCourseService;

    @Resource
    private HttpServletRequest autowiredRequest;

    @Resource
    private UserService userService;


    /**
     * 根据课程id获取课程评价 时间升序
     *
     * @param subjectId
     * @return com.example.kehou.domain.Result
     * @author shuanglian
     * @date 2022/1/12
     */
    @ApiOperation("根据课程id获取课程评价")
    @PostMapping("getCommentCourseBySubjectId")
    public Result getCommentCourseBySubjectId(String subjectId) {
        List<CommentCourse> commentCourseList = commentCourseService.getCommentCourseBySubjectId(subjectId);
        return Result.success(commentCourseList);
    }

    @ApiOperation("添加课程评价test")
    @PostMapping("addCommentCourse")
    public Result addCommentCourse(@RequestBody CommentCourseBody commentCourseBody) {

        String username = (String) autowiredRequest.getAttribute("username");
        System.out.println(username);
        User user = userService.getUserByUsername(username);
        System.out.println(user);
        CommentCourse commentCourse = new CommentCourse();
        BeanUtils.copyProperties(commentCourseBody, commentCourse);
        BeanUtils.copyProperties(user, commentCourse);
        int insert = commentCourseService.addCommentCourse(commentCourse);

        return insert != 0 ? Result.success("添加评论成功") : Result.error("添加评论失败");
    }


}