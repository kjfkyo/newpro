package com.hm.entity;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TClzssStudent extends BaseEntity<TClzssStudent> {
    /**
     * HMDN.T_CLZSS_STUDENT.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String id;

    /**
     * HMDN.T_CLZSS_STUDENT.STU_ID (学员id)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String stuId;

    /**
     * HMDN.T_CLZSS_STUDENT.CLZ_ID (项目组id)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String clzId;

    /**
     * HMDN.T_CLZSS_STUDENT.STATE (状态1正常，0转走)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String state;

    /**
     * HMDN.T_CLZSS_STUDENT.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private Date createTime;

    /**
     * HMDN.T_CLZSS_STUDENT.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String createUser;

    /**
     * HMDN.T_CLZSS_STUDENT.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private Date updateTime;

    /**
     * HMDN.T_CLZSS_STUDENT.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:01
     */
    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getClzId() {
        return clzId;
    }

    public void setClzId(String clzId) {
        this.clzId = clzId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

	@Override
	public String toString() {
		return "TClzssStudent [id=" + id + ", stuId=" + stuId + ", clzId="
				+ clzId + ", state=" + state + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", updateTime=" + updateTime
				+ ", updateUser=" + updateUser + "]";
	}
    
}