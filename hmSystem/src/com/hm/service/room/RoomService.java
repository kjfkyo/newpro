package com.hm.service.room;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.entity.room.TBasiRoom;
import com.hm.mapper.room.TBasiRoomMapper;
import com.hm.mybatis.Page;
import com.hm.util.IDUtil;
import com.hm.util.Utils;

@Service
public class RoomService {

	@Autowired
	private TBasiRoomMapper mapper;

	/**
	 * 宿舍列表（分页）
	 * @param pageNo 页码
	 * @return
	 */
	public Page<TBasiRoom> selectList(Integer pageNo) {
		Page<TBasiRoom> page = new Page<TBasiRoom>();
		page.setPageNo(pageNo);
		List<TBasiRoom> list = mapper.selectList(page);
		page.setResults(list);
		return page;
	}

	/**
	 * 添加宿舍信息
	 * @param room 宿舍信息
	 */
	public void saveRoom(TBasiRoom room) {
		room.setCreateUser(Utils.getShiroUser().getName());
		mapper.saveRoom(room);
	}

	/**
	 * 检查名字是否存在（唯一验证）
	 * @param name 要设置的名字
	 * @param id 修改的时候自己id
	 * @return
	 */
	public int checkName(String name, String id) {
		return mapper.checkName(name, id);
	}

	/**
	 * 根据id查询宿舍信息
	 * @param id
	 * @return
	 */
	public TBasiRoom selectRoomById(String id) {
		
		return mapper.selectRoomById(id);
	}

	/**
	 * 修改宿舍信息
	 * @param room
	 */
	public void updateRoom(TBasiRoom room) {
		room.setUpdateUser(Utils.getShiroUser().getName());
		mapper.updateRoom(room);
	}

	public void deleteRoom(String id) {
		mapper.deleteRoomStu(id);
		mapper.deleteRoom(id);
		
	}

	/**
	 * 根据宿舍id查询学员
	 * @param id
	 * @param pageNo
	 * @return
	 */
	public Page<Map<String, String>> selectStuList(String id, Integer pageNo) {
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setPageNo(pageNo);
		List<Map<String, String>> list = mapper.selecStutList(id,page);
		page.setResults(list);
		return page;
	}

	/**
	 * 根据姓名或项目id查询学员
	 * @param name	姓名
	 * @param clzId 项目组id
	 * @param pageNo 页码
	 * @return
	 */
	public Page<Map<String, String>> selectStuList(String name, String clzId,
			Integer pageNo) {
		Page<Map<String, String>> page = new Page<Map<String, String>>();
		page.setPageNo(pageNo);
		List<Map<String, String>> list = mapper.selectStuList(name,clzId,page);
		page.setResults(list);
		return page;
	}

	/**
	 * 查询有空余床位宿舍
	 * @return
	 */
	public List<Map<String, String>> selectFreeRoom() {
		return mapper.selectFreeRoom();
	}

	/**
	 * 给学员分配宿舍
	 * @param stuId 学员id（正式表）
	 * @param roomId 宿舍id
	 * @return
	 */
	public int insertStu(String stuId, String roomId) {
		mapper.deleteByStu(stuId);
		int count = mapper.insertRoomStu(stuId,roomId);
		return count;
	}

	/**
	 * 将学员从宿舍移除
	 * @param stuId
	 * @return
	 */
	public int deleteStuOnRoom(String stuId) {
		int count = mapper.deleteByStu(stuId);
		return count;
	}
	
	
}
