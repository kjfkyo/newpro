package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_selected_course;
import com.gy.dao.SselectedCourseDao;

public class SselectedCourseDaoImpl extends BaseDao<SselectedCourseDao> implements
		SselectedCourseDao {
	
	public SselectedCourseDaoImpl() {
		this.setMapper(SselectedCourseDao.class);
	}

	@Override
	public List<S_selected_course> selectSelectedCourseAll() {
		return this.getMapper().selectSelectedCourseAll();
	}

	@Override
	public List<S_selected_course> selectSelectedCourseYes(int sid) {
		return this.getMapper().selectSelectedCourseYes(sid);
	}

	@Override
	public int addSelectedCourse(S_selected_course ssc) {
		int count=this.getMapper().addSelectedCourse(ssc);
		this.session.commit();
		return count;
	}

	@Override
	public int removeSelectedCourse(int sid, int cid) {
		int count=this.getMapper().removeSelectedCourse(sid, cid);
		this.session.commit();
		return count;
	}

}
