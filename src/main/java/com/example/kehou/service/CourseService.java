package com.example.kehou.service;

import com.example.kehou.domain.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.kehou.domain.vo.SubjectAndSubjectInfoVO;

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

    /**
     * 获取课程详情，上课记录，用户是否参与
     * @param subjectId
     * @return
     */
    SubjectAndSubjectInfoVO getCourseListAndSubjectInfoByCourseId(String subjectId);
}
