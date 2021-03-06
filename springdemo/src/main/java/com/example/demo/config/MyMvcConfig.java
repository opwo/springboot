package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.component.LoginHandleInterceptor;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer{
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("main.html").setViewName("home");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandleInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/","/user/login","/assets/**");
	}

}
