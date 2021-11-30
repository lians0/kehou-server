package com.example.kehou.service.impl;

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
}




