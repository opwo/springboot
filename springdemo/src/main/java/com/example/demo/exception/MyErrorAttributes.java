package com.example.demo.exception;


import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes{

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object>  map = super.getErrorAttributes(webRequest, includeStackTrace);
		map.put("auth", "wangtong");
//		Map<String, Object>  extMap = (Map<String, Object>) webRequest.getAttribute("extErrorInfo", RequestAttributes.SCOPE_REQUEST);
//		map.putAll(extMap);
		return super.getErrorAttributes(webRequest, includeStackTrace);
	}

}
