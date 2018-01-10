package com.hm.mapper.role;

import com.hm.entity.menu.Menu;
import com.hm.entity.role.Role;
import com.hm.mybatis.Page;

import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * Created by limiao on 2017-07-08.
 */
public interface RoleMapper {

    String getRoleId();

    int insert(@Param("role") Role role);

    int insertRoleMenu(@Param("uuid") String uuid, @Param("roleId") String roleId, @Param("menuId") String menuId);

    List<Role> findRolesByPage(@Param("keyword") String keyword, Page<Role> page);

    List<Role> findAllRoles();

    int deleteRoleMenuByRoleId(@Param("roleId") String roleId);

    int deleteRoleById(@Param("id") String id);

    List<Menu> findMenuIdsByRoleId(@Param("roleId") String roleId);

    Role findRoleMenuByRoleId(@Param("id") String id);

    int update(@Param("role") Role role);
    
}
