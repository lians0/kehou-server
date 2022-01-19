package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.domain.entity.Subject;
import com.example.kehou.domain.vo.SubjectDetailVO;
import com.example.kehou.mapper.CourseMapper;
import com.example.kehou.mapper.FavoritesMapper;
import com.example.kehou.service.SubjectService;
import com.example.kehou.mapper.SubjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private FavoritesMapper favoritesMapper;

    @Override
    public Subject getSubjectBySubjectId(String subjectId) {
        return baseMapper.selectById(subjectId);
    }

    @Override
    public SubjectDetailVO getSubjectDetailBySubjectId(String subjectId) {

        SubjectDetailVO subjectDetailVO = subjectMapper.getSubjectDetailBySubjectId(subjectId);
        subjectDetailVO.setCourseTotal(courseMapper.countBySubjectId(subjectId));
        subjectDetailVO.setJoinTotal(favoritesMapper.countBySubjectId(subjectId));
        return subjectDetailVO;
    }

    @Override
    public List<Subject> searchSubject(String searchValue){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("subject_name",searchValue)
                .orderByDesc("create_time")
                .last("limit 3");
        List<Subject> subjectList = baseMapper.selectList(queryWrapper);
        return subjectList;
    }
}




