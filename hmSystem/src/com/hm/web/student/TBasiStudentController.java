package com.hm.web.student;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.student.TBasiStudent;
import com.hm.mybatis.Page;
import com.hm.service.student.TBasiStudentService;
import com.hm.util.Constants;
import com.hm.util.Utils;

@Controller
@RequestMapping("/tBasiStudent")
public class TBasiStudentController {
	
	@Autowired
	private TBasiStudentService tBasiStudentService;
	
	/**
	 * 列表查询（网咨、咨询、拓展）
	 */
	@RequestMapping("list")
    public String list(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
        Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "search_");
        Page<TBasiStudent> tbStu = tBasiStudentService.findTBStuByPage(Utils.objToStr(searchParams.get("name")), Utils.objToStr(searchParams.get("phone")),
        		 Utils.getUserIRoles(), Utils.objToStr(searchParams.get("basState")), pageNo);
        model.addAttribute("tbStu", tbStu);
        model.addAttribute("endState", Constants.BASI_STATE);
        model.addAttribute("search_basState", Utils.objToStr(searchParams.get("basState")));
        model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
        ArrayList<Integer> ages = new ArrayList<Integer>();
		for(int i=18; i<=35; i++){
			ages.add(i);
		}
		model.addAttribute("ages", ages);
        return "student/tbStu_list";
    }
	
	/**
	 * 添加学员
	 */
	@RequestMapping("add")
	public String add(Model model){
		ArrayList<Integer> ages = new ArrayList<Integer>();
		for(int i=18; i<=35; i++){
			ages.add(i);
		}
		model.addAttribute("ages", ages);
		model.addAttribute("endState", Constants.BASI_STATE);
		return "student/tbStu_add_form";
	}
	
	/**
	 * 保存学员信息
	 */
	@ResponseBody
	@RequestMapping("addSave")
	public String addSave(TBasiStudent tbStu){
		boolean flag = tBasiStudentService.findByNamePho(tbStu.getName(), tbStu.getPhone());
		if(flag){
			return Utils.toJson(tBasiStudentService.save(tbStu));
		}else{
			return Utils.toJson("error");
		}
	}
	
	@ResponseBody
	@RequestMapping("updateSave")
	public String updateSave(TBasiStudent tbStu){
		return Utils.toJson(tBasiStudentService.update(tbStu));
	}
	
	/**
	 * 查询学员详情
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Model model, String id){
		return Utils.toJson(tBasiStudentService.ufindByStuId(id));
	}
	
	/**
	 * 查询学员详情
	 */
	@ResponseBody
	@RequestMapping("detail")
	public String detail(Model model, String id){
		return Utils.toJson(tBasiStudentService.findByStuId(id));
	}
}
