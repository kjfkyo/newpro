package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_attendance;
import com.gy.dao.SattendanceDao;

public class SattendanceDaoImpl extends BaseDao<SattendanceDao> 
implements SattendanceDao {
	
	public SattendanceDaoImpl() {
		this.setMapper(SattendanceDao.class);
	}

	@Override
	public List<S_attendance> selectAttendanceBySid(int sid) {
		return this.getMapper().selectAttendanceBySid(sid);
	}

	@Override
	public int addAttendanceInfo(S_attendance sa) {
		int count=this.getMapper().addAttendanceInfo(sa);
		this.session.commit();
		return count;
	}

	@Override
	public int removeAttendanceById(int id) {
		int count=this.getMapper().removeAttendanceById(id);
		this.session.commit();
		return count;
	}

	@Override
	public List<S_attendance> studentSearchAttendanceInfo(int sid, int scid,
			String attendance_date) {
		return this.getMapper().studentSearchAttendanceInfo(sid, scid, attendance_date);
	}

	@Override
	public List<S_attendance> searchAttendanceByTid(int tid) {
		return this.getMapper().searchAttendanceByTid(tid);
	}

	@Override
	public List<S_attendance> searchAttendanceByTidSidCid(int tid, int sid,
			int cid) {
		return this.getMapper().searchAttendanceByTidSidCid(tid, sid, cid);
	}

}
