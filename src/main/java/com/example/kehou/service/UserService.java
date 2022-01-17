package com.example.kehou.service;

import com.example.kehou.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.kehou.domain.model.LoginBody;

/**
 *
 */

public interface UserService extends IService<User> {

    User getUserByUsername(String username);

    User getUserByUserId(String userId);

    void register(LoginBody loginBody);
}
