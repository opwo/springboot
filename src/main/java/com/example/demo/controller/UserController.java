package com.example.demo.controller;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@RequestMapping("/user/login")
	//@ResponseBody
	public String login(@RequestParam("username") String username, String pwd,
			HttpSession session) {
//		return "dashboard";
		session.setAttribute("loginUser", username);
		return "redirect:/main.html";//重定向，防止表单重交
	}
	
	@RequestMapping("/success")
	public String success(Map<Object, Object> map) {
		map.put("hello", "<h1>你好</h1>");
		map.put("users", Arrays.asList("张三","<h2>王五</h2>","lierg"));
		return "dashboard";
	}
}
