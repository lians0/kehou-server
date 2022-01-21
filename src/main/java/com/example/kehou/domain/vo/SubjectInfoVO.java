package com.example.kehou.domain.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author ShuangLian
 * @date 2021/12/20 19:28
 */
@Data
public class SubjectInfoVO {

    private String subjectId;
    private String teacher;
    private String subjectName;
    private String subjectDesc;
    private String subjectIcon;

    /**
     * 参与人总数
     */
    private int joinTotal;
    /**
     * 该科目的总课程数
     */
    private int chapterTotal;
    /**
     * 当前用具是否已参加课程
     */
    private boolean isJoin;
    /**
     * 当前课程的所有课程
     */
    private List<ChapterVO> chapterList;

    @Data
    public static class ChapterVO {
        private Integer chapterId;
        /**
         * 课程名称
         */
        private String chapterName;
        /**
         * 所属学科
         */
        private Integer subjectId;
        /**
         * 创建时间
         */
        private Date createTime;
        /**
         * 该学科的该课程是否参与
         */
//        private boolean isJoin;
    }
}
