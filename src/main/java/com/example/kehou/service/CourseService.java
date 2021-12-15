package com.example.kehou.service;

import com.example.kehou.domain.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface CourseService extends IService<Course> {

    Course getCourseByCourseId(String courseId);

    List<Course> getCourseListByCourseId(String subjectId);
}
