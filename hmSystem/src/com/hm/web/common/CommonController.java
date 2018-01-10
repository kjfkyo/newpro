package com.hm.web.common;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.service.common.CommonService;
import com.hm.util.Utils;

@Controller
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private CommonService service;

	/**
	 * 获取代码配置表中的数据
	 * 
	 * @param request
	 *            type：数据类型
	 * @param response
	 *            数据id name nm(还是name)
	 */
	@ResponseBody
	@RequestMapping("/sysCode")
	public String getCode(HttpServletRequest request) {
		String type = request.getParameter("type");

		List<Map<String, String>> list = service.selectCodeByType(type);

		return Utils.toJson(list);
	}

	/**
	 * 获取某个表中的id和name
	 * 
	 * @param request
	 *            tname：要查询的表名
	 * @param response
	 *            数据id name nm(还是name)
	 */
	@ResponseBody
	@RequestMapping("/otherCode")
	public String getSelector(HttpServletRequest request) {
		String tName = request.getParameter("tname");

		String filterSql = request.getParameter("filer");

		if (StringUtils.isNotBlank(tName)) {

			List<Map<String, String>> list = service.selectCodeByTable(tName,filterSql);

			return Utils.toJson(list);
		}else{
			return Utils.toJson(null);
		}
	}
	
	/**
	 * 查询用户（员工）根据角色
	 * @param request role 角色，如果没有查询当前相同角色，all查询全部
	 * @return id,name,nm
	 */
	@ResponseBody
	@RequestMapping("/getUser")
	public String getUserByRole(HttpServletRequest request){
		String role = request.getParameter("role");
		List<Map<String, String>> list = service.selectUserByRole(role);
		return Utils.toJson(list);
	}
}
