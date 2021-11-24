package com.example.kehou.service;

import com.example.kehou.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 *
 */

public interface UserService extends IService<User> {

    public User getUserByUsername(String username);

}
