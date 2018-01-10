package com.hm.entity.account;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

/**
 * Created by limiao on 2017-07-08.
 */
public class UserLoginLog extends BaseEntity<UserLoginLog> {
	private static final long serialVersionUID = 1L;

	private String sessionId;

    private String userLoginName;

    private Date loginTime;

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
