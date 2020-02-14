package com.huameng.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huameng.bean.Sclass;
import com.huameng.bean.Student;
import com.huameng.mybatis.Page;
import com.huameng.service.StudentService;

@Controller
public class StudentController {
	 private static Logger log=LoggerFactory.getLogger(StudentController.class);
	@Resource
	StudentService studentService;
	
	@RequestMapping("hello")
	public String testHello(Model model,@RequestParam(value = "page", defaultValue = "1") Integer pageNo){
		Page<Student> slist=studentService.selectStudentPageAll(pageNo);
		List<Sclass> clist=studentService.selectSclassAll();
		model.addAttribute("stuList", slist);
		model.addAttribute("claList", clist);
		model.addAttribute("url", "hello");
		return "success";
	}
	
	@RequestMapping("insertStudent")
	public String insertStudent(Model model,Student stu){
		String s="";
		try {
			s=new String(stu.getS_name().getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		stu.setS_name(s);
		studentService.insertStudent(stu);
		return "forward:hello?pageConut=1";
	}
	@RequestMapping("selectSclassAll")
	@ResponseBody
	public List<Sclass> selectSclassAll(){
		List<Sclass> clist=studentService.selectSclassAll();
		return clist;
	}
	@RequestMapping("selectStudentById")
	@ResponseBody
	public Student selectStudentById(Model model,@RequestParam("s_id")int s_id){
		Student stu=studentService.selectStudentById(s_id);
		model.addAttribute("student", stu);
		return stu;
	}
	@RequestMapping("updateStudentById")
	public String updateStudentById(Student stu){
		studentService.updateStudent(stu);
		return "forward:hello?pageConut=1";
	}
	@RequestMapping("deleteStudentById")
	public String deleteStudentById(@RequestParam("s_id")int s_id){
		studentService.deleteStudentById(s_id);
		return "forward:hello?pageConut=1";
	}
}
