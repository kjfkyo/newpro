package com.hm.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by limiao on 2017-07-08.
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    public Long id;
    public String loginName;
    public String name;
    public String roles;//角色
    public String department;//部门
    public String grade;//级别

    public ShiroUser(Long id, String loginName, String name,
    		String roles, String department, String grade) {
        this.id = id;
        this.loginName = loginName;
        this.name = name;
        this.roles = roles;
        this.department = department;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

	/**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return loginName;
    }

    /**
     * 重载hashCode,只计算loginName;
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(loginName);
    }

    /**
     * 重载equals,只计算loginName;
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ShiroUser other = (ShiroUser) obj;
        if (loginName == null) {
            if (other.loginName != null) {
                return false;
            }
        } else if (!loginName.equals(other.loginName)) {
            return false;
        }
        return true;
    }
}
