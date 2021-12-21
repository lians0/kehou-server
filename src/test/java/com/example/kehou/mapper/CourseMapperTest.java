package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ShuangLian
 * @date 2021/12/16 9:49
 */
@SpringBootTest
//@RunWith(SpringRunner.class)
class CourseMapperTest {
    @Resource
    private CourseMapper courseMapper;

    @Test
    void getCourseByCourseId() {
    }

    @Test
    void getCourseListByCourseId() {
        List<Course> courseListByCourseId = courseMapper.getCourseListByCourseId("100");
        System.out.println(courseListByCourseId.size()==0);
    }

    @Test
    void countBySubjectId() {
        System.out.println(courseMapper.countBySubjectId("1"));
    }
}