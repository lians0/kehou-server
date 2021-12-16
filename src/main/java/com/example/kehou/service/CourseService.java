package com.example.kehou.service;

import com.example.kehou.domain.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface CourseService extends IService<Course> {

    /**
     * 根据课程id查课程
     */
    Course getCourseByCourseId(String courseId);

    /**
     * 根据学科id查课程列表
     */
    List<Course> getCourseListByCourseId(String subjectId);
}
