package com.hm.web.account;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.account.User;
import com.hm.mybatis.Page;
import com.hm.service.account.UserService;
import com.hm.service.common.CommonService;
import com.hm.service.common.CommonService;
import com.hm.service.role.RoleService;
import com.hm.util.Utils;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private CommonService commonService;
    
    @RequestMapping("list")
    public String list(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
        String keyword = Utils.objToStr(request.getParameter("keyword"));
        Page<User> users = userService.findUserByPage(keyword, pageNo);
        model.addAttribute("users", users);
        model.addAttribute("keyword", keyword);
        model.addAttribute("roles", roleService.findAllRoles());
        Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "keyword");
        model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "keyword"));
        return "account/user_list";
    }
    
    @ResponseBody
    @RequestMapping("save")
    public String save(User user) {
        return Utils.toJson(userService.saveUser(user));
    }

    @ResponseBody
    @RequestMapping("update")
    public String update(User user) {
        return Utils.toJson(userService.updateUser(user));
    }
    
    @ResponseBody
    @RequestMapping("findUserById")
    public String findUserById(@RequestParam("id") String id) {
        return Utils.toJson(userService.findUserById(id));
    }

    @ResponseBody
    @RequestMapping("checkLoginName")
    public Boolean checkLoginName(@RequestParam("loginName") String loginName, @RequestParam("id") String id) {
        return userService.checkLoginName(loginName, id) > 0;
    }

    @ResponseBody
    @RequestMapping("delete")
    public String delete(@RequestParam("id") String id) {
        return Utils.toJson(userService.deleteUser(id));
    }

    @ResponseBody
    @RequestMapping("falseDelete")
    public String falseDelete(@RequestParam("id") String id) {
        return Utils.toJson(userService.deleteUser(id));
    }
    //======================kjf
    //添加一个用户的目标方法
    @ResponseBody
    @RequestMapping("insertUser")
    public String insertUser(User user){
    	int count=userService.insertUser(user);
    	if(count>0){
    		return Utils.toJson("yes");
    	}
    	return Utils.toJson("no");
    }
    //重置用户密码
    @RequestMapping("resetUserPwd")
    @ResponseBody
    public String resetUserPwd(@RequestParam("id")Long id){
    	User user=new User();
    	user.setId(id);
    	user.setPassword("123456");
    	user.setPlainPassword("123456");
        user.setCreateTime(new Date());
        user.setCreateUser(Utils.getLoginName());
        int count=userService.updatePassword(user);
        if(count>0){
    		return Utils.toJson("yes");
    	}
    	return Utils.toJson("no");
    }
    @RequestMapping("userList")
    public String userList(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
        String keyword = Utils.objToStr(request.getParameter("keyword"));
        Page<User> users = userService.findUserByPage(keyword, pageNo);
        //拉取code中的办事处信息
        model.addAttribute("ofas", commonService.selectCodeByKind("ofa"));
        //拉取code中的员工级别信息
        model.addAttribute("gras", commonService.selectCodeByKind("gra"));
        //拉取code中的部门信息
        model.addAttribute("deps", commonService.selectCodeByKind("dep"));
        //拉取code中的角色信息
        model.addAttribute("roles", roleService.findAllRoles());
        model.addAttribute("users", users);
        model.addAttribute("keyword", keyword);
        Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "keyword");
        model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "keyword"));
        return "user/userPage";
    }
    
    @RequestMapping("editUser")
    @ResponseBody
    public String editUser(@RequestParam("id")Long id){
    	return Utils.toJson(userService.selectUserInfo(id));
    }
    @RequestMapping("updateUserInfo")
    @ResponseBody
    public String updateUserInfo(User user){
    	int count=userService.updateUserInfo(user);
        if(count>0){
    		return Utils.toJson("yes");
    	}
    	return Utils.toJson("no");
    }
}	
