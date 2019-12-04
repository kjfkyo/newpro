package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_course;
import com.gy.dao.ScourseDao;

public class ScourseDaoImpl extends 
BaseDao<ScourseDao> implements ScourseDao {
	
	public ScourseDaoImpl() {
		this.setMapper(ScourseDao.class);
	}

	@Override
	public List<S_course> selectCourseAll() {
		return this.getMapper().selectCourseAll();
	}

	@Override
	public int addCourseInfo(S_course c) {
		int count=this.getMapper().addCourseInfo(c);
		this.session.commit();
		return count;
	}

	@Override
	public List<S_course> searchCourseInfo(int id, String name, int tid) {
		return this.getMapper().searchCourseInfo(id, name, tid);
	}

	@Override
	public int modifyCourseInfo(S_course c) {
		int count=this.getMapper().modifyCourseInfo(c);
		this.session.commit();
		return count;
	}

	@Override
	public int removeCourseById(int id) {
		int count=this.getMapper().removeCourseById(id);
		this.session.commit();
		return count;
	}

	@Override
	public S_course selectCourseById(int id) {
		return this.getMapper().selectCourseById(id);
	}

	@Override
	public List<S_course> selectStudentNotCourse(int sid) {
		return this.getMapper().selectStudentNotCourse(sid);
	}

	@Override
	public List<S_course> selectStudentCourseBySid(int sid) {
		return this.getMapper().selectStudentCourseBySid(sid);
	}
	
}
