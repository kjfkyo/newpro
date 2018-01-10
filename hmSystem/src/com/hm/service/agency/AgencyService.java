package com.hm.service.agency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.agency.TBasiAgency;
import com.hm.mapper.agency.TBasiAgencyMapper;
import com.hm.mybatis.Page;
import com.hm.util.Utils;


@Service
public class AgencyService {

	@Autowired
	private TBasiAgencyMapper mapper;
	
	/**
	 * 查询高校列表
	 * @param name 高校名称
	 * @param pageNo 页码
	 * @return
	 */
	public Page<TBasiAgency> selectList(String name, Integer pageNo) {
		Page<TBasiAgency> page = new Page<TBasiAgency>();
		page.setPageNo(pageNo);
		List<TBasiAgency> list = mapper.selectList(name,page);
		page.setResults(list);
		return page;
	}

	public int save(TBasiAgency obj) {
		obj.setCreateUser(Utils.getName());
		return mapper.save(obj);
	}

	public int checkName(String name, String id) {
		return mapper.checkName(name,id);
	}

	public TBasiAgency selectById(String id) {
		return mapper.selectById(id);
	}

	public int update(TBasiAgency obj) {
		obj.setUpdateUser(Utils.getName());
		return mapper.update(obj);
	}

	public int delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}
}
