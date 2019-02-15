package com.example.demo.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class User implements Serializable{
	private int id;
	@NotBlank(message="用户名不能为空")
	private String username;
	private String password;
	private String danWeiTID;
}