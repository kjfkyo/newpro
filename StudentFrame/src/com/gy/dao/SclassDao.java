package com.gy.dao;

import java.util.List;

import com.gy.bean.S_class;

public interface SclassDao {
	public List<S_class> selectSclassAll();
	public S_class selectSclassById(int id);
	public List<S_class> selectSclassByName(String name);
	public int addClassInfo(S_class c);
}
