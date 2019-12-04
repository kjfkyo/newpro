package com.gy.test;

import com.gy.bean.S_admin;
import com.gy.bean.S_student;
import com.gy.bean.S_teacher;
import com.gy.dao.SadminDao;
import com.gy.dao.SstudentDao;
import com.gy.dao.SteacherDao;
import com.gy.dao.impl.SadminDaoImpl;
import com.gy.dao.impl.SstudentDaoImpl;
import com.gy.dao.impl.SteacherDaoImpl;

public class Test {

	public static void main(String[] args) {
		SadminDao ad=new SadminDaoImpl();
		SstudentDao sd=new SstudentDaoImpl();
		SteacherDao td=new SteacherDaoImpl();
		
		S_admin admin=ad.adminLogin("admin", "1");
		System.out.println(admin);
		S_student student=sd.studentLogin("张三", "1");
		System.out.println(student);
		S_teacher teacher=td.teacherLogin("李四", "222");
		System.out.println(teacher);
	}

}
