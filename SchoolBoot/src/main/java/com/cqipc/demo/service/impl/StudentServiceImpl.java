package com.cqipc.demo.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.cqipc.demo.bean.Sclass;
import com.cqipc.demo.bean.Student;
import com.cqipc.demo.dao.SclassDao;
import com.cqipc.demo.dao.StudentDao;
import com.cqipc.demo.service.StudentService;
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Resource
	StudentDao studentDao;
	@Resource
	SclassDao sclassDao;
	
	@Override
	public int insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	@Override
	public int deleteStudentById(int s_id) {
		return studentDao.deleteStudentById(s_id);
	}

	@Override
	public int updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	@Override
	public Student selectStudentById(int s_id) {
		return studentDao.selectStudentById(s_id);
	}

	@Override
	public List<Student> selectStudentPageCount(int pageCount, int pageSize) {
		return studentDao.selectStudentPageCount(pageCount, pageSize);
	}

	@Override
	public int selectPage() {
		int num=studentDao.selectCount();
		int n=(num-1)/5+1;
		return n;
	}

	@Override
	public List<Sclass> selectSclassAll() {
		return sclassDao.selectSclassAll();
	}

	@Override
	public List<Student> selectStudentAll() {
		return studentDao.selectStudentAll();
	}


}
