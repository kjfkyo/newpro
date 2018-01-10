package com.hm.web.student;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.student.TAdvancedStudent;
import com.hm.entity.student.TBasiStudent;
import com.hm.entity.student.TEndStudent;
import com.hm.mybatis.Page;
import com.hm.service.clzss.TClzssStudentService;
import com.hm.service.common.CommonService;
import com.hm.service.student.TAdvancedStudentService;
import com.hm.service.student.TBasiStudentService;
import com.hm.service.student.TEndStudentService;
import com.hm.util.Constants;
import com.hm.util.Utils;
/**
 * Created by limiao on 2017-09-12.
 */
@Controller
@RequestMapping("/tEndStudent")
public class TEndStudentController {
	
	@Autowired
	private TEndStudentService tEndStudentService;
	@Autowired
	private TAdvancedStudentService tAdvancedStudentService;
	@Autowired
	private TClzssStudentService tClzssStudentService;
	@Autowired
	private TBasiStudentService tBasiStudentService;
	@Autowired
	private CommonService commonService;
	
	/**
	 * 列表查询（技术）
	 */
	@RequestMapping("listJS")
    public String listJS(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
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
        Page<TEndStudent> teStu = tEndStudentService.findTEStuByPageJS(Utils.objToStr(searchParams.get("name")), Utils.objToStr(searchParams.get("phone")),
        		claState,clzId, Utils.objToStr(searchParams.get("endState")), pageNo);
        model.addAttribute("states", commonService.selectCodeByType("end"));
        model.addAttribute("teStu", teStu);
        model.addAttribute("search_clzId", clzId);
        model.addAttribute("search_endState", Utils.objToStr(searchParams.get("endState")));
        model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
        return "student/teStu_list_js";
    }
	
