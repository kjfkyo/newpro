package com.hm.service.TBasiCode;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.entity.TBasiCode;
import com.hm.entity.account.User;
import com.hm.entity.role.Role;
import com.hm.mapper.TBasiCodeMapper;
import com.hm.mapper.role.RoleMapper;
import com.hm.mybatis.Page;
import com.hm.util.IDUtil;
import com.hm.util.Utils;



@Service
@Transactional(readOnly = true)
public class TBasiCodeService {
	
	 @Autowired
	 private TBasiCodeMapper TBasiCodeMapper;
	 
	 public String saveTBasiCode(TBasiCode record) {
		 	
		 	String id = record.getId();
		 	
		 	TBasiCode record2 =TBasiCodeMapper.selectByPrimaryKey(id);
		 	System.out.println(record2==null);
		 	if(record2==null){
		 		record.setDelflag("0");
		 		record.setId(IDUtil.getNewId());
		 		record.setCreateUser(Utils.getLoginName());
			 	record.setCreateTime(new Date());
		 		TBasiCodeMapper.insert(record);
		 	}else{
		 		record.setUpdateTime(new Date());
		 		record.setUpdateUser(Utils.getLoginName());
		 		TBasiCodeMapper.updateByPrimaryKeySelective(record);
		 	}
		 	return record.getFlag();
	 }
	
	 @Transactional(readOnly = true)
	 public Page<TBasiCode> findTBasiCodeByPage(String keyword, Integer pageNo,String flag) {
	        Page<TBasiCode> page = new Page<>();
	        page.setPageNo(pageNo);
	        TBasiCodeMapper.findTBasiCodeByPage(keyword, page, flag);
	        return page;
	}
	 @Transactional(readOnly = true)
	 public TBasiCode findTBasiCodeById(String id) {
	        return TBasiCodeMapper.getTBasiCodeById(id);
	 }
	 
	 public String deleteTBasiCodeById(String id) {
		 TBasiCode record =   TBasiCodeMapper.getTBasiCodeById(id);
		     record.setDelflag("1");
	         TBasiCodeMapper.updateByPrimaryKey(record);
	         return record.getFlag();
	 }
}
