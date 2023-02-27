package com.zyx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 张宇森
 * @version 1.0
 */
@Configuration

public class MvcConfig implements WebMvcConfigurer {
    //视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    //自定义的国际化组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MvcLocaleResolver();
    }

    //自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MvcLoginInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/asserts/**");
    }
}
