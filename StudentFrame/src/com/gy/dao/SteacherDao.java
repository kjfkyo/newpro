package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_teacher;

public interface SteacherDao {
	public S_teacher teacherLogin(@Param("name")String name,
			@Param("password")String password);
	public int modifyPassword(@Param("id")int id,
			@Param("password")String password);
	public int addTeacherInfo(S_teacher t);
	public List<S_teacher> selectTeacherAll();
	public List<S_teacher> selectTeacherSearch(@Param("id")int id,
			@Param("name")String name);
	public S_teacher selectTeacherById(int id);
	public int modifyTeacherInfo(S_teacher t);
}
