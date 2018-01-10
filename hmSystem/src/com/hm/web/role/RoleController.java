package com.hm.web.role;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.role.Role;
import com.hm.mybatis.Page;
import com.hm.service.menu.MenuService;
import com.hm.service.role.RoleService;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-07-11.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("list")
    public String list(ServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer pageNo, Model model) {
        String keyword = request.getParameter("keyword");
        Page<Role> roles = roleService.findRolesByPage(keyword, pageNo);
        model.addAttribute("menus", Utils.toJson(menuService.getRoleMenuByPid("0")));
        model.addAttribute("roles", roles);
        model.addAttribute("keyword", keyword);
        //Map<String, Object> searchParams = Utils.getParametersStartingWith(request, "keyword");
        //model.addAttribute("searchParams", Utils.encodeParameterStringWithPrefix(searchParams, "keyword"));
        return "role/role_list";
    }

    @ResponseBody
    @RequestMapping("save")
    public String save(Role role) {
        return Utils.toJson(roleService.saveRole(role));
    }

    @ResponseBody
    @RequestMapping("delete")
    public String delete(@RequestParam("id") String id) {
        return Utils.toJson(roleService.deleteRole(id));
    }

    @ResponseBody
    @RequestMapping("findRoleById")
    public String findRoleById(@RequestParam("id") String id) {
        return Utils.toJson(roleService.findRoleMenuByRoleId(id));
    }

    @ResponseBody
    @RequestMapping("update")
    public String update(Role role) {
        return Utils.toJson(roleService.updateRole(role));
    }

}
