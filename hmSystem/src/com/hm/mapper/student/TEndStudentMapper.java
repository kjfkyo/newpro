package com.hm.mapper.student;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.student.TEndStudent;
import com.hm.mybatis.Page;

/**
 * Created by limiao on 2017-09-12.
 */
public interface TEndStudentMapper {
    /**
     * 添加学员
     */
	int insert(@Param("teStu") TEndStudent teStu);
	/**
	 * 技术部修改学员信息
	 */
	int updateByJS(@Param("teStu") TEndStudent teStu);
	/**
	 * 技术部修改学员状态
	 */
	int updateJS(@Param("updateTime") Date updateTime, @Param("updateUser") String updateUser, @Param("endState")String endState, @Param("id")String id);
	/**
	 * 技术部查询列表分页
	 */
	List<TEndStudent> findTEStuByPageJS(@Param("name") String name, @Param("phone") String phone,
			@Param("claState") String claState, @Param("clzId") String clzId, @Param("endState") String endState,Page<TEndStudent> page);
	/**
	 * 企合部修改学员信息
	 */
	int updateQH(@Param("updateTime") Date updateTime, @Param("updateUser") String updateUser, @Param("jydw")String jydw, 
			@Param("jyxz")Integer jyxz, @Param("jyrq")String jyrq, @Param("tjr")String tjr, @Param("id")String id,
			@Param("phone")String phone, @Param("endState")String endState);
	/**
	 * 企合部查询列表分页(只显示待业状态的学员)
	 */
	List<TEndStudent> findTEStuByPageQH(@Param("name") String name, @Param("phone") String phone, 
			@Param("clzId") String clzId,@Param("endState") String endState,
			@Param("state1")String state1,@Param("state2")String state2,Page<TEndStudent> page);
	/**
	 * 根据id查询一个学员
	 */
	TEndStudent findByTEId(@Param("id") String id);
	
	/**
	 * 修改学员为已封班状态
	 */
	int updateClzState(@Param("id") String id);
	
	/**
	 * 查询项目组
	 * @return
	 */
	List<Map<String,String>> getClzss();
}