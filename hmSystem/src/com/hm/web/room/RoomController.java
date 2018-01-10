package com.hm.web.room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.room.TBasiRoom;
import com.hm.mybatis.Page;
import com.hm.service.room.RoomService;
import com.hm.util.Utils;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	/**
	 * 查询所有宿舍
	 * @param request
	 * @param response
	 */
	@RequestMapping("/list")
	public String selectList(HttpServletRequest request){
		Integer pageNo = 1;
		String temp = request.getParameter("page");
		if(StringUtils.isNotBlank(temp)){
			pageNo = Integer.parseInt(temp);
		}
		
		Page<TBasiRoom> rooms = service.selectList(pageNo);
		
		request.setAttribute("rooms", rooms);
		return "room/room_list";
	}
	/**
	 * 添加宿舍
	 * @param request
	 * @param room
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public String saveRoom(HttpServletRequest request, TBasiRoom room){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			service.saveRoom(room);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 检查宿舍名称唯一性
	 * @param request
	 * @return ok表示唯一 orrer表示已经存在
	 */
	@ResponseBody
	@RequestMapping("/checkName")
	public String checkName(HttpServletRequest request) {
		Map<String, String> obj =  new HashMap<String, String>();
		try {
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			int count = service.checkName(name,id);
			obj.put("msg", count>0?"error":"ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 根据id查看宿舍详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findRoomById")
	public String selectRoomById(HttpServletRequest request) {
		String id = request.getParameter("id");
		return Utils.toJson(service.selectRoomById(id));
	}
	/**
	 * 修改
	 * @param request
	 * @param room
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public String updateRoom(HttpServletRequest request, TBasiRoom room){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			service.updateRoom(room);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 删除（伪）
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteRoom(HttpServletRequest request){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			String id = request.getParameter("id");
			service.deleteRoom(id);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	
	/**
	 * 根据宿舍id查询学员
	 * @param request
	 * @return
	 */
	@RequestMapping("/roomstu")
	public String selectStuList(HttpServletRequest request){
		Integer pageNo = 1;
		String temp = request.getParameter("page");
		if(StringUtils.isNotBlank(temp)){
			pageNo = Integer.parseInt(temp);
		}
		Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "search_");
		String id = Utils.objToStr(searchParams.get("id"));
		String name = Utils.objToStr(searchParams.get("name"));
		Page<Map<String, String>> stus = service.selectStuList(id,pageNo);
		request.setAttribute("name", name);
		request.setAttribute("stus", stus);
		request.setAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "room/roomstu_list";
	}
	
	/**
	 * 根据学生姓名或项目组id查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/stuList")
	public String selectStuByName(HttpServletRequest request) {
		Integer pageNo = 1;
		String temp = request.getParameter("page");
		if(StringUtils.isNotBlank(temp)){
			pageNo = Integer.parseInt(temp);
		}
		Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "search_");
		String clzId = Utils.objToStr(searchParams.get("clzId"));
		String name = Utils.objToStr(searchParams.get("name"));
		Page<Map<String, String>> stus = new Page<Map<String,String>>();
		if(StringUtils.isNotBlank(name)||StringUtils.isNotBlank(clzId)){
			stus = service.selectStuList(name,clzId,pageNo);
		}
		request.setAttribute("stus", stus);
		request.setAttribute("search_clzId", clzId);
		request.setAttribute("search_name", name);
		request.setAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "room/stu_list";
	}
	/**
	 * 查询有空余床位的宿舍
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/freeRoom")
	public String selectFreeRoom(HttpServletRequest request){
		
		List<Map<String, String>> list = service.selectFreeRoom();
		
		return Utils.toJson(list);
	}
	
	/**
	 * 给学员分配宿舍
	 * @param request stuId 学员id（正式表）
	 * @param request roomId 宿舍id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insertStu")
	public String insertStu(HttpServletRequest request){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			String stuId = request.getParameter("stuId");
			String roomId = request.getParameter("roomId");
			service.insertStu(stuId,roomId);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 将学员从宿舍移除
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delrs")
	public String delStuRoom(HttpServletRequest request){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			String stuId = request.getParameter("stuId");
			int count = service.deleteStuOnRoom(stuId);
			if(count>0){
				obj.put("msg", "ok");
			}else{
				obj.put("msg", "error");
			}
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	
}
