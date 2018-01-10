package com.hm.mapper.school;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.school.TBasiSchool;
import com.hm.mybatis.Page;

public interface TBasiSchoolMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    int insert(TBasiSchool record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    int insertSelective(TBasiSchool record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    TBasiSchool selectByPrimaryKey(String id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    int updateByPrimaryKeySelective(TBasiSchool record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    int updateByPrimaryKey(TBasiSchool record);

    /**
     * 查询高校列表
     * @param name 高校名称
     * @param page 分页对象
     * @return
     */
	List<TBasiSchool> selectSchoolList(@Param("name")String name, Page<TBasiSchool> page);

	/**
	 * 保存高校
	 * @param school
	 * @return
	 */
	int save(TBasiSchool school);

	/**
	 * 检查姓名
	 * @param name
	 * @param id
	 * @return
	 */
	int checkName(@Param("name")String name, @Param("id")String id);

	/**
	 * 根据id查询对象
	 * @param id
	 * @return
	 */
	TBasiSchool selectSchoolById(@Param("id")String id);

	/**
	 * 修改
	 * @param school
	 * @return
	 */
	int update(TBasiSchool school);
}