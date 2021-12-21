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
    /**
     * 根据SubjectId查询学科详情
     * <strong>不包含课程总数</strong>
     * @author shuanglian
     * @date 2021/12/21
     */
    SubjectDetailVO getSubjectDetailBySubjectId(String subjectId);
}




