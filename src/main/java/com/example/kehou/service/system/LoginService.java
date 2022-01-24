package com.example.kehou.service.system;

import com.example.kehou.common.exception.job.ServiceException;
import com.example.kehou.common.utils.BeanUtils;
import com.example.kehou.domain.entity.User;
import com.example.kehou.domain.model.LoginBody;
import com.example.kehou.domain.vo.UserInfoVO;
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

    public UserInfoVO login(String username, String password){
        User user = userService.getUserByUsername(username);
        UserInfoVO userInfoVO = new UserInfoVO();
        if (BeanUtils.isNull(user)) {
            log.info("用户不存在");
            throw new ServiceException("用户不存在");
        }else {
            if (StringUtils.equals(password,user.getPassword())) {
                BeanUtils.copyProperties(user,userInfoVO);
                // 将用户名放入token (用户名唯一)
                userInfoVO.setToken(tokenService.createToken(username));
            }else {
                throw new ServiceException("密码错误");
            }
        }
        return userInfoVO;
    }
}
