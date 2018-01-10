package com.hm.mapper.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CommonMapper {

	List<Map<String, String>> selectCodeByType(@Param("type")String type);

	List<Map<String, String>> selectCodeByTable(@Param("tName")String tName ,@Param("filter")String filterSql);
	
	List<String> selectCodeByKind(@Param("kind")String kind);

	List<Map<String, String>> selectUser(@Param("role")String role);
}
