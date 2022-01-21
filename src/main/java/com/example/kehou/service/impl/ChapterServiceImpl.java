package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.entity.Chapter;
import com.example.kehou.domain.vo.FavoritesVO;
import com.example.kehou.domain.vo.SubjectInfoVO;
import com.example.kehou.domain.vo.SubjectDetailVO;
import com.example.kehou.mapper.ChapterMapper;
import com.example.kehou.mapper.FavoritesMapper;
import com.example.kehou.mapper.SubjectMapper;
import com.example.kehou.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter>
        implements ChapterService {
    @Resource
    private ChapterMapper chapterMapper;
    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private HttpServletRequest request;
    @Resource
    private FavoritesMapper favoritesMapper;


    /**
     * 根据课程id查课程
     */
    @Override
    public Chapter getChapterByChapterId(String chapterId) {
        return chapterMapper.getChapterByChapterId(chapterId);
    }

    /**
     * 根据学科id查课程列表
     */
    @Override
    public List<Chapter> getChapterListBySubjectId(String subjectId) {
        return chapterMapper.getChapterListByChapterId(subjectId);
    }

    /**
     * 根据学科id查课程列表 可分页
     *
     * @return 课程列表
     * @author shuanglian
     * @date 2022/1/13
     */
    @Override
    public List<Chapter> getChapterListBySubjectId(String subjectId, Integer pageSize, Integer pageNum, Integer orderBy) {
        int start;
        if (pageNum == 1) {
            start = 0;
        } else {
            start = (pageNum - 1) * pageSize - 1;
        }
        return chapterMapper.getChapterListByChapterIdPaging(subjectId, start, pageSize, orderBy);
    }


    /**
     * 获取课程详情，上课记录，用户<Strong>课程与学科</Strong>是否参与
     *
     * @param subjectId 学科Id
     * @author ShuangLian
     */
    @Override
    public SubjectInfoVO getChapterListAndSubjectInfoByChapterId(String subjectId) {
        SubjectInfoVO subjectInfoVO = new SubjectInfoVO();
        // 查询课程详情
        SubjectDetailVO subjectDetailBySubjectId = subjectMapper.getSubjectDetailBySubjectId(subjectId);
        // 查询课程总数
        QueryWrapper<Chapter> chapterQueryWrapper = new QueryWrapper<>();
        chapterQueryWrapper.eq("subject_id", subjectId);
        Integer chapterTotal = chapterMapper.selectCount(chapterQueryWrapper);
        subjectDetailBySubjectId.setChapterTotal(chapterTotal);
        // 复制属性->SubjectInfoVO
        BeanUtils.copyProperties(subjectDetailBySubjectId, subjectInfoVO);
        // 查询当前用户是否参加当前学科
        subjectInfoVO.setJoin(false);
        List<FavoritesVO> favoritesVOList = favoritesMapper.getFavoritesByUsername((String) request.getAttribute("username"));
        for (FavoritesVO favoritesVO : favoritesVOList) {
            if (favoritesVO.getSubjectId().equals(subjectId)) {
                subjectInfoVO.setJoin(true);
            }
        }
        // 查询所有课程
        List<Chapter> chapterList = chapterMapper.getChapterListByChapterId(subjectId);
        // 将课程list -->List<SubjectInfoVO.ChapterVO>
        List<SubjectInfoVO.ChapterVO> chapterList1 = new ArrayList<>();
        for (Chapter chapter : chapterList) {
            SubjectInfoVO.ChapterVO chapterVO = new SubjectInfoVO.ChapterVO();
            BeanUtils.copyProperties(chapter, chapterVO);
            // 查询当前用户是否参加
//            QueryWrapper<Record> recordQueryWrapper = new QueryWrapper<>();
//            recordQueryWrapper
//                    .eq("chapter_id", chapter.getChapterId())
//                    .eq("user_name", ContextUtils.getUsername());
//            Integer count = recordMapper.selectCount(recordQueryWrapper);
//            chapterVO.setJoin(count != 0);
            chapterList1.add(chapterVO);
        }
        subjectInfoVO.setChapterList(chapterList1);

        return subjectInfoVO;
    }

    /**
     * 查询课程
     * @param searchValue
     * @return java.util.List<com.example.kehou.domain.entity.Chapter>
     * @author ShuangLian
     * @date 2022/1/19
     */
    @Override
    public List<Chapter> searchChapter(String searchValue) {
        QueryWrapper<Chapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("chapter_name", searchValue)
                .orderByDesc("create_time")
                .last("limit 3");
        List<Chapter> chapterList = baseMapper.selectList(queryWrapper);
        return chapterList;
    }
}