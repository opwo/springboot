package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.DanWei;


@Mapper
@Transactional
public interface DanWeiMapper {
	/**
	 * 返回所有用户列表
	 * @return
	 */
	@Select("SELECT * FROM ZBXL_DANWEI")
	public List<DanWei> findAllDanWei();
}
