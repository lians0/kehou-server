package com.example.kehou.config;

import com.example.kehou.config.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author ShuangLian
 * @date 2021/12/15 18:08
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Bean
    public HandlerInterceptor getTokenInterceptor() {
        return new TokenInterceptor();
    }

    /**
     * 将访问资源路径映射到本地路径
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
        // 可添加多个
//        registry.addInterceptor(new TestFilter())
//                .addPathPatterns("/**");

        registry.addInterceptor(getTokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/v2/**", "/error", "/err", "/doc.html", "/webjars/**", "/swagger-resources/**", "/login", "/register");

    }

}
