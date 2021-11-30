package com.example.kehou.service;

import com.example.kehou.domain.entity.Favorites;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface FavoritesService extends IService<Favorites> {

    Favorites getFavoritesByUsername(String username);
}
