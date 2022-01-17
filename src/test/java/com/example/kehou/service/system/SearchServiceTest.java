package com.example.kehou.service.system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ShuangLian
 * @date 2022/1/17 18:53
 */
@SpringBootTest
class SearchServiceTest {

    @Resource
    private SearchService searchService;
    @Test
    void searchAll() {
        System.out.println(searchService.searchAll(null, "计算机"));
    }
}