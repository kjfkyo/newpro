package com.hm.service.menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.entity.menu.Menu;
import com.hm.entity.menu.MenuTree;
import com.hm.mapper.menu.MenuMapper;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-07-04.
 */
@Service
@Transactional(readOnly = true)
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 使用递归获取菜单，用户页面左侧菜单.
     *
     * @param pid
     * @return
     */
    public List<Menu> getMenuByPid(String pid, List<Menu> menuIds) {
        List<Menu> menus = menuMapper.findMenuByPid(pid);
        List<Menu> lists = new ArrayList<>();
        if (menus != null) {
            for (int i = 0; i < menus.size(); i++) {
                Menu menu = menus.get(i);
                if (menuIds == null) {
                    break;
                }
                for (int j = 0; j < menuIds.size(); j++) {
                    if (menu.getMenuId().equals(menuIds.get(j).getMenuId())) {
                        menu.setChildren(getMenuByPid(menu.getMenuId(), menuIds));
                        lists.add(menu);
                    }
                }

            }
        }
        return lists;
    }

    /**
     * 使用递归获取菜单，用户页面左侧菜单.
     * admin 用户专有
     *
     * @param pid
     * @return
     */
    public List<Menu> getMenuByPid(String pid) {
        List<Menu> menus = menuMapper.findMenuByPid(pid);
        List<Menu> lists = new ArrayList<>();
        if (menus != null) {
            for (int i = 0; i < menus.size(); i++) {
                Menu menu = menus.get(i);
                menu.setChildren(getMenuByPid(menu.getMenuId()));
                lists.add(menu);
            }
        }
        return lists;
    }

    /**
     * 使用递归获得菜单，用户菜单tree展示.
     *
     * @param pid
     * @return
     */
    public List<MenuTree> getMenuTreeByPid(String pid) {
        List<Menu> menus = menuMapper.findMenuByPid(pid);
        List<MenuTree> lists = new ArrayList<>();
        if (menus != null) {
            for (int i = 0; i < menus.size(); i++) {
                Menu menu = menus.get(i);
                MenuTree menuTree = new MenuTree();
                menuTree.setName(menu.getMenuName());
                menuTree.setId(menu.getMenuId());
                menuTree.setChildren(getMenuTreeByPid(menu.getMenuId()));
                lists.add(menuTree);
            }
        }
        return lists;
    }

    public Menu findMenuById(String menuId) {
        return menuMapper.findMenuById(menuId);
    }

    @Transactional(readOnly = false)
    public int saveChildren(Menu menu) {
    	menu.setCreateTime(new Date());
    	menu.setCreateUser(Utils.getLoginName());
    	menu.setDelflag("0");
        return menuMapper.insert(menu);
    }

    @Transactional(readOnly = false)
    public int updateMenu(Menu menu) {
    	menu.setUpdateTime(new Date());
    	menu.setUpdateUser(Utils.getLoginName());
        return menuMapper.update(menu);
    }
    
    @Transactional(readOnly = false)
    public int updateFalseDelete(String menuId) {
    	Menu menu = menuMapper.findMenuById(menuId);
    	menu.setDelflag("1");
    	menu.setUpdateTime(new Date());
    	menu.setUpdateUser(Utils.getLoginName());
        return menuMapper.update(menu);
    }

    @Transactional(readOnly = false)
    public int deleteMenu(String menuId) {
        List<Menu> menus = this.getRoleMenuByPid(menuId);
        if (menus != null) {
            for (int i = 0; i < menus.size(); i++) {
                menuMapper.deleteRoleMenuByMenuId(menus.get(i).getMenuId());
            }
        }

        return menuMapper.delete(menuId);
    }

    /**
     * 使用递归获取菜单，用于角色管理中的tree.
     *
     * @param pid
     * @return
     */
    public List<Menu> getRoleMenuByPid(String pid) {
        List<Menu> menus = menuMapper.findMenuByPid(pid);
        if (menus != null) {
            for (int i = 0; i < menus.size(); i++) {
                Menu menu = menus.get(i);
                menus.addAll(getRoleMenuByPid(menu.getMenuId()));
            }
        }
        return menus;
    }

    public List<Menu> getAllMenus() {
        return menuMapper.findAllMenus();
    }
}
