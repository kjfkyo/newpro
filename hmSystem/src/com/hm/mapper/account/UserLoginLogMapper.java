package com.hm.mapper.account;

import org.apache.ibatis.annotations.Param;

import com.hm.entity.account.UserLoginLog;
/**
 * Created by limiao on 2017-07-08.
 */
public interface UserLoginLogMapper {

    int insert(@Param("log") UserLoginLog log);

    int countLog(@Param("sessionId") String sessionId);

    Integer getLogDatas(@Param("time") String time);
}
