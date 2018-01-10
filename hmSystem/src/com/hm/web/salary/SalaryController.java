package com.hm.web.salary;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.clzss.TBasiClzss;
import com.hm.entity.salary.TStuSalary;
import com.hm.entity.student.TEndStudent;
import com.hm.mybatis.Page;
import com.hm.service.salary.SalaryService;
import com.hm.util.Utils;

@Controller
@RequestMapping("salary")
public class SalaryController {

	@Autowired
	private SalaryService salaryService;

	/**
	 * 页面初始化时查询班级，点击搜索时查询学生信息
	 * @param request
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("salCheck")
	public String salCheck(ServletRequest request,
			@RequestParam(value = "page", defaultValue = "1") Integer pageNo,
			Model model) {
		String search_clzId = request.getParameter("search_clzId");
		Page<TEndStudent> sal = new Page<>();
		List<TBasiClzss> tBasiClzssList = salaryService.selectClass();
		request.setAttribute("tBasiClzssList", tBasiClzssList);
		if (search_clzId == "" || search_clzId == null) {
			sal.setPageNo(pageNo);
		} else {
			sal = salaryService.selectStu(search_clzId, pageNo);
			request.setAttribute("search_clzId", search_clzId);
		}
		request.setAttribute("searchParams", "search_clzId="+search_clzId);
		request.setAttribute("sal", sal);
		return "salary/salary_check";
	}

	/**
	 * 通过学生Id查询工资表信息
	 * @param model
	 * @param id
	 * @param flag
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updatePre")
	public String updatePre(Model model, String id,String flag) {
		return Utils.toJson(salaryService.findByStuId(id,flag));
	}

	/**
	 * 修改工资表信息
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateSalary")
	public String updateSalary(ServletRequest request, Model model) {
		Map<String, String> obj = new HashMap<String, String>();
		String id = request.getParameter("primaryId");
		String bankNm = request.getParameter("bankNm");
		String bankNum = request.getParameter("bankNum");
		Integer salMoney = Integer.parseInt(request.getParameter("salMoney"));
		TStuSalary sal = new TStuSalary();
		sal.setId(id);
		sal.setBankNm(bankNm);
		sal.setBankNum(bankNum);
		sal.setSalMoney(salMoney);
		sal.setUpdateUser(Utils.getName());
		try {
			salaryService.updateSalary(sal);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 向工资表中插入数据
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("insertSalary")
	public String insertSalary(ServletRequest request, Model model) {
		Map<String, String> obj = new HashMap<String, String>();
		String stuId = request.getParameter("stuId");
		String bankNm = request.getParameter("bankNm");
		String bankNum = request.getParameter("bankNum");
		Integer salMoney = Integer.parseInt(request.getParameter("salMoney"));
		TStuSalary sal = new TStuSalary();
		sal.setStuId(stuId);
		sal.setBankNm(bankNm);
		sal.setBankNum(bankNum);
		sal.setSalMoney(salMoney);
		sal.setCreateTime(new Date());
		sal.setCreateUser(Utils.getName());
		sal.setUpdateTime(new Date());
		sal.setUpdateUser(Utils.getName());
		try {
			salaryService.insertSalary(sal);
			obj.put("msg", "ok");
			return Utils.toJson(obj);
		} catch (Exception e) {
			obj.put("msg", "error");
			return Utils.toJson(obj);
		}
	}
	/**
	 * 初始化时查询工资表信息，点击未发放时更新成已发放
	 * @param request
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping("setSal")
	public String setSal(ServletRequest request,
			@RequestParam(value = "page", defaultValue = "1") Integer pageNo,
			Model model) {
		String id = request.getParameter("id");
		if(id != "" && id != null){
			TStuSalary tss = new TStuSalary();
			tss.setId(id);
			tss.setUpdateUser(Utils.getName());
			salaryService.updateByPrimaryKeySelective(tss);
		}
		String month = request.getParameter("month");
		String state = request.getParameter("state");
		if(month == null || month == ""){
			month = null;
		}else{
			request.setAttribute("month", month);
			month = month.replace("-", "");
		}
		if(state == null || state == ""){
			state = null;
		}else{
			request.setAttribute("state", state);
		}
		Page<TStuSalary> sal = salaryService.selectSal(month, state, pageNo);
		request.setAttribute("sal", sal);
		return "salary/salary_set";
	}
	
	/**
	 * 查询银行名称
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getBankNm")
	public String getBankNm(ServletRequest request, Model model) {
		return Utils.toJson(salaryService.getBankNm());
	}
}
