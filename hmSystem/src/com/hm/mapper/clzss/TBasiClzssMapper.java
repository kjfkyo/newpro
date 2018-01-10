package com.hm.mapper.clzss;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.clzss.TBasiClzss;
import com.hm.mybatis.Page;

public interface TBasiClzssMapper {
    /**
     * 根据主键删除
     * 参数:主键
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入，空属性也会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    int insert(TBasiClzss record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:删除个数
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    int insertSelective(TBasiClzss record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    TBasiClzss selectByPrimaryKey(String id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    int updateByPrimaryKeySelective(TBasiClzss record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    int updateByPrimaryKey(TBasiClzss record);
    /**
     * 查询全部
     * 参数:null
     * 返回:集合对象
     * @ibatorgenerated 2017-09-11 16:28:05
     */
    public List<TBasiClzss> selectByPrimaryKeyAll();
    /**
     * 添加项目组
     * 参数:TBasiClzss
     * 返回:int
     * @addClazz 2017-09-11 16:28:05
     */
    public int addClazz(TBasiClzss clzss);
    /**
     * 查询全部分页项目组
     * 参数:Page<TBasiClzss>
     * 返回:List<TBasiClzss>
     * @listClzss 2017-09-11 16:28:05
     */
    public List<TBasiClzss> listClzss(@Param("p")Page<TBasiClzss> p,@Param("name")String name);
    /**
     * 根据id查询
     * 参数:id
     * 返回:TBasiClzss
     * @addClazz 2017-09-11 16:28:05
     */
    public TBasiClzss ClzssId(String id);
    /**
     * 根据id修改
     * 参数:TBasiClzss
     * 返回:int
     * @addClazz 2017-09-11 16:28:05
     */
    public int  updateClzss(TBasiClzss clzss);
    /**
	 * 查询所有项目组名称
	 * @return
	 */
	List<Map<String, String>> selectFreeRoom();

   
}