package com.example.kehou.service;

import com.example.kehou.domain.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.kehou.domain.vo.SubjectDetailVO;

public interface SubjectService extends IService<Subject> {
    SubjectDetailVO getSubjectDetailBySubjectId(String subjectId);
}
