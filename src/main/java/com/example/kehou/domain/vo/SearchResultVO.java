package com.example.kehou.domain.vo;

import com.example.kehou.domain.dto.CourseDTO;
import com.example.kehou.domain.dto.SubjectDTO;
import lombok.Data;

import java.util.List;

/**
 * @author ShuangLian
 * @date 2022/1/17 16:43
 */
@Data
public class SearchResultVO {
    List<CourseDTO> courseList;
    List<SubjectDTO> subjectList;

}
