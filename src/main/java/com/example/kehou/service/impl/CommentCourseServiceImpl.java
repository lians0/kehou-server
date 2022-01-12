package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.domain.entity.CommentCourse;
import com.example.kehou.service.CommentCourseService;
import com.example.kehou.mapper.CommentCourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CommentCourseServiceImpl extends ServiceImpl<CommentCourseMapper, CommentCourse>
    implements CommentCourseService {

    @Override
    public List<CommentCourse> getCommentCourseBySubjectId(String subjectId) {
        QueryWrapper<CommentCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("subject_id",subjectId);
        wrapper.orderBy(true,true,"create_time");
        List<CommentCourse> courseList = baseMapper.selectList(wrapper);

        return courseList;
    }
}




