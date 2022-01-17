package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.vo.SearchResultVO;
import com.example.kehou.service.system.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 搜索接口
 * @author ShuangLian
 * @date 2022/1/17 15:03
 */
@RestController
@RequestMapping("search")
public class SearchController {
    @Resource
    private SearchService searchService;

    // 查询课程，用户，记录
    @GetMapping("/{searchType}/{searchValue}")
    public Result searchAll(@PathVariable String searchType,@PathVariable String searchValue) {
        SearchResultVO searchResultVO = searchService.searchAll(searchType, searchValue);


        return Result.success(searchResultVO);
    }
}
