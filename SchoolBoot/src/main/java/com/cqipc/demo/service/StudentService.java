package com.cqipc.demo.service;

import java.util.List;

import com.cqipc.demo.bean.Sclass;
import com.cqipc.demo.bean.Student;


public interface StudentService {
public int insertStudent(Student student);
	
	public int deleteStudentById(int s_id);
	
	public int updateStudent(Student student);
	
	public Student selectStudentById(int s_id);
	
	public List<Student> selectStudentPageCount(int pageCount,int pageSize);
	
	public int selectPage();
	
	public List<Sclass> selectSclassAll();
	
	public List<Student> selectStudentAll();
	
}
