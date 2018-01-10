package com.hm.service.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.company.TBasiCompany;
import com.hm.mapper.company.TBasiCompanyMapper;
import com.hm.mybatis.Page;
import com.hm.util.Utils;

@Service
public class CompanyService {

	@Autowired
	private TBasiCompanyMapper mapper;
	
	/**
	 * 查询企业列表
	 * @param name 企业名称
	 * @param pageNo 页码
	 * @return
	 */
	public Page<TBasiCompany> selectList(String name, Integer pageNo) {
		Page<TBasiCompany> page = new Page<TBasiCompany>();
		page.setPageNo(pageNo);
		List<TBasiCompany> list = mapper.selectList(name,page);
		page.setResults(list);
		return page;
	}

	public int save(TBasiCompany obj) {
		obj.setCreateUser(Utils.getName());
		return mapper.save(obj);
	}

	public int checkName(String name, String id) {
		return mapper.checkName(name,id);
	}

	public TBasiCompany selectById(String id) {
		return mapper.selectById(id);
	}

	public int update(TBasiCompany obj) {
		obj.setUpdateUser(Utils.getName());
		return mapper.update(obj);
	}

	public int delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}
}
