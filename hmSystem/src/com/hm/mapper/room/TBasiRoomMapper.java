package com.hm.mapper.room;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.room.TBasiRoom;
import com.hm.mybatis.Page;

public interface TBasiRoomMapper {
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
    int insert(TBasiRoom record);

    /**
     * 插入，空属性不会插入
     * 参数:pojo对象
     * 返回:添加个数
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    int insertSelective(TBasiRoom record);

    /**
     * 根据主键查询
     * 参数:查询条件,主键值
     * 返回:对象
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    TBasiRoom selectByPrimaryKey(String id);

    /**
     * 根据主键修改，空值条件不会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    int updateByPrimaryKeySelective(TBasiRoom record);

    /**
     * 根据主键修改，空值条件会修改成null
     * 参数:1.要修改成的值
     * 返回:成功修改个数
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    int updateByPrimaryKey(TBasiRoom record);

    /**
     * 查询所有宿舍房间
     * @param pageNo
     * @return
     */
    List<TBasiRoom> selectList(Page<TBasiRoom> page);

    /**
     * 添加宿舍
     * @param room
     * @return
     */
	int saveRoom(TBasiRoom room);

	/**
	 * 查询除自身以外同名的个数
	 * @param name
	 * @param id
	 * @return
	 */
	int checkName(@Param("name")String name, @Param("id")String id);

	/**
	 * 根据id查询宿舍信息
	 * @param id
	 * @return
	 */
	TBasiRoom selectRoomById(String id);

	/**
	 * 修改宿舍信息
	 * @param room
	 * @return
	 */
	int updateRoom(TBasiRoom room);

	/**
	 * 删除该宿舍和学员之间的关系
	 * @param id
	 * @return
	 */
	int deleteRoomStu(String id);

	/**
	 * 删除该宿舍（伪删除）
	 * @param id
	 * @return
	 */
	int deleteRoom(String id);

	/**
	 * 根据宿舍id查询当前宿舍学员
	 * @param id 宿舍id
	 * @param page 分页对象
	 * @return
	 */
	List<Map<String, String>> selecStutList(@Param("id")String id, Page<Map<String, String>> page);

	List<Map<String, String>> selectStuList(@Param("name")String name, @Param("clzId")String clzId,
			Page<Map<String, String>> page);

	/**
	 * 查询有空余床位的宿舍
	 * @return
	 */
	List<Map<String, String>> selectFreeRoom();

	/**
	 * 删除学员住宿记录
	 * @param stuId 
	 */
	int deleteByStu(@Param("stuId")String stuId);

	/**
	 * 给学员分配宿舍
	 * @param stuId
	 * @param roomId
	 * @return
	 */
	int insertRoomStu(@Param("stuId")String stuId, @Param("roomId")String roomId);

}