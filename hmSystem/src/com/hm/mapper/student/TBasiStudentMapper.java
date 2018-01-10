package com.hm.mapper.student;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.hm.entity.student.TBasiStudent;
import com.hm.mybatis.Page;
/**
 * Created by limiao on 2017-09-08.
 */
public interface TBasiStudentMapper {
	
	/**
	 * 添加学员
	 */
	int save(@Param("tbStu") TBasiStudent tbStu);
	
	/**
	 * 修改学员
	 */
	int update(@Param("tbStu") TBasiStudent tbStu);
	
	/**
	 * 技术部修改学员
	 */
	int updateByJS(@Param("tbStu") TBasiStudent tbStu);
	
	/**
	 * 查看学员列表
	 */
	List<TBasiStudent> findTBStuByPage(@Param("name") String name, @Param("phone") String phone, 
			@Param("role") String role, @Param("basState") String basState, Page<TBasiStudent> page);
	
	/**
	 * 根据ID查询一个学员
	 */
	TBasiStudent findByStuId(@Param("id") String id);
	
	
	/**
	 * 根据姓名和电话查询
	 */
	TBasiStudent findByNamePho(@Param("name") String name, @Param("phone") String phone);
}