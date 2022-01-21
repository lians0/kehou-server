package com.example.kehou.controller;

import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.CommentSubject;
import com.example.kehou.domain.entity.User;
import com.example.kehou.domain.model.CommentSubjectBody;
import com.example.kehou.service.CommentSubjectService;
import com.example.kehou.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 课程评价(CommentSubject)表控制层
 *
 * @author makejava
 * @since 2022-01-12 10:30:26
 */
@Api(tags = "学科评价接口")
@RestController
@RequestMapping("commentSubject")
public class CommentSubjectController {
    /**
     * 服务对象
     */
    @Resource
    private CommentSubjectService commentSubjectService;

    @Resource
    private HttpServletRequest autowiredRequest;

    @Resource
    private UserService userService;


    /**
     * 根据学科id获取课程评价 时间升序
     *
     * @param subjectId
     * @return com.example.kehou.domain.Result
     * @author shuanglian
     * @date 2022/1/12
     */
    @ApiOperation("根据学科id获取课程评价")
    @PostMapping("getCommentSubjectBySubjectId")
    public Result getCommentSubjectBySubjectId(String subjectId) {
        List<CommentSubject> commentSubjectList = commentSubjectService.getCommentSubjectBySubjectId(subjectId);
        return Result.success(commentSubjectList);
    }

    @ApiOperation("添加学科评价")
    @PostMapping("addCommentSubject")
    public Result addCommentSubject(@RequestBody CommentSubjectBody commentSubjectBody) {

        String username = (String) autowiredRequest.getAttribute("username");
        System.out.println(username);
        User user = userService.getUserByUsername(username);
        System.out.println(user);
        CommentSubject commentSubject = new CommentSubject();
        BeanUtils.copyProperties(commentSubjectBody, commentSubject);
        BeanUtils.copyProperties(user, commentSubject);
        int insert = commentSubjectService.addCommentSubject(commentSubject);

        return insert != 0 ? Result.success("添加评论成功") : Result.error("添加评论失败");
    }


}