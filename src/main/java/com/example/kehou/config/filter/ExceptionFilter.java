package com.example.kehou.config.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Objects;

/**
 * 异常捕获过滤器
 * @author ShuangLian
 * @date 2021/11/30 15:51
 */
@Slf4j
public class ExceptionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 是否已经放有异常栈, 避免循环
        boolean isRethrow = !Objects.isNull(request.getAttribute("exception"));
        if (isRethrow) {
            chain.doFilter(request, response);
            return;
        }
        // 捕获所有下层Filter的异常转发到=> /err
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            // 发生异常，保存异常栈
            request.setAttribute("exception", e);
            request.getRequestDispatcher("/err").forward(request, response);
        }
    }

}
