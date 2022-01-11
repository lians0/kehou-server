package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity generator.domain.Course
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 根据课程id查课程
     */
    Course getCourseByCourseId(String courseId);

    /**
     * 根据学科id查课程列表
     * 按时间降序
     */
    List<Course> getCourseListByCourseId(String subjectId);

    /**
     * 根据学科id查课程列表
     * 可分页，指定时间排序规则
     */
    List<Course> getCourseListByCourseId(String subjectId,Integer start,Integer pageSize,Integer orderBy);


    /**
     * 查寻学科下的课程数
     */
    int countBySubjectId(String subjectId);

}