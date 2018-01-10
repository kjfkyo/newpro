package com.hm.service.student;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.student.TAdvancedStudent;
import com.hm.entity.student.TBasiStudent;
import com.hm.mapper.student.TAdvancedStudentMapper;
import com.hm.mybatis.Page;
import com.hm.util.Constants;
import com.hm.util.Dictionary;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-09-11.
 */
@Service
public class TAdvancedStudentService {
	
	@Autowired
	private TAdvancedStudentMapper tAdvancedStudentMapper;
	@Autowired
	private TEndStudentService tEndStudentService;
	
	/**
	 * 添加学员
	 */
	public int insert(TBasiStudent tbStu){
		TAdvancedStudent taStu = new TAdvancedStudent();
		BeanUtils.copyProperties(tbStu, taStu);
		taStu.setCreateTime(new Date());
		taStu.setCreateUser(Utils.getName());
		taStu.setClaState("0");
		return tAdvancedStudentMapper.insert(taStu);
	}
	
	/**
	 * 修改学员
	 */
	public int update(TAdvancedStudent taStu){
		taStu.setUpdateTime(new Date());
		taStu.setUpdateUser(Utils.getName());
		//判断修改学员状态为已签约时，向endStu表添加数据
		if(Constants.ADVA_STATE.equals(taStu.getAdvState())){
			TAdvancedStudent taStus = tAdvancedStudentMapper.findByTAStuId(taStu.getId());
			taStu.setName(taStus.getName());
			taStu.setAge(taStus.getAge());
			taStu.setEdu(taStus.getEdu());
			taStu.setSource(taStus.getSource());
			taStu.setChannel(taStus.getChannel());
			taStu.setChannelDetail(taStus.getChannelDetail());
			taStu.setGetpeo(taStus.getGetpeo());
			taStu.setDoorday(taStus.getDoorday());
			taStu.setBasMark(taStus.getBasMark());
			taStu.setBasState(taStu.getBasState());
			taStu.setClaState(taStus.getClaState());
			tEndStudentService.insert(taStu);
		}
		return tAdvancedStudentMapper.update(taStu);
	}
	
	/**
	 * 技术部修改学员
	 */
	public int updateByJS(TAdvancedStudent taStu){
		return tAdvancedStudentMapper.updateByJS(taStu);
	}
	
	/**
	 * 查看学员列表
	 */
	public Page<TAdvancedStudent> findTAStuByPage(String name, String phone, String claState, String clzId, String advState, Integer pageNo){
		Page<TAdvancedStudent> page = new Page<>();
		page.setPageNo(pageNo);
		tAdvancedStudentMapper.findTAStuByPage(name, phone, claState, clzId, advState, page);
		return page;
	}
	
	/**
	 * 根据ID查询一个学员(用于修改时查询)
	 */
	public TAdvancedStudent ufindByTAStuId(String id){
		return tAdvancedStudentMapper.findByTAStuId(id);
	}
	
	/**
	 * 根据ID查询一个学员(查看详细)
	 */
	public TAdvancedStudent findByTAStuId(String id){
//		Dictionary dic = new Dictionary();
		TAdvancedStudent stu = tAdvancedStudentMapper.findByTAStuId(id);
//		stu.setEdu(dic.getEdus(stu.getEdu()));
//		stu.setSource(dic.getSource(stu.getSource()));
//		stu.setChannel(dic.getChannel(stu.getChannel()));
//		stu.setBasState(dic.getBasState(stu.getBasState()));
//		stu.setSex(dic.getSex(stu.getSex()));
//		stu.setMarital(dic.getMarital(stu.getMarital()));
//		stu.setEduType(dic.getEduType(stu.getEduType()));
//		stu.setPayType(dic.getPayType(stu.getPayType()));
//		stu.setAdvState(dic.getAdvState(stu.getAdvState()));
		return stu;
	}
	
	/**
	 * 修改学员为已封班状态
	 */
	public int updateClzState(String id){
		return tAdvancedStudentMapper.updateClzState(id);
	}
}
