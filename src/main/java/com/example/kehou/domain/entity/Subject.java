package com.example.kehou.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName subject
 */
@TableName(value ="subject")
@Data
public class Subject implements Serializable {
    /**
     * 科目id
     */
    @TableId(type = IdType.AUTO)
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
     * 科目描述
     */
    private String subjectDesc;

    /**
     * 类别
     */
    private String category;

    /**
     * 创建者id
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}