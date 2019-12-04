package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_course;

public interface ScourseDao {
	public List<S_course> selectCourseAll();
	public int addCourseInfo(S_course c);
	public List<S_course> searchCourseInfo(@Param("id")int id,
			@Param("name")String name,@Param("tid")int tid);
	public int modifyCourseInfo(S_course c);
	@Delete("delete from s_course where id=#{id}")
	public int removeCourseById(int id);
	public S_course selectCourseById(int id);
	public List<S_course> selectStudentNotCourse(int sid);
	public List<S_course> selectStudentCourseBySid(int sid);
}
