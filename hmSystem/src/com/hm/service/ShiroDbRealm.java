package com.hm.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.hm.entity.ShiroUser;
import com.hm.entity.account.User;
import com.hm.entity.menu.Menu;
import com.hm.service.account.UserService;
import com.hm.service.menu.MenuService;
import com.hm.service.role.RoleService;
import com.hm.util.Constant;
import com.hm.util.Encodes;
import com.hm.util.Utils;

public class ShiroDbRealm extends AuthorizingRealm {

    protected UserService userService;

    protected MenuService menuService;

    protected RoleService roleService;
    

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = userService.findUserByLoginName(token.getUsername());
        if (user != null) {
            byte[] salt = Encodes.decodeHex(user.getSalt());
            AuthenticationInfo info = new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getLoginName(), user.getName(), user.getRoles(), user.getDepartment(), user.getGrade()),
                    user.getPassword(), ByteSource.Util.bytes(salt), getName());
            if ("admin".equals(user.getLoginName())) {
                Utils.getSession().setAttribute("MENUS", menuService.getMenuByPid(Constant.TOP_MENU_ID));
            } else {
                List<Menu> menuIds = roleService.findMenuIdsByRoleId(user.getRoles());
                Utils.getSession().setAttribute("MENUS", menuService.getMenuByPid(Constant.TOP_MENU_ID, menuIds));
            }
            return info;
        } else {
            return null;
        }
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        User user = userService.findUserByLoginName(shiroUser.loginName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // info.addRoles(user.getRoleList());
        return info;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(UserService.HASH_ALGORITHM);
        matcher.setHashIterations(UserService.HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
