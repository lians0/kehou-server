package com.example.kehou.config.filter;

import com.example.kehou.common.exception.job.TokenException;
import com.example.kehou.domain.entity.User;
import com.example.kehou.service.impl.UserServiceImpl;
import com.example.kehou.service.system.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Token 校验以及将当前用户信息放入request
 * @author ShuangLian
 * @date 2021/11/30 14:38
 */
@Slf4j
public class TokenFilter implements Filter {

    private String[] excludedUris ={};

    private final TokenService tokenService = new TokenService();
//    private final UserServiceImpl userService = new UserServiceImpl();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String param = filterConfig.getInitParameter("excludedUris");
        if (StringUtils.isNotBlank(param)) {
            this.excludedUris = param.split(",");
        }
        log.info(Arrays.toString(excludedUris));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        boolean isExcluded = false;
        for (String url:excludedUris) {
            if (Pattern.matches(url,httpRequest.getRequestURI())) {
//                log.info("忽略"+url);
                isExcluded = true;
                break;
            }
        }
        // 不在排除名单中验证token
        if(!isExcluded){
            String token = httpRequest.getHeader("Auth");
            if(StringUtils.isEmpty(token)){
                throw new TokenException(httpRequest.getRequestURI()+" 你未登录,请登录");
            }
            log.info(token);
            // token有效性验证
            String account = tokenService.validToken(token);
            log.info("用户=>>{}",account);
            httpRequest.setAttribute("username",account);
            // 使用username获取基本信息
//            User userByUsername = userService.getUserByUsername(account);
//            httpRequest.setAttribute("user",userByUsername);
        }
        chain.doFilter(request, response);
    }

}