	/**
	 * 列表查询（企合）
	 */
	@RequestMapping("listQH")
    public String listQH(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
        Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "search_");
        Page<TEndStudent> teStu = tEndStudentService.findTEStuByPageQH(Utils.objToStr(searchParams.get("name")), Utils.objToStr(searchParams.get("phone")),
        		Utils.objToStr(searchParams.get("clzId")), Utils.objToStr(searchParams.get("endState")), pageNo);
        model.addAttribute("states", commonService.selectCodeByType("end"));
        model.addAttribute("teStu", teStu);
        model.addAttribute("search_clzId", Utils.objToStr(searchParams.get("clzId")));
        model.addAttribute("search_endState", Utils.objToStr(searchParams.get("endState")));
        model.addAttribute("search_name", Utils.objToStr(searchParams.get("name")));
        model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "search_"));
        return "student/teStu_list_qh";
    }
	
	/**
	 * 技术部修改学员状态
	 */
	@ResponseBody
	@RequestMapping("updateSaveJS")
	public String updateSaveJS(@RequestParam("endState") String endState, @RequestParam("id") String id){
		return Utils.toJson(tEndStudentService.updateJS(endState, id));
	}
	
	/**
	 * 企合部修改学员信息
	 */
	@ResponseBody
	@RequestMapping("updateSaveQH")
	public String updateSaveQH(String jydw,Integer jyxz,String tjr,String jyrq,String id,String phone,String endState){
		return Utils.toJson(tEndStudentService.updateQH(jydw, jyxz, jyrq, tjr, id, phone, endState));
	}
	
	/**
	 * 查询学员详情
	 */
	@ResponseBody
	@RequestMapping("update")
	public String update(Model model, String id){
		return Utils.toJson(tEndStudentService.ufindByTEStuId(id));
	}
	
	/**
	 * 查询学员详情
	 */
	@ResponseBody
	@RequestMapping("detail")
	public String detail(Model model, String id){
		return Utils.toJson(tEndStudentService.findByTEStuId(id));
	}
	
	/**
	 * 封班
	 */
	@ResponseBody
	@RequestMapping("clzss")
	public String clzss(HttpServletRequest request){
		Map<String, String> obj = new HashMap<String, String>();
		if(Constants.ROLE_LEADER.equals(Utils.getUserGrade())){
			String arrayId = request.getParameter("arrayId");
			String clzId = request.getParameter("clzId");
			try{
				tEndStudentService.insertStuClzss(arrayId,clzId);
				obj.put("msg", "操作成功!");
				obj.put("state", "200");
			} catch(Exception e){
				e.printStackTrace();
				obj.put("msg", "操作失败!");
				obj.put("state", "500");
			}
		}else{
			obj.put("msg", "您没有权限!");
			obj.put("state", "401");
		}
		return Utils.toJson(obj);
	}
	
	/**
	 * 获取项目组
	 */
	@ResponseBody
	@RequestMapping("getClzss")
	public String getClzss(Model model){
		return Utils.toJson(tEndStudentService.getClzss());
	}
	/**
	 * 技术部修改 学员信息
	 */
	@ResponseBody
	@RequestMapping("updateStu")
	public String updateStuByJS(HttpServletRequest request){
		// id
		String id = request.getParameter("stuId");
		// 姓名
		String name = request.getParameter("name");
		// 年龄
		int age = Integer.parseInt(request.getParameter("age"));
		// 电话
		String phone = request.getParameter("phone");
		// 学历
		String edu = request.getParameter("edu");
		// qq
		String qq = request.getParameter("qq");
		// 微信
		String wechat = request.getParameter("wechat");
		// 来源
		String source = request.getParameter("source");
		// 资源获取人
		String getpeo = request.getParameter("getpeo");
		// 渠道
		String channel = request.getParameter("channel");
		// 渠道详情
		String channelDetail = request.getParameter("channelDetail");
		// 上门日期
		String doorday = request.getParameter("doorday");
		// 身份证号
		String card = request.getParameter("card");
		// 性别
		String sex = request.getParameter("sex");
		// 籍贯
		String place = request.getParameter("place");
		// 民族
		String nation = request.getParameter("nation");
		// 婚否
		String marital = request.getParameter("marital");
		// 毕业类别
		String eduType = request.getParameter("eduType");
		// 专业
		String major = request.getParameter("major");
		// 毕业院校
		String school = request.getParameter("school");
		// 讲师
		String teacher = request.getParameter("teacher");
		// 办事处
		String office = request.getParameter("office");
		// 缴费方式
		String payType = request.getParameter("payType");
		// 贷款机构
		String org = request.getParameter("org");
		// 紧急联系人
		String lxr = request.getParameter("lxr");
		// 紧急联系人电话
		String lxrPhone = request.getParameter("lxrPhone");
		// 人事
		String rs = request.getParameter("rs");
		// 咨询
		String zx = request.getParameter("zx");
		// 放款日期
		String fkDay = request.getParameter("fkDay");
		// 签约日期
		String qyDay = request.getParameter("qyDay");
		// 更新t_basi_student
		TBasiStudent tbStu = new TBasiStudent();
		tbStu.setId(id);
		tbStu.setName(name);
		tbStu.setAge(age);
		tbStu.setPhone(phone);
		tbStu.setEdu(edu);
		tbStu.setSource(source);
		tbStu.setChannel(channel);
		tbStu.setChannelDetail(channelDetail);
		tbStu.setGetpeo(getpeo);
		tbStu.setDoorday(doorday);
		tbStu.setUpdateTime(new Date());
		tbStu.setUpdateUser(Utils.getName());
		
		// 更新t_advanced_student
		TAdvancedStudent taStu = new TAdvancedStudent();
		taStu.setId(id);
		taStu.setName(name);
		taStu.setAge(age);
		taStu.setPhone(phone);
		taStu.setEdu(edu);
		taStu.setSource(source);
		taStu.setChannel(channel);
		taStu.setChannelDetail(channelDetail);
		taStu.setGetpeo(getpeo);
		taStu.setDoorday(doorday);
		taStu.setUpdateTime(new Date());
		taStu.setUpdateUser(Utils.getName());
		taStu.setCard(card);
		taStu.setSex(sex);
		taStu.setNation(nation);
		taStu.setPlace(place);
		taStu.setMarital(marital);
		taStu.setEduType(eduType);
		taStu.setMajor(major);
		taStu.setSchool(school);
		taStu.setTeacher(teacher);
		taStu.setOffice(office);
		taStu.setPayType(payType);
		taStu.setOrg(org);
		taStu.setLxr(lxr);
		taStu.setLxrPhone(lxrPhone);
		taStu.setRs(rs);
		taStu.setZx(zx);
		taStu.setQq(qq);
		taStu.setWechat(wechat);
		taStu.setFkDay(fkDay);
		taStu.setQyDay(qyDay);
		
		// 更新t_end_student
		TEndStudent teStu = new TEndStudent();
		teStu.setId(id);
		teStu.setName(name);
		teStu.setAge(age);
		teStu.setPhone(phone);
		teStu.setEdu(edu);
		teStu.setSource(source);
		teStu.setChannel(channel);
		teStu.setChannelDetail(channelDetail);
		teStu.setGetpeo(getpeo);
		teStu.setDoorday(doorday);
		teStu.setUpdateTime(new Date());
		teStu.setUpdateUser(Utils.getName());
		teStu.setCard(card);
		teStu.setSex(sex);
		teStu.setNation(nation);
		teStu.setPlace(place);
		teStu.setMarital(marital);
		teStu.setEduType(eduType);
		teStu.setMajor(major);
		teStu.setSchool(school);
		teStu.setTeacher(teacher);
		teStu.setOffice(office);
		teStu.setPayType(payType);
		teStu.setOrg(org);
		teStu.setLxr(lxr);
		teStu.setLxrPhone(lxrPhone);
		teStu.setRs(rs);
		teStu.setZx(zx);
		teStu.setQq(qq);
		teStu.setWechat(wechat);
		teStu.setFkDay(fkDay);
		teStu.setQyDay(qyDay);
		Map<String, String> obj = new HashMap<String, String>();
		try {
			tBasiStudentService.updateByJS(tbStu);
			tAdvancedStudentService.updateByJS(taStu);
			tEndStudentService.updateByJS(teStu);
			obj.put("msg", "ok");
		} catch (Exception e) {
			obj.put("msg", "error");
		}
		return Utils.toJson(obj);
	}
}
