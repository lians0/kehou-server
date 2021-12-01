package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Favorites;
import com.example.kehou.domain.vo.FavoritesVO;
import com.example.kehou.service.FavoritesService;
import net.minidev.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
     * 查询该用户所有收藏的科目
     */
    @GetMapping("/getFavoritesByUsername")
    public Result getFavoritesByUsername(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        List<FavoritesVO> favorites = favoritesService.getFavoritesByUsername(username);
        return Result.success("获取所有收藏学科", JSONArray.toJSONString(favorites));
    }

}