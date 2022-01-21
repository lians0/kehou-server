package com.example.kehou.service;

import com.example.kehou.domain.entity.Chapter;
import com.example.kehou.domain.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.kehou.domain.vo.SubjectDetailVO;

import java.util.List;

public interface SubjectService extends IService<Subject> {
    Subject getSubjectBySubjectId(String subjectId);

    /**
     * 根据科目id查科目详情
     */
    SubjectDetailVO getSubjectDetailBySubjectId(String subjectId);

    /**
     * 搜索学科 按时间倒叙 只要前三条
     *
     * @param searchValue like语句
     * @return java.util.List<com.example.kehou.domain.entity.Subject>
     * @author ShuangLian
     * @date 2022/1/17
     */
    List<Subject> searchSubject(String searchValue);
}
