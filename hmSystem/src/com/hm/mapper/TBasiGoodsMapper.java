package com.hm.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.TBasiCode;
import com.hm.entity.TBasiGoods;
import com.hm.mybatis.Page;
/**
 * mybatis特有类，相当于dao，通过方法名可以调用mapper.xml中的sql语句
 *
 * @author kangjianfeng
 */
public interface TBasiGoodsMapper {
	/**
	 * 查询所有物资类型：从code表中根据God属性查询name属性值
	 * resultType="com.hm.entity.TBasiCode"
	 * @return
	 */
	//查询所有资产类型不分页
	List<TBasiCode> selectTBasiCodeAlls();
	//分页查询所有的资产类型（分页）
	List<TBasiCode> selectTBasiCodeAll(@Param("keyword") String keyword, Page<TBasiCode> page);
	//添加一个资产类型之前查询数据库中是否有该物资类型
	int selectTBasiCodeByNameIsNull(@Param("name")String name);
	//添加一个资产类型
	int insertTBasiCode(@Param("code")TBasiCode code);
	//添加一个资产之前查询数据库中是否有该物资
	int selectTBasiGoodsByNameIsNull(@Param("name")String name);
	//添加一个物资
	int insertTBasiGoods(@Param("goods")TBasiGoods goods);
	//删除一个物资之前查看是否被使用(参数：物资ID，返回值：使用人ID)
	String selectTBasiGoodsu_Id(@Param("id")String id);
	//假删除资产 
	int deleteTBasiGoods(@Param("id")String id);
	//删除资产类型之前通过资产类型name查询该资产类型的id
	String selectTBasiCodeByName(@Param("name")String name);
	//删除一个资产类型(假删除，修改了state字段的状态值)
	int deleteTBasiCode(@Param("id")String id);
	//删除一个资产类型之后根据资产类型的name字段删除所有的资产
	int deleteTBasiCodeAndGoods(@Param("type")String type);
	//修改物资名称(修改名称的同时修改了最后修改人和最后修改时间)
	int updateTBasiGoods(@Param("goods")TBasiGoods goods);
	//修改物资类型名称(修改名称的同时修改了最后修改人和最后修改时间)
	int updateTBasiCode(@Param("code")TBasiCode code);
	//修改物资类型名称之后将该物资类型下所有的物资的类型名称都同时修改
	int updateTBasiGoodsByTypeName(@Param("oldName")String oldName,@Param("newName")String newName);
	//查询某个物资类型下所有的物资
	List<TBasiGoods> selectTBasiGoodsByType(@Param("keyword") String keyword, @Param("type")String type,Page<TBasiGoods> page);
	//根据物资类型名称查询该类型物资数量总和
	int selectTBasiGoodsCount(@Param("type")String type);
	//根据物资类型名称查询该类型物资有多少是空闲的物资的数量
	int selectTBasiGoodsIsNull(@Param("type")String type);
	//根据物资类型名称查询该类型物资有多少是损坏的物资的数量
	int selectTBasiGoodsIsXXX(@Param("type")String type);
	//根据物资类型名称查询该类型物资有多少是丢失的物资的数量
	int selectTBasiGoodsIsDonk(@Param("type")String type);
	//根据物资类型名称查询该类型物资有多少是正在使用的物资的数量
	int selectTBasiGoodsIsUse(@Param("type")String type);
	//根据物资类型ID查询对象
	TBasiCode selectTBasiCodeById(@Param("id")String id);
	//根据物资ID查询对象
	TBasiGoods selectTBasiGoodsById(@Param("id")String id);
	//修改使用情况mark
	int updateGoodsCodeState(@Param("goods")TBasiGoods goods);
	
}