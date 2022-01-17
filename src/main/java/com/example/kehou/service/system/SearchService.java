package com.example.kehou.service.system;

import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.dto.CourseDTO;
import com.example.kehou.domain.dto.SubjectDTO;
import com.example.kehou.domain.entity.Course;
import com.example.kehou.domain.entity.Subject;
import com.example.kehou.domain.vo.SearchResultVO;
import com.example.kehou.service.CourseService;
import com.example.kehou.service.SubjectService;
import com.example.kehou.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        ArrayList<CourseDTO> courseDTOS = new ArrayList<>();
        if (courseList.size() != 0) {
            //遍历去查课程对应学科名
            for (Course course : courseList) {
                CourseDTO courseDTO = new CourseDTO();
                BeanUtils.copyProperties(course, courseDTO);
                String subjectName = subjectService.getSubjectBySubjectId(course.getSubjectId().toString()).getSubjectName();
                courseDTO.setSubjectName(subjectName);
                courseDTOS.add(courseDTO);
            }
        }

        List<Subject> subjectList = subjectService.searchSubject(searchValue);
        ArrayList<SubjectDTO> subjectDTOS = new ArrayList<>();
        if (subjectList.size()!=0) {
            //遍历去查学科对应学老师
            for (Subject subject : subjectList) {
                SubjectDTO subjectDTO = new SubjectDTO();
                BeanUtils.copyProperties(subject,subjectDTO);
                String loginName = userService.getUserByUserId(subject.getCreatorId().toString()).getLoginName();
                subjectDTO.setCreatorName(loginName);
                subjectDTOS.add(subjectDTO);
            }
        }
        SearchResultVO searchResultVO = new SearchResultVO();
        searchResultVO.setCourseList(courseDTOS);
        searchResultVO.setSubjectList(subjectDTOS);
        return searchResultVO;
    }

}
