package com.example.kehou.domain.vo;

import lombok.Data;

/**
 * 课程详情也页VO
 *
 * @author ShuangLian
 * @date 2021/12/16 10:11
 */
@Data
public class SubjectDetailVO {

    private String teacher;
    private String subjectName;
    private String subjectDesc;

    /**
     * 参与人总数
     */
    private int joinTotal;
    /**
     * 该科目的总课程数
     */
    private int courseTotal;
}
