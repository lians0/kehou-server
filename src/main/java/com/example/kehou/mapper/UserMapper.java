package com.example.kehou.mapper;

import com.example.kehou.domain.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.kehou.domain.model.LoginBody;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getUserByUsername(String username);

    void insertUser(User user);
}




