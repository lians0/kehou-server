package com.example.kehou.config.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author ShuangLian
 * @date 2021/12/1 17:14
 */
public class PrintFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取请求头信息
        Enumeration headerNames = request.getHeaderNames();
        //使用循环遍历请求头，并通过getHeader()方法获取一个指定名称的头字段
        System.out.println("===================");
        while (headerNames.hasMoreElements()){
            String headerName = (String) headerNames.nextElement();
            System.out.println(headerName + " : " + request.getHeader(headerName));
        }
        System.out.println("===================");

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
