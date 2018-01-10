package com.hm.web.clzss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.TClzssStudent;
import com.hm.entity.account.User;
import com.hm.entity.clzss.TBasiClzss;
import com.hm.mybatis.Page;
import com.hm.service.account.UserService;
import com.hm.service.clzss.TBasiClzssService;
import com.hm.service.clzss.TClzssStudentService;
import com.hm.util.Utils;

@Controller
@RequestMapping("/clzss")
public class TBasiClzssController {
	  @Autowired
	  private TBasiClzssService tBasiClzssService;
	  @Autowired
	  private UserService userService;
	  @Autowired
	  private TClzssStudentService tClzssStudentService;
	  
		@RequestMapping("add")
		public String add(Model model){
			List<User> user = userService.findAllUser();
			model.addAttribute("user", user);
			return "clzss/clzss_add_form";
		}
	
		/**
		 * 添加学员
		 */
		@ResponseBody
		@RequestMapping("/addClzss")
		public String addClzss(TBasiClzss clzss) {		
			clzss.setCreateUser(Utils.getName());
		     System.out.println(clzss);
			tBasiClzssService.addClazz(clzss);
			return Utils.toJson("123");
		}
		/**
		 * 列表查询
		 */
		@RequestMapping("/list")
	    public String list(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
			String name=request.getParameter("name");
			List<User> user = userService.findAllUser();
			model.addAttribute("user", user);
			Page<TBasiClzss> p= tBasiClzssService.listClzss(pageNo, name);
			request.setAttribute("p", p);
	        return "clzss/clzss_list";
	    }
		/**
		 * 查询项目组详情
		 */

//		@ResponseBody
//		@RequestMapping("/update")
//		public String update(Model model, String id){
//			List<User> user = userService.findAllUser();
//			Object [] o=new Object[]{user,tBasiClzssService.ClzssId(id)};
//			return Utils.toJson(o);
//		}

		@ResponseBody
		@RequestMapping("/update")
		public String update(Model model, String id){
			
			return Utils.toJson(tBasiClzssService.ClzssId(id));
		}

		
		/**
		 * 修改项目组详情
		 */
		@ResponseBody
		@RequestMapping("/updateClzss")
		public String updateClzss(TBasiClzss clzss){
			clzss.setUpdateUser(Utils.getName());
			tBasiClzssService.updateClzss(clzss);
			return Utils.toJson("123");
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
			Page<Map<String, String>> stus = tClzssStudentService.selectStuList(id,pageNo);
			request.setAttribute("name", name);
			request.setAttribute("stus", stus);
			request.setAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
			return "clzss/roomstu_list";
		}
		
		/**
		 * 查询所有项目组名称
		 * @param request
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/freeRoom")
		public String selectFreeRoom(HttpServletRequest request){
			
			List<Map<String, String>> list = tBasiClzssService.selectFreeRoom();
			
			return Utils.toJson(list);
		}
		/**
		 * 交换项目组名称
		 * @param request
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/insertStu")
		public String insertStu(HttpServletRequest request){
			  
				Map<String, String> obj = new HashMap<String, String>();
				try {
					 TClzssStudent record= new TClzssStudent();
						String stuId = request.getParameter("stuId");
						String cId = request.getParameter("cId");
						String roomId = request.getParameter("roomId");
						record.setId(cId);
						record.setStuId(stuId);
						record.setClzId(roomId);
						record.setState("1");
						record.setCreateUser(Utils.getName());
						System.out.println(record);
						int count =tClzssStudentService.insertStu(record);
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
