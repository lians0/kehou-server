package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.domain.entity.CommentSubject;
import com.example.kehou.service.CommentSubjectService;
import com.example.kehou.mapper.CommentSubjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CommentSubjectServiceImpl extends ServiceImpl<CommentSubjectMapper, CommentSubject>
    implements CommentSubjectService {

    @Override
    public List<CommentSubject> getCommentSubjectBySubjectId(String subjectId) {
        QueryWrapper<CommentSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("subject_id",subjectId);
        wrapper.orderBy(true,true,"create_time");
        List<CommentSubject> courseList = baseMapper.selectList(wrapper);

        return courseList;
    }

    @Override
    public int addCommentSubject(CommentSubject commentSubject) {
        int insert = baseMapper.insert(commentSubject);

        return insert;
    }
}




