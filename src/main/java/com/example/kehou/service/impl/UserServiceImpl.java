package com.example.kehou.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.kehou.common.exception.job.ServiceException;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.entity.User;
import com.example.kehou.domain.model.LoginBody;
import com.example.kehou.service.UserService;
import com.example.kehou.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void register(LoginBody loginBody) {
        // 用户已经存在  用户名唯一
        if (BeanUtils.isNotNull(userMapper.getUserByUsername(loginBody.getUsername()))) {
            throw new ServiceException("用户己经存在");
        }

        // 用户不存在，插入
        User user = new User();
        // todo：密码加密，加盐
        user.setCreateTime(new Date());
        user.setUpdateTime(new Timestamp(new java.util.Date().getTime()));
        user.setUserName(loginBody.getUsername());
        user.setPassword(loginBody.getPassword());
        userMapper.insertUser(user);
    }
}




