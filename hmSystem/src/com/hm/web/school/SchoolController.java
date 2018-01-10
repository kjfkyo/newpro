package com.hm.web.school;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.school.TBasiSchool;
import com.hm.mybatis.Page;
import com.hm.service.school.SchoolService;
import com.hm.util.Utils;

@Controller
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService service;
	
	/**
	 * 查询高校列表（带分页、带条件）
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByName(HttpServletRequest request) {
		Integer pageNo = 1;
		String temp = request.getParameter("page");
		if(StringUtils.isNotBlank(temp)){
			pageNo = Integer.parseInt(temp);
		}
		Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "search_");
		String name = Utils.objToStr(searchParams.get("name"));
		Page<TBasiSchool> schools = service.selectSchoolList(name,pageNo);
		request.setAttribute("schools", schools);
		request.setAttribute("search_name", name);
		request.setAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "school/school_list";
	}
	
	/**
	 * 添加高校
	 * @param request
	 * @param school
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public String saveRoom(HttpServletRequest request, TBasiSchool school){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			service.saveSchool(school);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 检查高校名称唯一性
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
	 * 根据id查看高校详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findById")
	public String selectRoomById(HttpServletRequest request) {
		String id = request.getParameter("id");
		return Utils.toJson(service.selectSchoolById(id));
	}
	/**
	 * 修改
	 * @param request
	 * @param school
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public String updateRoom(HttpServletRequest request, TBasiSchool school){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			service.updateSchool(school);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteRoom(HttpServletRequest request){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			String id = request.getParameter("id");
			service.deleteSchool(id);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	
}
