package com.example.kehou.domain.vo;

import com.example.kehou.domain.dto.CourseSearchDTO;
import com.example.kehou.domain.dto.SubjectSearchDTO;
import lombok.Data;

import java.util.List;

/**
 * @author ShuangLian
 * @date 2022/1/17 16:43
 */
@Data
public class SearchResultVO {
    List<CourseSearchDTO> courseList;
    List<SubjectSearchDTO> subjectList;

}
