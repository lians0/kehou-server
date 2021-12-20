package com.example.kehou.mapper;

import com.example.kehou.domain.entity.Favorites;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.kehou.domain.vo.FavoritesVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity generator.domain.Favorites
 */
@Mapper
public interface FavoritesMapper extends BaseMapper<Favorites> {

    List<FavoritesVO> getFavoritesByUsername(String username);

    int countBySubjectId(String subjectId);
}