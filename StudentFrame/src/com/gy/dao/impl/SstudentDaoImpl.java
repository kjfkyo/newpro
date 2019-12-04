package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_student;
import com.gy.dao.SstudentDao;

public class SstudentDaoImpl extends BaseDao<SstudentDao> implements SstudentDao {
	
	public SstudentDaoImpl() {
		this.setMapper(SstudentDao.class);
	}

	@Override
	public S_student studentLogin(String name, String password) {
		return this.getMapper().studentLogin(name, password);
	}

	@Override
	public int modifyPassword(int id, String password) {
		int count=this.getMapper().modifyPassword(id, password);
		this.session.commit();
		return count;
	}

	@Override
	public int addStudentInfo(S_student s) {
		int count=this.getMapper().addStudentInfo(s);
		this.session.commit();
		return count;
	}

	@Override
	public List<S_student> selectStudentAll() {
		return this.getMapper().selectStudentAll();
	}

	@Override
	public List<S_student> selectStudentByParam(int cid, int id, String name) {
		return this.getMapper().selectStudentByParam(cid, id, name);
	}

	@Override
	public S_student selectStudentById(int id) {
		return this.getMapper().selectStudentById(id);
	}

	@Override
	public int modifyStudentInfo(S_student stu) {
		int count=this.getMapper().modifyStudentInfo(stu);
		this.session.commit();
		return count;
	}

	@Override
	public int removeStudentById(int id) {
		int count=this.getMapper().removeStudentById(id);
		this.session.commit();
		return count;
	}

	@Override
	public List<S_student> selectStudentByTid(int tid) {
		return this.getMapper().selectStudentByTid(tid);
	}

}
