package com.hm.service.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.school.TBasiSchool;
import com.hm.mapper.school.TBasiSchoolMapper;
import com.hm.mybatis.Page;
import com.hm.util.Utils;


@Service
public class SchoolService {

	@Autowired
	private TBasiSchoolMapper mapper;

	/**
	 * 查询高校列表
	 * @param name 高校名称
	 * @param pageNo 页码
	 * @return
	 */
	public Page<TBasiSchool> selectSchoolList(String name, Integer pageNo) {
		Page<TBasiSchool> page = new Page<TBasiSchool>();
		page.setPageNo(pageNo);
		List<TBasiSchool> list = mapper.selectSchoolList(name,page);
		page.setResults(list);
		return page;
	}

	public int saveSchool(TBasiSchool school) {
		school.setCreateUser(Utils.getName());
		return mapper.save(school);
	}

	public int checkName(String name, String id) {
		return mapper.checkName(name,id);
	}

	public TBasiSchool selectSchoolById(String id) {
		return mapper.selectSchoolById(id);
	}

	public int updateSchool(TBasiSchool school) {
		school.setUpdateUser(Utils.getName());
		return mapper.update(school);
	}

	public int deleteSchool(String id) {
		return mapper.deleteByPrimaryKey(id);
	}
}
