package com.huameng.service;

import java.util.List;

import com.huameng.bean.Sclass;
import com.huameng.bean.Student;
import com.huameng.mybatis.Page;

public interface StudentService {
public int insertStudent(Student student);
	
	public int deleteStudentById(int s_id);
	
	public int updateStudent(Student student);
	
	public Student selectStudentById(int s_id);
	
	public List<Student> selectStudentPageCount(int pageCount,int pageSize);
	
	public int selectPage();
	
	public List<Sclass> selectSclassAll();
	
	public Page<Student> selectStudentPageAll(int pageCount);
}
