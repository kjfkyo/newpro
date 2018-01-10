package com.hm.service.common;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.mapper.common.CommonMapper;
import com.hm.util.Constants;
import com.hm.util.Utils;

@Service
public class CommonService {

	@Autowired
	private CommonMapper mapper;

	public List<Map<String, String>> selectCodeByType(String type) {
		
		return mapper.selectCodeByType(type);
	}

	public List<Map<String, String>> selectCodeByTable(String tName, String filterSql) {
		return mapper.selectCodeByTable(tName, filterSql);
	}
	
	public List<String> selectCodeByKind(String kind){
		return mapper.selectCodeByKind(kind);
	}

	public List<Map<String, String>> selectUserByRole(String role) {
		if(StringUtils.isBlank(role)){
			role = Utils.getUserIRoles();
		}else if("teacher".equals(role)){
			role = Constants.ROLE_TEACHER;
		}else if("rs".equals(role)){
			role = Constants.ROLE_PERSONNEL;
		}else if("all".equals(role)){
			role = null;
		}
		List<Map<String, String>> list = mapper.selectUser(role);
		return list;
	}
}
