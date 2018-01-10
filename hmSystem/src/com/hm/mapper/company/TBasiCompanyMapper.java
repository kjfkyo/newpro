package com.hm.mapper.company;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.company.TBasiCompany;
import com.hm.mybatis.Page;

public interface TBasiCompanyMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    int insert(TBasiCompany record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    int insertSelective(TBasiCompany record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    TBasiCompany selectByPrimaryKey(String id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    int updateByPrimaryKeySelective(TBasiCompany record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    int updateByPrimaryKey(TBasiCompany record);
    
    /**
     * 查询企业列表
     * @param name 企业名称
     * @param page 分页对象
     * @return
     */
	List<TBasiCompany> selectList(@Param("name")String name, Page<TBasiCompany> page);

	/**
	 * 保存
	 * @param school
	 * @return
	 */
	int save(TBasiCompany obj);

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
	TBasiCompany selectById(@Param("id")String id);

	/**
	 * 修改
	 * @param school
	 * @return
	 */
	int update(TBasiCompany obj);
}