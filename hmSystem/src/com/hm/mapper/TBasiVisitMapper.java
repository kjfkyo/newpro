package com.hm.mapper;

import com.hm.entity.TBasiVisit;

public interface TBasiVisitMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    int insert(TBasiVisit record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    int insertSelective(TBasiVisit record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    TBasiVisit selectByPrimaryKey(String id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    int updateByPrimaryKeySelective(TBasiVisit record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    int updateByPrimaryKey(TBasiVisit record);
}