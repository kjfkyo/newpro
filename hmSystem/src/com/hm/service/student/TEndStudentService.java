package com.hm.service.student;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.student.TAdvancedStudent;
import com.hm.entity.student.TEndStudent;
import com.hm.mapper.student.TAdvancedStudentMapper;
import com.hm.mapper.student.TEndStudentMapper;
import com.hm.mybatis.Page;
import com.hm.service.clzss.TClzssStudentService;
import com.hm.util.Constants;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-09-12.
 */
@Service
public class TEndStudentService {
	
	@Autowired
	private TEndStudentMapper tEndStudentMapper;
	@Autowired
	private TAdvancedStudentMapper tAdvancedStudentMapper;
	@Autowired
	private TClzssStudentService tClzssStudentService;
	
	/**
	 * 添加学员
	 */
	public int insert(TAdvancedStudent taStu){
		TEndStudent teStu = new TEndStudent();
		BeanUtils.copyProperties(taStu, teStu);
		teStu.setCreateTime(new Date());
		teStu.setCreateUser(Utils.getName());
		teStu.setUpdateTime(new Date());
		teStu.setUpdateUser(Utils.getName());
		teStu.setEndState("2");
		return tEndStudentMapper.insert(teStu);
	}
	
	/**
	 * 技术部修改学员
	 */
	public int updateByJS(TEndStudent teStu){
		return tEndStudentMapper.updateByJS(teStu);
	}
	/**
	 * 技术部修改学员
	 */
	public int updateJS(String endState, String id){
		return tEndStudentMapper.updateJS(new Date(), Utils.getName(), endState, id);
	}
	
	/**
	 * 企合部修改学员
	 */
	public int updateQH(String jydw,Integer jyxz,String jyrq,String tjr, String id, String phone, String endState){
		return tEndStudentMapper.updateQH(new Date(), Utils.getName(), jydw, jyxz, jyrq, tjr, id, phone, endState);
	}
	
	/**
	 * 技术部查看学员列表
	 */
	public Page<TEndStudent> findTEStuByPageJS(String name, String phone, String claState, String clzId, String endState, Integer pageNo){
		Page<TEndStudent> page = new Page<>();
		page.setPageNo(pageNo);
		tEndStudentMapper.findTEStuByPageJS(name, phone, claState, clzId, endState, page);
		return page;
	}
	
	/**
	 * 企合部查看学员列表
	 */
	public Page<TEndStudent> findTEStuByPageQH(String name, String phone, String clzId, String endState, Integer pageNo){
		Page<TEndStudent> page = new Page<>();
		page.setPageNo(pageNo);
		tEndStudentMapper.findTEStuByPageQH(name, phone, clzId, endState,Constants.END_STATE1,Constants.END_STATE2, page);
		return page;
	}
	
	/**
	 * 根据ID查询一个学员(用于修改时查询)
	 */
	public TEndStudent ufindByTEStuId(String id){
		return tEndStudentMapper.findByTEId(id);
	}
	
	/**
	 * 根据ID查询一个学员(查看详细)
	 */
	public TEndStudent findByTEStuId(String id){
//		Dictionary dic = new Dictionary();
		TEndStudent stu = tEndStudentMapper.findByTEId(id);
//		stu.setEdu(dic.getEdus(stu.getEdu()));
//		stu.setSource(dic.getSource(stu.getSource()));
//		stu.setChannel(dic.getChannel(stu.getChannel()));
//		stu.setBasState(dic.getBasState(stu.getBasState()));
//		stu.setSex(dic.getSex(stu.getSex()));
//		stu.setMarital(dic.getMarital(stu.getMarital()));
//		stu.setEduType(dic.getEduType(stu.getEduType()));
//		stu.setPayType(dic.getPayType(stu.getPayType()));
//		stu.setAdvState(dic.getAdvState(stu.getAdvState()));
//		stu.setEndState(dic.getEndState(stu.getEndState()));
		return stu;
	}
	
	/**
	 * 修改学员为已封班状态
	 */
	public int updateClzState(String id){
		return tEndStudentMapper.updateClzState(id);
	}
	
	/**
	 * 获取项目组
	 */
	public List<Map<String,String>> getClzss() {
		return tEndStudentMapper.getClzss();
	}

	/**
	 * 封项目组
	 * @param arrayId	学员id列表
	 * @param clzId	项目组id
	 */
	public void insertStuClzss(String arrayId, String clzId) {
		String[] arrayIds = arrayId.split(",");
		for(int i=0; i<arrayIds.length; i++){
			tClzssStudentService.insert(arrayIds[i],clzId);
			tEndStudentMapper.updateClzState(arrayIds[i]);
			tAdvancedStudentMapper.updateClzState(arrayIds[i]);
		}
	}
}
