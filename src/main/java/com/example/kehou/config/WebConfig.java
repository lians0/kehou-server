package com.example.kehou.config;

import com.example.kehou.config.filter.ExceptionFilter;
import com.example.kehou.config.filter.PrintFilter;
import com.example.kehou.config.filter.TokenFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 *
 * @author ShuangLian
 * @date 2021/11/30 15:34
 */
@Slf4j
@Configuration
public class WebConfig {

    /**
     * 请求头打印
     */
//    @Bean
    public FilterRegistrationBean<PrintFilter> PrintFilterRegistration() {
        FilterRegistrationBean<PrintFilter> registration =
                new FilterRegistrationBean<>(new PrintFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(-1);
        registration.setName("PrintFilter");
        return registration;
    }

    /**
     * 异常捕获过滤器
     */
    @Bean
    public FilterRegistrationBean<ExceptionFilter> ExceptionFilterRegistration() {
        FilterRegistrationBean<ExceptionFilter> registration =
                new FilterRegistrationBean<>(new ExceptionFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(0);
        registration.setName("ExceptionFilter");
        return registration;
    }

    /**
     * token 检验过滤器
     */
    @Bean
    public FilterRegistrationBean<TokenFilter> TokenFilterRegistration() {
        FilterRegistrationBean<TokenFilter> registration =
                new FilterRegistrationBean<>(new TokenFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("excludedUris",
                "/login,/register,/swagger-resources.*,/doc.html,/v2.*,/webjars.*");
        registration.setOrder(1);
        registration.setName("TokenFilter");
        return registration;
    }
}
