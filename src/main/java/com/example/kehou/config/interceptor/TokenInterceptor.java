package com.example.kehou.config.interceptor;

import com.example.kehou.common.exception.job.TokenException;
import com.example.kehou.service.system.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ShuangLian
 * @date 2022/3/8 14:55
 */
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    /**
     * 处理前方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("处理前方法");

        String token = request.getHeader("Auth");

        if (StringUtils.isEmpty(token)) {
            throw new TokenException(request.getRequestURI() + " 你未登录,请登录");
        }
        log.info("用户token:[{}]", token);
        // token有效性验证
        String account = tokenService.validToken(token);
        log.info("用户:[{}],请求地址：{}", account, (request).getServletPath());
        request.setAttribute("username", account);

        return true;
    }

    /**
     * 处理后方法
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("处理后方法");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 处理完成方法
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("处理完成方法");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
