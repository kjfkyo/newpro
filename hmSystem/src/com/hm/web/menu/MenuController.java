package com.hm.web.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.entity.menu.Menu;
import com.hm.entity.menu.MenuTree;
import com.hm.service.menu.MenuService;
import com.hm.util.Constant;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-07-04.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("tree")
    public String tree(Model model) {
        List<MenuTree> trees = menuService.getMenuTreeByPid(Constant.TOP_MENU_ID);
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("trees", Utils.toJson(trees));
        model.addAttribute("menus", menus);
        return "menu/menu_list";
    }

    @ResponseBody
    @RequestMapping("findMenuById")
    public String getMenu(@RequestParam("menuId") String menuId) {
        return Utils.toJson(menuService.findMenuById(menuId));
    }

    @ResponseBody
    @RequestMapping("saveChildren")
    public String saveChildren(Menu menu) {
        return Utils.toJson(menuService.saveChildren(menu));
    }

    @ResponseBody
    @RequestMapping("update")
    public String update(Menu menu) {
        return Utils.toJson(menuService.updateMenu(menu));
    }

    @ResponseBody
    @RequestMapping("falseDelete")
    public String falseDelete(@RequestParam("menuId") String menuId) {
        return Utils.toJson(menuService.updateFalseDelete(menuId));
    }
    
    @ResponseBody
    @RequestMapping("delete")
    public String delete(@RequestParam("menuId") String menuId) {
        return Utils.toJson(menuService.deleteMenu(menuId));
    }
}
