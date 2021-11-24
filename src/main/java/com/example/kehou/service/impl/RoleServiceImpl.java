package com.example.kehou.service.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.domain.entity.Role;
import com.example.kehou.domain.entity.User;
import com.example.kehou.mapper.UserMapper;
import com.example.kehou.service.RoleService;
import com.example.kehou.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {


}




