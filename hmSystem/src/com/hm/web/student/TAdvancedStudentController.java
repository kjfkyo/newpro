package com.hm.web.student;

import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.student.TAdvancedStudent;
import com.hm.mybatis.Page;
import com.hm.service.student.TAdvancedStudentService;
import com.hm.util.Constants;
import com.hm.util.Utils;

@Controller
@RequestMapping("/tAdvancedStudent")
public class TAdvancedStudentController {
	
	@Autowired
	private TAdvancedStudentService tAdvancedStudentService;
	
	/**
	 * 列表查询（咨询）
	 */
	@RequestMapping("list")
    public String list(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
        Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "search_");
        String claState = null;
        String clzId = Utils.objToStr(searchParams.get("clzId"));
        if(clzId != null && !"".equals(clzId)){
        	if("0".equals(clzId)){
            	claState = "0";
            }else{
            	claState = "1";
            }
        }
        Page<TAdvancedStudent> taStu = tAdvancedStudentService.findTAStuByPage(Utils.objToStr(searchParams.get("name")), Utils.objToStr(searchParams.get("phone")),
        		claState,clzId,Utils.objToStr(searchParams.get("advState")),pageNo);
        model.addAttribute("endState", Constants.ADVA_STATE);
        model.addAttribute("taStu", taStu);
        model.addAttribute("search_clzId", clzId);
        model.addAttribute("search_advState", Utils.objToStr(searchParams.get("advState")));
        model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
        return "student/taStu_list";
    }
	
	@ResponseBody
	@RequestMapping("updateSave")
	public String updateSave(TAdvancedStudent taStu){
		return Utils.toJson(tAdvancedStudentService.update(taStu));
	}
	
	/**
	 * 查询学员详情
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Model model, String id){
		return Utils.toJson(tAdvancedStudentService.ufindByTAStuId(id));
	}
	
	/**
	 * 查询学员详情
	 */
	@ResponseBody
	@RequestMapping("detail")
	public String detail(Model model, String id){
		return Utils.toJson(tAdvancedStudentService.findByTAStuId(id));
	}
}
