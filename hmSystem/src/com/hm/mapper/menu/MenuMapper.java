package com.hm.mapper.menu;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.menu.Menu;

import java.util.List;
/**
 * Created by limiao on 2017-07-08.
 */
public interface MenuMapper {
    List<Menu> findMenuByPid(@Param("pid") String pid);

    Menu findMenuById(@Param("menuId") String menuId);

    int insert(@Param("menu") Menu menu);

    int update(@Param("menu") Menu menu);
    
    int falseDelete(@Param("menu") Menu menu);

    int delete(@Param("menuId") String menuId);

    int deleteRoleMenuByMenuId(@Param("menuId") String menuId);

    List<Menu> findAllMenus();
}
