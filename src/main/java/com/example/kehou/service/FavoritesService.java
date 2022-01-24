package com.example.kehou.service;

import com.example.kehou.domain.entity.Favorites;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.kehou.domain.vo.FavoritesVO;

import java.util.List;

/**
 *
 */
public interface FavoritesService extends IService<Favorites> {
    /**
     * 查询该用户所有收藏的科目
     * 按时间增序排列
     *
     * @param username
     * @return java.util.List<com.example.kehou.domain.vo.FavoritesVO>
     * @author ShuangLian
     * @date 2022/1/24
     */
    List<FavoritesVO> getFavoritesByUsername(String username);

    Integer delFavoriteByUserIdAndSubjectId(String userId, String subjectId);

    Integer addFavoritesByUserIdAndSubjectId(String userId, String subjectId);
}
