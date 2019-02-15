package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {
	
//	@ExceptionHandler(Exception.class) //可定制自己的异常类
//	@ResponseBody
//	public Map<String, Object> handleException(Exception e){
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("code", "-1");
//		map.put("message", e.getMessage());
//		return map;
//	}

//	@ExceptionHandler(Exception.class) //自适应效果。浏览器看到页面和客户端看到json数据
//	public String handleExceptionToPage(Exception e, HttpServletRequest request){
//		Map<String, Object> map = new HashMap<String, Object>();
//		//主要传入我们的错误状态码。否则就不会进入我们自己的错误页面
//		request.setAttribute("javax.servlet.error.status_code", 500);
//		map.put("code", "-1");
//		map.put("message", e.getMessage());
//		//将需要的信息放的request请求域中.然后在自定义错误参数MYerrorattributes.java中获取放入。
//		request.setAttribute("extErrorInfo", map);
//		return "forward:/error";
//	}

}
