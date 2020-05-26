package com.example.demoadmin.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()) // 添加拦截器
                .addPathPatterns("/admin/**") // 添加拦截路径，这些路径都要经过拦截器筛选
                .excludePathPatterns("/admin/login"); // 添加排除拦截路径
    }
}
