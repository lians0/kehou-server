package com.example.kehou.config.filter;

import com.example.kehou.common.exception.job.TokenException;
import com.example.kehou.service.system.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author ShuangLian
 * @date 2021/11/30 14:38
 */
@Slf4j
//@Component
public class TokenFilter implements Filter {

    private String[] excludedUris ={};

    private TokenService tokenService = new TokenService();


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
        boolean flag = false;
        for (String uri:excludedUris) {
            if (httpRequest.getRequestURI().equals(uri)){
                flag = true;
                break;
            }
        }
        if(!flag){
            String token = httpRequest.getHeader("Auth");
            if(StringUtils.isEmpty(token)){
                throw new TokenException("你未登录,请登录");
            }
            log.info(token);
            String account = tokenService.validToken(token);
            log.info("{}登录===>",account);
            httpRequest.setAttribute("username",account);
        }
        chain.doFilter(request, response);
    }

}
