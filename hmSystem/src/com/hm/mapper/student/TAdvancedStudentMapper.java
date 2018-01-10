package com.hm.mapper.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.student.TAdvancedStudent;
import com.hm.mybatis.Page;
/**
 * Created by limiao on 2017-09-11.
 */
public interface TAdvancedStudentMapper {
	/**
	 * 查看学员列表
	 */
	List<TAdvancedStudent> findTAStuByPage(@Param("name") String name, @Param("phone") String phone,
			 @Param("claState") String claState, @Param("clzId") String clzId, @Param("advState") String advState,Page<TAdvancedStudent> page);
	
	/**
	 * 根据ID查询一个学员
	 */
	TAdvancedStudent findByTAStuId(@Param("id") String id);
	
	/**
	 * 添加学员
	 */
	int insert(@Param("taStu") TAdvancedStudent taStu);
	
	/**
	 * 修改学员
	 */
	int update(@Param("taStu") TAdvancedStudent taStu);
	
	/**
	 * 技术部修改学员
	 */
	int updateByJS(@Param("taStu") TAdvancedStudent taStu);
	
	/**
	 * 修改学员为已封班状态
	 */
	int updateClzState(@Param("id") String id);
}