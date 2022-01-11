package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.common.utils.ContextUtils;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.domain.entity.Record;
import com.example.kehou.domain.vo.SubjectAndSubjectInfoVO;
import com.example.kehou.domain.vo.SubjectDetailVO;
import com.example.kehou.mapper.RecordMapper;
import com.example.kehou.mapper.SubjectMapper;
import com.example.kehou.service.CourseService;
import com.example.kehou.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
        implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Resource
    private SubjectMapper subjectMapper;

    @Resource
    private RecordMapper recordMapper;

    /**
     * 根据课程id查课程
     */
    @Override
    public Course getCourseByCourseId(String courseId) {
        return courseMapper.getCourseByCourseId(courseId);
    }

    /**
     * 根据学科id查课程列表
     */
    @Override
    public List<Course> getCourseListByCourseId(String subjectId) {
        return courseMapper.getCourseListByCourseId(subjectId);
    }

    /**
     * 根据学科id查课程列表 可分页
     */
    @Override
    public List<Course> getCourseListByCourseId(String subjectId, Integer pageSize, Integer pageNum, Integer orderBy) {
        int start;
        if (pageNum == 1) {
            start = 0;
        } else
            start = (pageNum - 1) * pageSize - 1;

        return courseMapper.getCourseListByCourseId(subjectId, start, pageSize, orderBy);
    }


    @Override
    public SubjectAndSubjectInfoVO getCourseListAndSubjectInfoByCourseId(String subjectId) {
        /*
            查询课程详情
            课程记录
                用户是否参加
         */
        SubjectAndSubjectInfoVO subjectAndSubjectInfoVO = new SubjectAndSubjectInfoVO();
        // 查询课程详情
        SubjectDetailVO subjectDetailBySubjectId = subjectMapper.getSubjectDetailBySubjectId(subjectId);
        // 查询课程总数
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("subject_id", subjectId);
        Integer courseTotal = courseMapper.selectCount(courseQueryWrapper);
        subjectDetailBySubjectId.setCourseTotal(courseTotal);
        // 复制属性->SubjectAndSubjectInfoVO
        BeanUtils.copyProperties(subjectDetailBySubjectId, subjectAndSubjectInfoVO);
        // 查询所有课程
        List<Course> courseList = courseMapper.getCourseListByCourseId(subjectId);
        // 将课程list -->List<SubjectAndSubjectInfoVO.CourseVO>
        List<SubjectAndSubjectInfoVO.CourseVO> courseList1 = new ArrayList<>();
        for (Course course : courseList) {
            SubjectAndSubjectInfoVO.CourseVO courseVO = new SubjectAndSubjectInfoVO.CourseVO();
            BeanUtils.copyProperties(course, courseVO);
            // 查询当前用户是否参加
            QueryWrapper<Record> recordQueryWrapper = new QueryWrapper<>();
            recordQueryWrapper
                    .eq("course_id", course.getCourseId())
                    .eq("user_name", ContextUtils.getUsername());
            Integer count = recordMapper.selectCount(recordQueryWrapper);
            courseVO.setJoin(!(count == 0));
            courseList1.add(courseVO);
        }
        subjectAndSubjectInfoVO.setCourseList(courseList1);

        return subjectAndSubjectInfoVO;
    }
}




