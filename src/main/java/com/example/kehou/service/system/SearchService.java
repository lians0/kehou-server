package com.example.kehou.service.system;

import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.dto.CourseSearchDTO;
import com.example.kehou.domain.dto.SubjectSearchDTO;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.domain.entity.Subject;
import com.example.kehou.domain.vo.SearchResultVO;
import com.example.kehou.service.CourseService;
import com.example.kehou.service.SubjectService;
import com.example.kehou.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ShuangLian
 * @date 2022/1/17 15:13
 */


@Slf4j
@Service
public class SearchService {

    @Resource
    private CourseService courseService;
    @Resource
    private SubjectService subjectService;
    @Resource
    private UserService userService;

    public SearchResultVO searchAll(String searchType, String searchValue) {
        List<Course> courseList = courseService.searchCourse(searchValue);
        ArrayList<CourseSearchDTO> courseSearchDTOS = new ArrayList<>();
        if (courseList.size() != 0) {
            //遍历去查课程对应学科名
            for (Course course : courseList) {
                CourseSearchDTO courseSearchDTO = new CourseSearchDTO();
                BeanUtils.copyProperties(course, courseSearchDTO);
                String subjectName = subjectService.getSubjectBySubjectId(course.getSubjectId().toString()).getSubjectName();
                courseSearchDTO.setSubjectName(subjectName);
                courseSearchDTOS.add(courseSearchDTO);
            }
        }

        List<Subject> subjectList = subjectService.searchSubject(searchValue);
        ArrayList<SubjectSearchDTO> subjectSearchDTOS = new ArrayList<>();
        if (subjectList.size()!=0) {
            //遍历去查学科对应学老师
            for (Subject subject : subjectList) {
                SubjectSearchDTO subjectSearchDTO = new SubjectSearchDTO();
                BeanUtils.copyProperties(subject, subjectSearchDTO);
                String loginName = userService.getUserByUserId(subject.getCreatorId().toString()).getLoginName();
                subjectSearchDTO.setCreatorName(loginName);
                subjectSearchDTOS.add(subjectSearchDTO);
            }
        }
        SearchResultVO searchResultVO = new SearchResultVO();
        searchResultVO.setCourseList(courseSearchDTOS);
        searchResultVO.setSubjectList(subjectSearchDTOS);
        return searchResultVO;
    }

}
