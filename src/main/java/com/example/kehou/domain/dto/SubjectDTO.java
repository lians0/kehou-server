package com.example.kehou.domain.dto;

import lombok.Data;

/**
 * @author ShuangLian
 * @date 2022/1/17 17:15
 */
@Data
public class SubjectDTO {

    /**
     * 学科Id
     */
    private Integer subjectId;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类别
     */
    private String category;

    /**
     * 创建者姓名
     */
    private String creatorName;


}
