package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_student;

public interface SstudentDao {
	public S_student studentLogin(@Param("name")String name,
			@Param("password")String password);
	public int modifyPassword(@Param("id")int id,
			@Param("password")String password);
	public int addStudentInfo(S_student s);
	public List<S_student> selectStudentAll();
	public List<S_student> selectStudentByParam(@Param("cid")int cid,
			@Param("id")int id,@Param("name")String name);
	public S_student selectStudentById(int id);
	public int modifyStudentInfo(S_student stu);
	public int removeStudentById(int id);
	public List<S_student> selectStudentByTid(int tid);
}
