package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Favorites;
import com.example.kehou.service.FavoritesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Favorites)表控制层
 *
 * @author makejava
 * @since 2021-11-30 17:36:43
 */
@RestController
@RequestMapping("/favorites")
public class FavoritesController {
    /**
     * 服务对象
     */
    @Resource
    private FavoritesService favoritesService;

    /**
     *
     */
    @GetMapping("/getFavoritesByUsername")
    public Result getFavoritesByUsername(HttpServletRequest request){
        String username = (String) request.getAttribute("username");

        Favorites favorites = favoritesService.getFavoritesByUsername(username);


        return Result.success("获取参加学科",favorites);
    }

}