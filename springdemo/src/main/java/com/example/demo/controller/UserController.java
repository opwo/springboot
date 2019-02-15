package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.DanWei;
import com.example.demo.entity.User;
import com.example.demo.mapper.DanWeiMapper;
import com.example.demo.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private DanWeiMapper dwMapper;
	
	@RequestMapping("/user/login")
	//@ResponseBody
	public String login(@RequestParam("username") String username, String pwd,
			HttpSession session, Map<Object, Object> map) {
		User user = userMapper.getUserByName(username);
		if(user == null){
            map.put("loginMsg", "用户不存在");
            return "/login";
        }else if (!pwd.equals(user.getPassword())){
            map.put("loginMsg", "密码错误");
            return "/login";
        }else {
        	session.setAttribute("loginUser", username);
        	return "redirect:/main.html";//重定向，防止表单重交
        }
		
		
	}
	
	/**
	 * 查询所有用户
	 * @param map
	 * @return
	 */
	@GetMapping("/users")
	public String getUsers(Map<Object, Object> map) {
		List<User> users = userMapper.findAllUser();
		map.put("users",users);
		return "users/list";
	}
	
	/**
	 * 跳转至添加用户界面
	 * @param map
	 * @return
	 */
	@GetMapping("/user")
	public String toAddPage(Map<Object, Object> map) {
		//查询部门信息返回到添加页面
		List<DanWei> depts = dwMapper.findAllDanWei();
		map.put("depts",depts);
		return "users/add";
	}
	
	/**
	 * 跳转至修改用户界面
	 * @param map
	 * @return
	 */
	@GetMapping("/user/{id}")
	public String toEditPage(@PathVariable("id") int id, Map<Object, Object> map) {
		//查询部门信息返回到添加页面
		List<User> users = userMapper.getUserById(id);
		List<DanWei> depts = dwMapper.findAllDanWei();
		map.put("depts",depts);
		User user = users.get(0);
		map.put("user",user);
		return "users/add";
	}
	
	/**
	 * 添加用户
	 * @param map
	 * @return
	 */
	@PostMapping("/user")
	public String addUser(User user) {
		//查询部门信息返回到添加页面
		log.info("addUser {}", user);
		userMapper.addUser(user);
		//redirect:重定向到一个地址;forward:转发到一个地址;
		return "redirect:/users";
	}
	
	/**
	 * 修改用户
	 * @param map
	 * @return
	 */
	@PutMapping("/user")
	public String editUser(User user) {
		//查询部门信息返回到添加页面
		log.info("edit {}", user);
		userMapper.editUser(user);
		//redirect:重定向到一个地址;forward:转发到一个地址;
		return "redirect:/users";
	}
	
	/**
	 * 跳转至修改用户界面
	 * @param map
	 * @return
	 */
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") int id, Map<Object, Object> map) {
		//查询部门信息返回到添加页面
		userMapper.deleteUser(id);
		log.info("deleteUser {}", id);
		return "redirect:/users";
	}
}
