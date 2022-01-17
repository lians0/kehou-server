package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.common.utils.ContextUtils;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.domain.entity.Record;
import com.example.kehou.domain.entity.User;
import com.example.kehou.domain.vo.FavoritesVO;
import com.example.kehou.domain.vo.SubjectAndSubjectInfoVO;
import com.example.kehou.domain.vo.SubjectDetailVO;
import com.example.kehou.mapper.*;
import com.example.kehou.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    @Resource
    private HttpServletRequest request;
    @Resource
    private FavoritesMapper favoritesMapper;


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
    public List<Course> getCourseListBySubjectId(String subjectId) {
        return courseMapper.getCourseListByCourseId(subjectId);
    }

    /**
     * 根据学科id查课程列表 可分页
     *
     * @return 课程列表
     * @author shuanglian
     * @date 2022/1/13
     */
    @Override
    public List<Course> getCourseListBySubjectId(String subjectId, Integer pageSize, Integer pageNum, Integer orderBy) {
        int start;
        if (pageNum == 1) {
            start = 0;
        } else
            start = (pageNum - 1) * pageSize - 1;
        return courseMapper.getCourseListByCourseIdPaging(subjectId, start, pageSize, orderBy);
    }


    /**
     * 获取课程详情，上课记录，用户<Strong>课程与学科</Strong>是否参与
     *
     * @param subjectId 学科Id
     * @author ShuangLian
     */
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
        // 查询当前用户是否参加当前课程
        subjectAndSubjectInfoVO.setJoin(false);
        List<FavoritesVO> favoritesVOList = favoritesMapper.getFavoritesByUsername((String) request.getAttribute("username"));
        for (FavoritesVO favoritesVO : favoritesVOList) {
            if (favoritesVO.getSubjectId().equals(subjectId)) {
                subjectAndSubjectInfoVO.setJoin(true);
            }
        }
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

    // 查询课程
    public List<Course> searchCourse(String searchValue) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("course_name", searchValue)
                .orderByDesc("create_time")
                .last("limit 3");
        List<Course> courseList = baseMapper.selectList(queryWrapper);
        return courseList;
    }
}




