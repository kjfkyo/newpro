package com.cqipc.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cqipc.demo.bean.Sclass;

@Mapper
public interface SclassDao {
	public List<Sclass> selectSclassAll();
}