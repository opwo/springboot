package com.example.demo.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filter.MyFilter;
import com.example.demo.servlet.MyServlet;

@Configuration
public class MyServerConfig {
	//注册三大组件[servlet, filter, listener]
	@Bean
	public ServletRegistrationBean<MyServlet> myServletCfg(){
		ServletRegistrationBean<MyServlet> servlet = new ServletRegistrationBean<MyServlet>(new MyServlet(), "/servlet");
		servlet.setLoadOnStartup(1); //优先加载
		return servlet;
	}
	
	@Bean
	public FilterRegistrationBean<MyFilter> myfilter(){
		FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<MyFilter>();
		filterRegistrationBean.setFilter(new MyFilter());
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/servlet", "/"));
		return filterRegistrationBean;
	}
	
	
}
