package com.hm.mapper.account;

import java.util.List;

import com.hm.entity.account.User;
import com.hm.mybatis.Page;

import org.apache.ibatis.annotations.Param;

/**
 * mybatis特有类，相当于dao，通过方法名可以调用mapper.xml中的sql语句
 *
 * @author limiao
 */
public interface UserMapper {
	/**
	 * 查询所有用户
	 * @return
	 */
    List<User> getAllUser();
    
    /**
     * 根据id查询一个用户信息
     * @param id
     * @return
     */
    User getUserById(@Param("id") String id);

    /**
     * 权限管理中用户保存方法
     * @param user
     * @return
     */
    int save(@Param("user") User user);

    /**
     * 登录时判断用户是否存在
     * @param loginName
     * @return
     */
    User findUserByLoginName(@Param("loginName") String loginName);

    /**
     * 分页显示用户列表页 
     * @param keyword 模糊查询参数
     * @param page
     * @return
     */
    List<User> findUserByPage(@Param("keyword") String keyword, Page<User> page);

    /**
     * 添加用户时判断登录名是否重复
     * @param loginName
     * @param id
     * @return
     */
    int countUserByLoginName(@Param("loginName") String loginName, @Param("id") String id);

    /**
     * 权限管理中修改用户信息
     * @param user
     * @return
     */
    int update(@Param("user") User user);
    int updatePassword(@Param("user") User user);
    /**
     * 删除用户（真删）
     * @param id
     * @return
     */
    int delete(@Param("id") String id);
    
    /**
     * 删除用户（假删，修改状态delflag值为1，数据库中存在，但页面中不显示）
     * @param user
     * @return
     */
    int falseDelete(@Param("user") User user);
    /**
     * 注册用户
     * @param user
     * @return
     */
    int insertUser(@Param("user") User user);
    /**
     * chaxun
     * @param user
     * @return
     */
    List<User> findAllUser();
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserInfo(@Param("user") User user);
    /**
     * 修改之前使用ID字段查询用户信息
     * @param user
     * @return
     */
    User selectUserInfo(@Param("id")Long id);
    /**
     * 根据部门名称，查询该部门下所有的人员信息
     * @param depName
     * @return List<String>
     */
    List<String> selectUserByDep(@Param("dep")String dep);
}
