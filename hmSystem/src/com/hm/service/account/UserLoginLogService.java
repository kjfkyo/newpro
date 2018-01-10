package com.hm.service.account;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.entity.ShiroUser;
import com.hm.entity.account.UserLoginLog;
import com.hm.mapper.account.UserLoginLogMapper;
import com.hm.util.Utils;

/**
 * Created by limiao on 2017-07-08.
 */
@Service
@Transactional(readOnly = true)
public class UserLoginLogService {

    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Transactional(readOnly = false)
    public void insertLog(String sessionId) {
        if (userLoginLogMapper.countLog(sessionId) == 0) {
            UserLoginLog log = new UserLoginLog();
            ShiroUser shiroUser = Utils.getShiroUser();
            log.setSessionId(sessionId);
            log.setUserLoginName(shiroUser.loginName);
            log.setLoginTime(new Date());
            userLoginLogMapper.insert(log);
        }

    }

    public List<Integer> getLogData() {
        Calendar calendar = Calendar.getInstance();
        List<Integer> lists = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 14; i >= 0; i--) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            Integer count = userLoginLogMapper.getLogDatas(format.format(calendar.getTime()));
            lists.add(count);
        }
        return lists;
    }
}
