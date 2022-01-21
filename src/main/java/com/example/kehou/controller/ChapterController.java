package com.example.kehou.controller;

import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Chapter;
import com.example.kehou.domain.vo.SubjectInfoVO;
import com.example.kehou.service.ChapterService;
import com.example.kehou.service.SubjectService;
import com.example.kehou.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Chapter)表控制层
 *
 * @author ShuangLian
 * @since 2021-11-30 17:36:43
 */
@RestController
@RequestMapping("/chapter")
@Api(tags = "章节相关接口")
public class ChapterController {
    /**
     * 服务对象
     */
    @Resource
    private ChapterService chapterService;
    @Resource
    private SubjectService subjectService;
    @Resource
    private UserService userService;
    @Resource
    private HttpServletRequest autowiredRequest;

    @ApiOperation("根据章节id查章节")
    @GetMapping("/getChapter/{chapterId}")
    public Result getChapterByChapterId(@PathVariable String chapterId) {

        Chapter chapter = chapterService.getChapterByChapterId(chapterId);
        if (BeanUtils.isNotNull(chapter)) {
            return Result.success(chapter);
        } else {
            return Result.success("{}");
        }
    }

    /**
     * 根据学科id查学科详情和上课记录
     * <p>
     * todo: 与/chapter/getChapterList/{{subjectId}}整合
     *
     * @param subjectId 学科Id
     * @return 学科详情和上课记录列表
     * @author ShuangLian
     * @date 2022/1/14
     */
    @ApiOperation("根据学科id查学科详情和上课记录列表")
    @GetMapping("/getChapterListAndSubjectInfo/{subjectId}")
    public Result getChapterListAndSubjectInfoByChapterId(@PathVariable String subjectId) {
        SubjectInfoVO chapterListAndSubjectInfo = chapterService.getChapterListAndSubjectInfoByChapterId(subjectId);
        return Result.success(chapterListAndSubjectInfo);
    }

}