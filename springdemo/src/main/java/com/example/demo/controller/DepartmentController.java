package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.demo.mapper.DanWeiMapper;


@Controller
public class DepartmentController {
	
	@Autowired
	private DanWeiMapper dwMapper;
}
