package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.service.CourseService;
import com.example.kehou.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{
    @Resource
    private CourseMapper courseMapper;

    @Override
    public Course getCourseByCourseId(String courseId) {
        return courseMapper.getCourseByCourseId(courseId);
    }

    @Override
    public List<Course> getCourseListByCourseId(String subjectId) {
        return courseMapper.getCourseListByCourseId(subjectId);
    }
}




