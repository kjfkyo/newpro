package com.hm.service.clzss;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.TClzssStudent;
import com.hm.mapper.clzss.TBasiClzssMapper;
import com.hm.mapper.clzss.TClzssStudentMapper;
import com.hm.mybatis.Page;
import com.hm.util.IDUtil;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-09-15.
 */
@Service
public class TClzssStudentService {
	
	@Autowired
	private TClzssStudentMapper tClzssStudentMapper;
	@Autowired
	private TBasiClzssMapper tBasiClzssMapper;
	
	public int insert(String id, String clzId){
		TClzssStudent tclz = new TClzssStudent();
		tclz.setId(IDUtil.getNewId());
		tclz.setClzId(clzId);
		tclz.setState("1");
		tclz.setStuId(id);
		tclz.setCreateTime(new Date());
		tclz.setCreateUser(Utils.getName());
		tclz.setUpdateTime(new Date());
		tclz.setUpdateUser(Utils.getName());
		return tClzssStudentMapper.insert(tclz);
	}
	/**
	 * 根据项目组id查询学员
	 * @param id
	 * @param pageNo
	 * @return
	 */
	public Page<Map<String, String>> selectStuList(String id, Integer pageNo) {
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setPageNo(pageNo);
		List<Map<String, String>> list = tClzssStudentMapper.selecStutList(id,page);
		page.setResults(list);
		return page;
	}
	/**
	 * 学员转项目组
	 * @param id
	 * @param pageNo
	 * @return
	 */
	  public int insertStu(TClzssStudent record){
		  String id=record.getId();
		 
		  int count=tClzssStudentMapper.insertStudent(record);
		  int count2=tClzssStudentMapper.updateIdSTATE(id);
	       if(count>0&&count2>0){
	    	   return  1; 
	       }
		  return  0; 
	  }
}
