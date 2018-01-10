package com.hm.entity.student;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiStudent extends BaseEntity<TBasiStudent> {
    /**
     * HMDN.T_BASI_STUDENT.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String id;

    /**
     * HMDN.T_BASI_STUDENT.NAME (姓名)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String name;

    /**
     * HMDN.T_BASI_STUDENT.AGE (年龄)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private Integer age;

    /**
     * HMDN.T_BASI_STUDENT.PHONE (电话)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String phone;

    /**
     * HMDN.T_BASI_STUDENT.EDU (学历)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String edu;

    /**
     * HMDN.T_BASI_STUDENT.SOURCE (来源)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String source;

    /**
     * HMDN.T_BASI_STUDENT.CHANNEL (渠道)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String channel;

    /**
     * HMDN.T_BASI_STUDENT.CHANNEL_DETAIL (渠道详细)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String channelDetail;

    /**
     * HMDN.T_BASI_STUDENT.GETPEO (资源获取人)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String getpeo;

    /**
     * HMDN.T_BASI_STUDENT.DOORDAY (上门日期)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String doorday;

    /**
     * HMDN.T_BASI_STUDENT.BAS_STATE (状态（添加）)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String basState;

    /**
     * HMDN.T_BASI_STUDENT.BAS_MARK (备注)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String basMark;

    /**
     * HMDN.T_BASI_STUDENT.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_STUDENT.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String createUser;

    /**
     * HMDN.T_BASI_STUDENT.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_STUDENT.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String updateUser;
    
    private String createUserRole;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelDetail() {
        return channelDetail;
    }

    public void setChannelDetail(String channelDetail) {
        this.channelDetail = channelDetail;
    }

    public String getGetpeo() {
        return getpeo;
    }

    public void setGetpeo(String getpeo) {
        this.getpeo = getpeo;
    }

    public String getDoorday() {
        return doorday;
    }

    public void setDoorday(String doorday) {
        this.doorday = doorday;
    }

    public String getBasState() {
        return basState;
    }

    public void setBasState(String basState) {
        this.basState = basState;
    }

    public String getBasMark() {
        return basMark;
    }

    public void setBasMark(String basMark) {
        this.basMark = basMark;
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

	public String getCreateUserRole() {
		return createUserRole;
	}

	public void setCreateUserRole(String createUserRole) {
		this.createUserRole = createUserRole;
	}
}