package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_teacher;
import com.gy.dao.SteacherDao;

public class SteacherDaoImpl extends BaseDao<SteacherDao> implements SteacherDao {
	
	public SteacherDaoImpl() {
		this.setMapper(SteacherDao.class);
	}

	@Override
	public S_teacher teacherLogin(String name, String password) {
		return this.getMapper().teacherLogin(name, password);
	}

	@Override
	public int modifyPassword(int id, String password) {
		int count=this.getMapper().modifyPassword(id, password);
		this.session.commit();
		return count;
	}

	@Override
	public int addTeacherInfo(S_teacher t) {
		int count=this.getMapper().addTeacherInfo(t);
		this.session.commit();
		return count;
	}

	@Override
	public List<S_teacher> selectTeacherAll() {
		return this.getMapper().selectTeacherAll();
	}

	@Override
	public List<S_teacher> selectTeacherSearch(int id, String name) {
		return this.getMapper().selectTeacherSearch(id, name);
	}

	@Override
	public S_teacher selectTeacherById(int id) {
		return this.getMapper().selectTeacherById(id);
	}

	@Override
	public int modifyTeacherInfo(S_teacher t) {
		int count=this.getMapper().modifyTeacherInfo(t);
		this.session.commit();
		return count;
	}

}
