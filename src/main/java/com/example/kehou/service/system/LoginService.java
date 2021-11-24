package com.example.kehou.service.system;

import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.entity.User;
import com.example.kehou.domain.model.LoginBody;
import com.example.kehou.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ShuangLian
 * @date 2021/11/24 9:58
 */
@Slf4j
@Service
public class LoginService {
    @Resource
    private TokenService tokenService;

    @Resource
    private UserService userService;

    public String login(LoginBody loginBody){
        User user = userService.getUserByUsername(loginBody.getUsername());
        if (BeanUtils.isNull(user)) {

            log.info("用户不存在");
            return null;
        }

        return tokenService.createToken(loginBody.getUsername());
    }
}
