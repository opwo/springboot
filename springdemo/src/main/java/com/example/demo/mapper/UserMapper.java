package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;


@Mapper
@Transactional
public interface UserMapper {

	/**
	 * 根据用户名查询用户，用于登陆
	 * @param user_id
	 * @return
	 */
	@Select("SELECT * FROM ZBXL_USER WHERE USERNAME = #{username}")
	public User getUserByName(String username);
	
	/**
	 * 根据Id查询用户
	 * @param user_id
	 * @return
	 */
	@Select("SELECT * FROM ZBXL_USER WHERE ID = #{user_id}")
	public List<User> getUserById(int user_id);
	
	/**
	 * 返回所有用户列表
	 * @return
	 */
	@Select("SELECT * FROM ZBXL_USER")
	public List<User> findAllUser();
	
	@Insert("INSERT INTO ZBXL_USER VALUES(#{id},#{username},#{password},#{danWeiTID})")
	public boolean addUser(User user);
	
	@Update("UPDATE ZBXL_USER SET USERNAME=#{username}, PASSWORD=#{password}, DANWEITID=#{danWeiTID} WHERE ID = #{id}")
	public boolean editUser(User user);
	
	@Delete("DELETE FROM ZBXL_USER WHERE ID = #{id}")
	public boolean deleteUser(int id);
}
