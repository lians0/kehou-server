package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Favorites;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.domain.Favorites
 */
@Mapper
public interface FavoritesMapper extends BaseMapper<Favorites> {

    Favorites getFavoritesByUsername(String username);
}




