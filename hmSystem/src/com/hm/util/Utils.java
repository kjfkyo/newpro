package com.hm.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletRequest;

import org.apache.commons.lang3.Validate;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.entity.ShiroUser;

/**
 * 公共方法
 * 
 * @author limiao
 */
public class Utils {

    /**
     * 时间格式转化
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToStr(Date date, String pattern) {
        if (pattern == null || "".equals(pattern)) {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        if (date == null) {
            return null;
        }
        return format.format(date);
    }

    /* * Object转化成json
    *
    * @param object
    * @return
    */
    public static String toJson(Object object) {
        try {
            return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_DEFAULT).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String objToStr(Object obj) {
        if (obj != null && !"".equals(obj)) {
            return obj.toString();
        }
        return null;
    }

    /**
     * 获取shiro的session
     *
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取shiroUser.
     *
     * @return
     */
    public static ShiroUser getShiroUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
    }

    /**
     * 获取登录用户名.
     *
     * @return
     */
    public static String getLoginName() {
        return getShiroUser().loginName;
    }
    
    /**
     * 获取用户名真实姓名.
     *
     * @return
     */
    public static String getName() {
        return getShiroUser().name;
    }

    /**
     * 获取登录用户ID.
     *
     * @return
     */
    public static Long getUserId() {
        return getShiroUser().id;
    }
    
    /**
     * 获取登录用户角色.
     *
     * @return
     */
    public static String getUserIRoles() {
        return getShiroUser().roles;
    }
    
    /**
     * 获取登录用户部门.
     *
     * @return
     */
    public static String getUserDep() {
        return getShiroUser().department;
    }
    
    /**
     * 获取登录用户级别.
     *
     * @return
     */
    public static String getUserGrade() {
        return getShiroUser().grade;
    }

    /**
     * 获取以prefix参数开头的请求参数，去掉prefix前缀后装载到map中.
     *
     * @param request
     * @param prefix
     * @return
     */
    public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
        Validate.notNull(request, "Request must not be null", new Object[0]);
        Enumeration paramNames = request.getParameterNames();
        Map<String, Object> params = new TreeMap();
        if (prefix == null) {
            prefix = "";
        }

        while (paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            if ("".equals(prefix) || paramName.startsWith(prefix)) {
                String unprefixed = paramName.substring(prefix.length());
                String[] values = request.getParameterValues(paramName);
                if (values != null && values.length != 0) {
                    if (values.length > 1) {
                        params.put(unprefixed, values);
                    } else {
                        params.put(unprefixed, values[0]);
                    }
                }
            }
        }

        return params;
    }

    /**
     * 将参数回显到页面，通过${param.prefix...}调用.
     *
     * @param params
     * @param prefix
     * @return
     */
    public static String encodeParameterStringWithPrefix(Map<String, Object> params, String prefix) {
        if (params != null && !params.isEmpty()) {
            if (prefix == null) {
                prefix = "";
            }

            StringBuilder queryStringBuilder = new StringBuilder();
            Iterator it = params.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry) it.next();
                queryStringBuilder.append(prefix).append((String) entry.getKey()).append('=').append(entry.getValue());
                if (it.hasNext()) {
                    queryStringBuilder.append('&');
                }
            }

            return queryStringBuilder.toString();
        } else {
            return "";
        }
    }
}
