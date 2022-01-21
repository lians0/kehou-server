package com.example.kehou.domain.dto;

import lombok.Data;

/**
 * @author ShuangLian
 * @date 2022/1/17 16:47
 */
@Data
public class ChapterSearchDTO {
    /**
     * 学科Id
     */
    private Integer chapterId;

    /**
     * 学科名称
     */
    private String chapterName;

    /**
     * 所属学科名称
     */
    private String subjectName;
}
