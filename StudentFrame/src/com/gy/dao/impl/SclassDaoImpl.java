package com.gy.dao.impl;

import java.util.List;

import com.gy.bean.S_class;
import com.gy.dao.SclassDao;

public class SclassDaoImpl extends 
BaseDao<SclassDao> implements SclassDao {
	
	public SclassDaoImpl() {
		this.setMapper(SclassDao.class);
	}

	@Override
	public List<S_class> selectSclassAll() {
		return this.getMapper().selectSclassAll();
	}

	@Override
	public S_class selectSclassById(int id) {
		return this.getMapper().selectSclassById(id);
	}

	@Override
	public List<S_class> selectSclassByName(String name) {
		return this.getMapper().selectSclassByName(name);
	}

	@Override
	public int addClassInfo(S_class c) {
		int count=this.getMapper().addClassInfo(c);
		this.session.commit();
		return count;
	}
	
}
