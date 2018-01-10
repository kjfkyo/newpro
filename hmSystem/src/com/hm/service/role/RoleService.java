package com.hm.service.role;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.entity.menu.Menu;
import com.hm.entity.role.Role;
import com.hm.mapper.role.RoleMapper;
import com.hm.mybatis.Page;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-07-11.
 */
@Service
@Transactional(readOnly = true)
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Transactional(readOnly = false)
    public String saveRole(Role role) {
        role.setCreateUser(Utils.getLoginName());
        role.setCreateTime(new Date());
        String roleId = roleMapper.getRoleId();
        role.setId(roleId);
        roleMapper.insert(role);
        String menus = role.getMenuIds();
        if (menus != null && menus.length() > 0) {
            String[] ids = menus.split(",");
            for (int i = 0; i < ids.length; i++) {
                roleMapper.insertRoleMenu(UUID.randomUUID().toString(), roleId, ids[i]);
            }
        }
        return role.getName();
    }

    public Page<Role> findRolesByPage(String keyword, Integer pageNo) {
        Page<Role> page = new Page<>();
        page.setPageNo(pageNo);
        roleMapper.findRolesByPage(keyword, page);
        return page;
    }

    public List<Role> findAllRoles() {
        return roleMapper.findAllRoles();
    }

    @Transactional(readOnly = false)
    public int deleteRole(String id) {
        roleMapper.deleteRoleMenuByRoleId(id);
        return roleMapper.deleteRoleById(id);
    }

    public List<Menu> findMenuIdsByRoleId(String roleId) {
        return roleMapper.findMenuIdsByRoleId(roleId);
    }

    public Role findRoleMenuByRoleId(String id) {
        return roleMapper.findRoleMenuByRoleId(id);
    }

    @Transactional(readOnly = false)
    public int updateRole(Role role) {
        String menus = role.getMenuIds();
        roleMapper.deleteRoleMenuByRoleId(role.getId());
        if (menus != null && menus.length() > 0) {
            String[] ids = menus.split(",");
            for (int i = 0; i < ids.length; i++) {
                roleMapper.insertRoleMenu(UUID.randomUUID().toString(), role.getId(), ids[i]);
            }
        }
        role.setUpdateUser(Utils.getLoginName());
        role.setUpdateTime(new Date());
        return roleMapper.update(role);
    }
}
