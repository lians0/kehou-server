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




