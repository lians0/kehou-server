package com.example.kehou.service;

import com.example.kehou.domain.entity.Favorites;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.kehou.domain.vo.FavoritesVO;

import java.util.List;

/**
 *
 */
public interface FavoritesService extends IService<Favorites> {

    List<FavoritesVO> getFavoritesByUsername(String username);

    Integer delFavoriteByUserIdAndSubjectId(String userId, String subjectId);

    Integer addFavoritesByUserIdAndSubjectId(String userId, String subjectId);
}
