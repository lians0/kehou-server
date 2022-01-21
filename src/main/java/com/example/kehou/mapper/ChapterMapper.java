package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity generator.domain.Chapter
 */
@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {

    /**
     * 根据课程id查课程
     */
    Chapter getChapterByChapterId(String chapterId);

    /**
     * 根据学科id查课程列表
     * 按时间降序
     */
    List<Chapter> getChapterListByChapterId(String subjectId);

    /**
     * 根据学科id查课程列表
     * 可分页，指定时间排序规则
     */
    List<Chapter> getChapterListByChapterIdPaging(String subjectId, Integer start, Integer pageSize, Integer orderBy);


    /**
     * 查寻学科下的课程数
     */
    int countBySubjectId(String subjectId);

}