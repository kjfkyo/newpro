package com.hm.service.account;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.entity.account.User;
import com.hm.mapper.account.UserMapper;
import com.hm.mybatis.Page;
import com.hm.util.Digests;
import com.hm.util.Encodes;
import com.hm.util.Utils;

@Service
@Transactional(readOnly = true) // 默认spring只读事物
public class UserService {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    /**
     * 登录时校验
     * @param loginName
     * @return
     */
    public User findUserByLoginName(String loginName) {
        return userMapper.findUserByLoginName(loginName);
    }

    public Page<User> findUserByPage(String keyword, Integer pageNo) {
        Page<User> page = new Page<>();
        page.setPageNo(pageNo);
        userMapper.findUserByPage(keyword, page);
        return page;
    }

    @Transactional(readOnly = false)
    public int saveUser(User user) {
        entryptPassword(user);
        user.setCreateTime(new Date());
        user.setCreateUser(Utils.getLoginName());
        user.setDelflag("0");
        return userMapper.save(user);
    }

    public int checkLoginName(String loginName, String id) {
        return userMapper.countUserByLoginName(loginName, Utils.objToStr(id));
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        user.setSalt(Encodes.encodeHex(salt));
        
        byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
       
        user.setPassword(Encodes.encodeHex(hashPassword));
    }

    public User findUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Transactional(readOnly = false)
    public int updateUser(User user) {
    	user.setUpdateTime(new Date());
    	user.setUpdateUser(Utils.getLoginName());
        return userMapper.update(user);
    }

    @Transactional(readOnly = false)
    public int deleteUser(String id) {
        return userMapper.delete(id);
    }
    
    @Transactional(readOnly = false)
    public int falseDelete(String id) {
    	User user = userMapper.getUserById(id);
    	user.setDelflag("1");
    	user.setUpdateTime(new Date());
    	user.setUpdateUser(Utils.getLoginName());
        return userMapper.delete(id);
    }    
    @Transactional(readOnly = false)
    public int updatePassword(User user) {
    	entryptPassword(user);
    	user.setUpdateTime(new Date());
    	user.setUpdateUser(Utils.getLoginName());
        return userMapper.updatePassword(user);
    }
    //新注册一个用户
    public int insertUser(User user){
    	user.setPassword("123456");
    	user.setPlainPassword("123456");
        user.setCreateTime(new Date());
        user.setCreateUser(Utils.getLoginName());
        user.setUpdateTime(new Date());
        user.setDelflag("0");
        user.setUpdateUser(Utils.getLoginName());
        entryptPassword(user);
        System.out.println(user);
    	return userMapper.insertUser(user);
    }

    
    /**
     * chaxun
     * @param user
     * @return
     */
    public List<User> findAllUser(){
    	return userMapper.findAllUser();
    }

    public User selectUserInfo(Long id){
    	return userMapper.selectUserInfo(id);
    }
    public int updateUserInfo(User user) {
    	user.setCreateTime(new Date());
        user.setCreateUser(Utils.getLoginName());
    	user.setUpdateTime(new Date());
    	user.setUpdateUser(Utils.getLoginName());
    	if("离职".equals(user.getStatus())){
    		user.setDelflag("1");
    	}
    	//System.out.println(user);
        return userMapper.updateUserInfo(user);
    }

}
