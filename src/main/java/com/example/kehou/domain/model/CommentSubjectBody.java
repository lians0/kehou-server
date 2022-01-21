package com.example.kehou.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ShuangLian
 * @date 2022/1/12 17:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentSubjectBody {
    private Integer subjectId;
    private String testType;
    private String commentText;
}
