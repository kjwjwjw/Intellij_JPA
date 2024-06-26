package com.example.boot2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);

        registry.addViewController("/").setViewName("/home/home");
        registry.addViewController("/home").setViewName("/home/home");
        registry.addViewController("/member/list").setViewName("/member/member_list");
        registry.addViewController("/member/join").setViewName("/member/member_join");

    }
}
