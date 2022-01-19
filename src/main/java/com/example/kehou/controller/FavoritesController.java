package com.example.kehou.controller;

import com.example.kehou.domain.Result;
import com.example.kehou.domain.entity.Favorites;
import com.example.kehou.domain.vo.FavoritesVO;
import com.example.kehou.service.FavoritesService;
import com.example.kehou.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import net.minidev.json.JSONArray;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (Favorites)表控制层
 *
 * @author ShuangLian
 * @since 2021-11-30 17:36:43
 */
@RestController
@RequestMapping("/favorites")
@Api(tags = "收藏夹（参与）课程相关接口")
public class FavoritesController {
    /**
     * 服务对象
     */
    @Resource
    private FavoritesService favoritesService;
    @Resource
    private HttpServletRequest request;
    @Resource
    private UserService userService;

    /**
     * 查询该用户所有收藏的科目
     *
     * @author shuanglian
     * @date 2021/12/15
     */
    @ApiOperation("查询该用户所有收藏的科目")
    @GetMapping("/getFavoritesByUsername")
    public Result getFavoritesByUsername(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        List<FavoritesVO> favorites = favoritesService.getFavoritesByUsername(username);
        return Result.success("获取所有收藏学科", JSONArray.toJSONString(favorites));
    }

    /**
     * 取消参加某门科目
     *
     * @param subjectId 科目Id
     * @return com.example.kehou.domain.Result
     * @author ShuangLian
     * @date 2022/1/19
     */
    @ApiOperation("取消参加某门科目")
    @GetMapping("del/{subjectId}")
    public Result delSubjectFromFavoritesBySubjectId(@PathVariable String subjectId) {
        String username = (String) request.getAttribute("username");
        Integer userId = userService.getUserByUsername(username).getUserId();
        favoritesService.delFavoriteByUserIdAndSubjectId(userId.toString(), subjectId);
        return Result.success();
    }

    /**
     * 参加某门科目
     *
     * @param subjectId 科目Id
     * @return com.example.kehou.domain.Result
     * @author ShuangLian
     * @date 2022/1/19
     */
    @ApiOperation("参加某门科目")
    @GetMapping("add/{subjectId}")
    public Result addFavoritesByUserIdAndSubjectId(@PathVariable String subjectId) {
        String username = (String) request.getAttribute("username");
        Integer userId = userService.getUserByUsername(username).getUserId();
        favoritesService.addFavoritesByUserIdAndSubjectId(userId.toString(), subjectId);
        return Result.success();
    }

}