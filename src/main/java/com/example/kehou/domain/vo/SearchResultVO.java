package com.example.kehou.domain.vo;

import com.example.kehou.domain.dto.ChapterSearchDTO;
import com.example.kehou.domain.dto.SubjectSearchDTO;
import lombok.Data;

import java.util.List;

/**
 * @author ShuangLian
 * @date 2022/1/17 16:43
 */
@Data
public class SearchResultVO {
    List<ChapterSearchDTO> chapterList;
    List<SubjectSearchDTO> subjectList;

}
