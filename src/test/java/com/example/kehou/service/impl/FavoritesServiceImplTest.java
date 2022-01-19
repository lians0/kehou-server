package com.example.kehou.service.impl;

import com.example.kehou.mapper.FavoritesMapper;
import com.example.kehou.service.FavoritesService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ShuangLian
 * @date 2022/1/19 15:04
 */
@SpringBootTest
class FavoritesServiceImplTest {

    @Resource
    private FavoritesService favoritesService;
    @Test
    void delFavoriteByUserIdAndSubjectId() {
        System.out.println(favoritesService.delFavoriteByUserIdAndSubjectId("1", "5"));
    }

    @Test
    void addFavoritesByUserIdAndSubjectId() {
        System.out.println(favoritesService.addFavoritesByUserIdAndSubjectId("1", "1"));
    }
}