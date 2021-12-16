package com.example.kehou.controller;

import com.alibaba.fastjson.JSON;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Subject;
import com.example.kehou.domain.vo.SubjectDetailVO;
import com.example.kehou.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Subject)表控制层
 *
 * @author makejava
 * @since 2021-11-30 17:36:41
 */
@RestController
@RequestMapping("/subject")
@Api(tags="科目相关接口")
public class SubjectController {
    /**
     * 服务对象
     */
    @Resource
    private SubjectService subjectService;

    @GetMapping("/")
    public Result getSubjectByUsername(HttpServletRequest request){

        return null;
    }

    /**
     * 用科目id查科目详情
     */
    @ApiOperation("用科目id查科目详情")
    @GetMapping("getSubjectDetail/{subjectId}")
    public Result getSubjectDetailBySubjectId(@PathVariable String subjectId){
        SubjectDetailVO subject = subjectService.getSubjectDetailBySubjectId(subjectId);
        if (BeanUtils.isNotNull(subject)) {
            return Result.success(JSON.toJSONString(subject));
        }
        return Result.success("{}");
    }
}