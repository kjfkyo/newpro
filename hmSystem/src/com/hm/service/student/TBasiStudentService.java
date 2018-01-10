package com.hm.service.student;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.entity.student.TBasiStudent;
import com.hm.mapper.student.TBasiStudentMapper;
import com.hm.mybatis.Page;
import com.hm.util.Constants;
import com.hm.util.Dictionary;
import com.hm.util.IDUtil;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-09-08.
 */
@Service
@Transactional(readOnly = true)
public class TBasiStudentService {
	
	@Autowired
	private TBasiStudentMapper tBasiStudentMapper;
	@Autowired
	private TAdvancedStudentService tAdvancedStudentService;
	
	/**
	 * 添加学员
	 */
	@Transactional(readOnly = false)
	public int save(TBasiStudent tbStu){
		tbStu.setCreateTime(new Date());
		tbStu.setCreateUser(Utils.getName());
		tbStu.setCreateUserRole(Utils.getUserIRoles());
		tbStu.setId(IDUtil.getNewId());
		if(Constants.BASI_STATE.equals(tbStu.getBasState())){
			tAdvancedStudentService.insert(tbStu);
		}
		return tBasiStudentMapper.save(tbStu);
	}
	
	/**
	 * 修改学员
	 */
	@Transactional(readOnly = false)
	public int update(TBasiStudent tbStu){
		tbStu.setUpdateTime(new Date());
		tbStu.setUpdateUser(Utils.getName());
		//判断状态为上门时，调用咨询学生表添加方法
		if(Constants.BASI_STATE.equals(tbStu.getBasState())){
			tAdvancedStudentService.insert(tbStu);
		}
		return tBasiStudentMapper.update(tbStu);
	}
	
	
	/**
	 * 技术部修改学员
	 */
	@Transactional(readOnly = false)
	public int updateByJS(TBasiStudent tbStu){
		return tBasiStudentMapper.updateByJS(tbStu);
	}
	
	/**
	 * 查看学员列表
	 */
	public Page<TBasiStudent> findTBStuByPage(String name, String phone, String role, String basState, Integer pageNo){
		Page<TBasiStudent> page = new Page<>();
		page.setPageNo(pageNo);
		tBasiStudentMapper.findTBStuByPage(name, phone, role, basState, page);
		return page;
	}
	
	/**
	 * 根据ID查询一个学员(用于修改时查询)
	 */
	public TBasiStudent ufindByStuId(String id){
		return tBasiStudentMapper.findByStuId(id);
	}
	
	/**
	 * 根据ID查询一个学员(查看详细)
	 */
	public TBasiStudent findByStuId(String id){
//		Dictionary dic = new Dictionary();
		TBasiStudent stu = tBasiStudentMapper.findByStuId(id);
//		stu.setEdu(dic.getEdus(stu.getEdu()));
//		stu.setSource(dic.getSource(stu.getSource()));
//		stu.setChannel(dic.getChannel(stu.getChannel()));
//		stu.setBasState(dic.getBasState(stu.getBasState()));
		return stu;
	}
	
	/**
	 * 根据姓名和电话查询
	 */
	public boolean findByNamePho(String name, String phone){
		TBasiStudent tbStu = tBasiStudentMapper.findByNamePho(name, phone);
		boolean falg = false;
		if(tbStu == null){
			falg = true;
		}
		return falg;
	}
}
