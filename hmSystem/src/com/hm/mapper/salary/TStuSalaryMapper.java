package com.hm.mapper.salary;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.clzss.TBasiClzss;
import com.hm.entity.salary.TStuSalary;
import com.hm.entity.student.TEndStudent;
import com.hm.mybatis.Page;

public interface TStuSalaryMapper {
	/**
	 * 根据主键删除 参数:主键 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-05 16:28:02
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * 插入，空属性也会插入 参数:pojo对象 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-05 16:28:02
	 */
	int insert(TStuSalary record);

	/**
	 * 插入，空属性不会插入 参数:pojo对象 返回:删除个数
	 * 
	 * @ibatorgenerated 2017-09-05 16:28:02
	 */
	int insertSelective(TStuSalary record);

	/**
	 * 根据主键查询 参数:查询条件,主键值 返回:对象
	 * 
	 * @ibatorgenerated 2017-09-05 16:28:02
	 */
	TStuSalary selectByPrimaryKey(String id);

	/**
	 * 根据主键修改，空值条件不会修改成null 参数:1.要修改成的值 返回:成功修改个数
	 * 
	 * @ibatorgenerated 2017-09-05 16:28:02
	 */
	int updateByPrimaryKeySelective(@Param("sal") TStuSalary sal);

	/**
	 * 根据主键修改，空值条件会修改成null 参数:1.要修改成的值 返回:成功修改个数
	 * 
	 * @ibatorgenerated 2017-09-05 16:28:02
	 */
	int updateByPrimaryKey(TStuSalary record);

	/**
	 * 查询项目组
	 * 
	 * @return
	 */
	List<TBasiClzss> selectClass();

	/**
	 * 根据项目组ID查询学生
	 * 
	 * @param clzId
	 * @param pageNo
	 * @return
	 */
	List<TEndStudent> selectStu(@Param("clzId") String clzId,
			Page<TEndStudent> page);

	/**
	 * 根据年月或者发放状态从工资表查询信息
	 * 
	 * @param month
	 * @param state
	 * @param pageNo
	 * @return
	 */
	List<TStuSalary> selectSal(@Param("month") String month,
			@Param("state") String state, Page<TStuSalary> page);

	/**
	 * 根据学生ID查询工资表信息
	 * 
	 * @param id
	 * @param flag
	 * @return
	 */
	TStuSalary findByStuId(@Param("id") String id, @Param("flag") String flag);

	/**
	 * 更新工资表信息
	 * 
	 * @param sal
	 * @return
	 */
	int updateSalary(@Param("sal") TStuSalary sal);

	/**
	 * 向工资表中插入数据
	 * 
	 * @param sal
	 * @return
	 */
	int insertSalary(@Param("sal") TStuSalary sal);

	/**
	 * 查询银行名称
	 * 
	 * @return
	 */
	List<Map<String, String>> getBankNm();
}