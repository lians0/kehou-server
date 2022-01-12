package com.example.kehou.service;

import com.example.kehou.domain.entity.CommentCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface CommentCourseService extends IService<CommentCourse> {

    /**
     * 根据课程id获取课程评价 时间升序
     * @param subjectId
     * @return java.util.List<com.example.kehou.domain.entity.CommentCourse>
     * @author shuanglian
     * @date 2022/1/12
     */
    List<CommentCourse> getCommentCourseBySubjectId(String subjectId);

    /**
     * 插入一条数据到CommentCourse
     * @param commentCourse
     * @return int
     * @author shuanglian
     * @date 2022/1/12
     */
    int addCommentCourse(CommentCourse commentCourse);
}
