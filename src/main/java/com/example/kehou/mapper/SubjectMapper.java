package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.kehou.domain.vo.SubjectDetailVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.domain.Subject
 */
@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {
    SubjectDetailVO getSubjectDetailBySubjectId(String subjectId);
}




