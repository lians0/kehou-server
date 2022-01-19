package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.domain.entity.Favorites;
import com.example.kehou.domain.vo.FavoritesVO;
import com.example.kehou.service.FavoritesService;
import com.example.kehou.mapper.FavoritesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites>
        implements FavoritesService {

    @Resource
    private FavoritesMapper mapper;

    @Override
    public List<FavoritesVO> getFavoritesByUsername(String username) {
        return mapper.getFavoritesByUsername(username);
    }

    @Override
    public Integer delFavoriteByUserIdAndSubjectId(String userId, String subjectId) {
        QueryWrapper<Favorites> wrapper = new QueryWrapper<>();
        wrapper.eq("belong_id",userId)
                        .eq("subject_id",subjectId);

        return baseMapper.delete(wrapper);

    }

    @Override
    public Integer addFavoritesByUserIdAndSubjectId(String userId, String subjectId) {
        Favorites favorites = new Favorites();
        favorites.setSubjectId(Integer.valueOf(subjectId));
        favorites.setBelongId(Integer.valueOf(userId));
        return baseMapper.insert(favorites);
    }
}




