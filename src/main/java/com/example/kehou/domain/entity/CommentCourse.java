package com.example.kehou.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 课程评价
 * @TableName comment_course
 */
@TableName(value ="comment_course")
@Data
public class CommentCourse implements Serializable {
    /**
     * 课程评价id
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
     * 课程评价
     */
    private String commentText;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}