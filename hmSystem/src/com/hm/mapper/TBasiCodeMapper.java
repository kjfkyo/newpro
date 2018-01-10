package com.hm.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.TBasiCode;
import com.hm.entity.account.User;
import com.hm.mybatis.Page;

public interface TBasiCodeMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    int insert(TBasiCode record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    int insertSelective(TBasiCode record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    TBasiCode selectByPrimaryKey(String id);
  
    List<TBasiCode> findTBasiCodeByPage(@Param("keyword") String keyword, Page<TBasiCode> page,@Param("flag")String flag);
    TBasiCode getTBasiCodeById(@Param("id") String id);
  
    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    int updateByPrimaryKeySelective(TBasiCode record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    int updateByPrimaryKey(TBasiCode record);
    /**
     * 查询所有部门的名称
     * @ibatorgenerated 2017-09-21 22:07:05
     * */
    public List<String> selectCodeByDep();
}