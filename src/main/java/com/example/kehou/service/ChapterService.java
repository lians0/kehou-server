package com.example.kehou.service;

import com.example.kehou.domain.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.kehou.domain.vo.SubjectInfoVO;

import java.util.List;


public interface ChapterService extends IService<Chapter> {

    /**
     * 根据课程id查课程
     *
     * @param chapterId
     * @return com.example.kehou.domain.entity.Chapter
     * @author ShuangLian
     * @date 2022/1/19
     */
    Chapter getChapterByChapterId(String chapterId);

    /**
     * 根据学科id查课程列表
     *
     * @param subjectId
     * @return
     * @author ShuangLian
     * @date 2022/1/19
     */
    List<Chapter> getChapterListBySubjectId(String subjectId);


    /**
     * 根据学科id查课程列表 可分页
     * @param subjectId
     * @param pageSize
     * @param pageNum
     * @param orderBy
     * @return java.util.List<com.example.kehou.domain.entity.Chapter>
     * @author ShuangLian
     * @date 2022/1/19
     */
    List<Chapter> getChapterListBySubjectId(String subjectId, Integer pageSize, Integer pageNum, Integer orderBy);

    /**
     * 获取课程详情，上课记录，用户<Strong>课程与学科</Strong>是否参与
     *
     * @param subjectId 学科Id
     * @author ShuangLian
     */
    SubjectInfoVO getChapterListAndSubjectInfoByChapterId(String subjectId);

    /**
     * 搜索课程 按时间倒叙 只要前三条
     *
     * @param searchValue like语句
     * @return java.util.List<com.example.kehou.domain.entity.Chapter>
     * @author ShuangLian
     * @date 2022/1/17
     */
    List<Chapter> searchChapter(String searchValue);
}
