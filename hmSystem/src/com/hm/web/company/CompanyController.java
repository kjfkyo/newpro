package com.hm.web.company;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.company.TBasiCompany;
import com.hm.mybatis.Page;
import com.hm.service.company.CompanyService;
import com.hm.util.Utils;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	/**
	 * 查询企业列表（带分页、带条件）
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
		Page<TBasiCompany> companys = service.selectList(name,pageNo);
		request.setAttribute("companys", companys);
		request.setAttribute("search_name", name);
		request.setAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
		return "company/company_list";
	}
	
	/**
	 * 添加
	 * @param request
	 * @param company
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/save")
	public String saveRoom(HttpServletRequest request, TBasiCompany company){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			service.save(company);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 检查企业名称唯一性
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
	 * 根据id查看企业详情
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
	 * @param company
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public String updateRoom(HttpServletRequest request, TBasiCompany company){
		Map<String, String> obj = new HashMap<String, String>();
		try {
			service.update(company);
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
