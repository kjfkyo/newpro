package com.gy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.bean.S_attendance;

public interface SattendanceDao {
	public List<S_attendance> selectAttendanceBySid(int sid);
	public int addAttendanceInfo(S_attendance sa);
	public int removeAttendanceById(int id);
	public List<S_attendance> studentSearchAttendanceInfo(
			@Param("sid")int sid,@Param("scid")int scid,
			@Param("attendance_date")String attendance_date);
	public List<S_attendance> searchAttendanceByTid(int tid);
	public List<S_attendance> searchAttendanceByTidSidCid(
			@Param("tid")int tid,@Param("sid")int sid,@Param("cid")int cid);
}
