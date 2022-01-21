package com.example.kehou.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 学科评价
 * @TableName comment_chapter
 */
@TableName(value ="comment_subject")
@Data
public class CommentSubject implements Serializable {
    /**
     * 学科评价id
     */
    @TableId(type = IdType.AUTO)
    private Integer commentId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 学科id
     */
    private Integer subjectId;

    /**
     * 学期id
     */
    private Integer semesterId;

    /**
     * 考试形式
     */
    private String testType;

    /**
     * 学科评价
     */
    private String commentText;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill. INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}