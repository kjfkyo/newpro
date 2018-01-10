package com.hm.mapper.clzss;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.TClzssStudent;
import com.hm.mybatis.Page;

public interface TClzssStudentMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    int insert(TClzssStudent record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    int insertSelective(TClzssStudent record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    TClzssStudent selectByPrimaryKey(String id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    int updateByPrimaryKeySelective(TClzssStudent record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    int updateByPrimaryKey(TClzssStudent record);
    /**
	 * 根据项目组id查询当前宿舍学员
	 * @param id 宿舍id
	 * @param page 分页对象
	 * @return
	 */
	List<Map<String, String>> selecStutList(@Param("id")String id,@Param("page") Page<Map<String, String>> page);
	/**
	 * TClzssStudent id修改当前学员状态为0
	 * @return
	 */
	int updateIdSTATE(@Param("id")String id);
	/**
	 * TClzssStudent 为转班添加当前学员
	 * @return
	 */
	int insertStudent(TClzssStudent record);
}