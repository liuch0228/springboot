package com.example.lchtest.springbootdemo2.custominterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置自定义拦截器的url并注册到springMVC中,加上@Configuration注解
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // /api2/*是拦截目录，拦截路径最后一定要/**
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api2/*/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
