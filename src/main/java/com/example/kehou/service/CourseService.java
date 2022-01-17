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
    List<Course> getCourseListBySubjectId(String subjectId);

    /**
     * 根据学科id查课程列表 可分页
     */
    List<Course> getCourseListBySubjectId(String subjectId, Integer pageSize, Integer pageNum, Integer orderBy);

    /**
     * 获取课程详情，上课记录，用户<Strong>课程与学科</Strong>是否参与
     *
     * @param subjectId 学科Id
     * @author ShuangLian
     */
    SubjectAndSubjectInfoVO getCourseListAndSubjectInfoByCourseId(String subjectId);

    /**
     * 搜索课程 按时间倒叙 只要前三条
     *
     * @param searchValue like语句
     * @return java.util.List<com.example.kehou.domain.entity.Course>
     * @author ShuangLian
     * @date 2022/1/17
     */
    List<Course> searchCourse(String searchValue);
}
