package com.hm.web.agency;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.agency.TBasiAgency;
import com.hm.mybatis.Page;
import com.hm.service.agency.AgencyService;
import com.hm.util.Utils;

@Controller
@RequestMapping("/agency")
public class AgencyController {

	@Autowired
	private AgencyService service;
	
	/**
	 * 查询代理列表（带分页、带条件）
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
		Page<TBasiAgency> agencys = service.selectList(name,pageNo);
		request.setAttribute("agencys", agencys);
		request.setAttribute("search_name", name);
		request.setAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "agency/agency_list";
	}
	
	/**
	 * 添加代理
	 * @param request
	 * @param school
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public String saveRoom(HttpServletRequest request, TBasiAgency agency){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			service.save(agency);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 检查代理名称唯一性
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
	 * 根据id查看代理详情
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findById")
	public String selectRoomById(HttpServletRequest request) {
		String id = request.getParameter("id");
		return Utils.toJson(service.selectById(id));
	}
	/**
	 * 修改
	 * @param request
	 * @param school
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public String updateRoom(HttpServletRequest request, TBasiAgency agency){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			service.update(agency);
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
			service.delete(id);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	
}
