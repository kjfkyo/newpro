package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_selected_course;

public interface SselectedCourseDao {
	public List<S_selected_course> selectSelectedCourseAll();
	public List<S_selected_course> selectSelectedCourseYes(int sid);
	public int addSelectedCourse(S_selected_course ssc);
	public int removeSelectedCourse(@Param("sid")int sid,
			@Param("cid")int cid);
}
