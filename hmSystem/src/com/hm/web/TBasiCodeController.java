package com.hm.web;




import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.TBasiCode;
import com.hm.entity.account.User;
import com.hm.mybatis.Page;
import com.hm.service.TBasiCode.TBasiCodeService;
import com.hm.util.Utils;


@Controller
@RequestMapping("/TBasiCode")
public class TBasiCodeController {
	  @Autowired
	  private TBasiCodeService tBasiCodeService;
	  
	  @RequestMapping("list")
	  public String list(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model)  {
		  
	        String keyword = Utils.objToStr(request.getParameter("keyword"));
	     
	        String flag =Utils.objToStr(request.getParameter("type"));
	      
	        Page<TBasiCode>tBasiCode = tBasiCodeService.findTBasiCodeByPage(keyword, pageNo, flag);
	     
	        model.addAttribute("tBasiCode", tBasiCode);
	        model.addAttribute("flag", flag);
	        model.addAttribute("keyword", keyword);
	        Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "keyword");
	        model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "keyword"));
	        
	      
	        
	        return "dictionary/basicVocabulary_list";
	  }
	  
	  @ResponseBody
	  @RequestMapping("save")
	  public String save(TBasiCode record) {	  
		  return  Utils.toJson(tBasiCodeService.saveTBasiCode(record));
	  }
	 
	   @ResponseBody
	    @RequestMapping("findTBasiCodeById")
	    public String findTBasiCodeById(@RequestParam("id") String id) {
		   
	        return Utils.toJson(tBasiCodeService.findTBasiCodeById(id));
	    }
	   @ResponseBody
	    @RequestMapping("deleteTBasiCodeById")
	    public String deleteTBasiCodeById(String id) {
		   
		   return   Utils.toJson(tBasiCodeService.deleteTBasiCodeById(id));
	    }
}
