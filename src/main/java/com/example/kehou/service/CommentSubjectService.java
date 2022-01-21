package com.example.kehou.service;

import com.example.kehou.domain.entity.CommentSubject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 *
 */
public interface CommentSubjectService extends IService<CommentSubject> {

    /**
     * 根据课程id获取课程评价 时间升序
     * @param subjectId
     * @return java.util.List<com.example.kehou.domain.entity.CommentSubject>
     * @author shuanglian
     * @date 2022/1/12
     */
    List<CommentSubject> getCommentSubjectBySubjectId(String subjectId);

    /**
     * 插入一条数据到CommentSubject
     * @param commentSubject
     * @return int
     * @author shuanglian
     * @date 2022/1/12
     */
    int addCommentSubject(CommentSubject commentSubject);
}
