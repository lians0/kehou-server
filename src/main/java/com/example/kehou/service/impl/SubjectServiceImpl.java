package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.domain.entity.Subject;
import com.example.kehou.domain.vo.SubjectDetailVO;
import com.example.kehou.mapper.CourseMapper;
import com.example.kehou.service.SubjectService;
import com.example.kehou.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject>
    implements SubjectService{
    @Resource
    private SubjectMapper subjectMapper;

    @Resource
    private CourseMapper courseMapper;

    @Override
    public SubjectDetailVO getSubjectDetailBySubjectId(String subjectId) {

        SubjectDetailVO subjectDetailVO = subjectMapper.getSubjectDetailBySubjectId(subjectId);
        subjectDetailVO.setCourseTotal(courseMapper.countBySubjectId(subjectId));
        return subjectDetailVO;
    }
}




