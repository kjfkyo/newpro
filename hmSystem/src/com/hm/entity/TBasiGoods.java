package com.hm.entity;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiGoods extends BaseEntity<TBasiGoods> {
    /**
     * HMDN.T_BASI_GOODS.ID (主键)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private String id;

    /**
     * HMDN.T_BASI_GOODS.NAME (物品编号名称)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private String name;

    /**
     * HMDN.T_BASI_GOODS.TYPE (商品类型)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private String type;

    /**
     * HMDN.T_BASI_GOODS.USER_ID (使用人id（用户表）)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private String userId;

    /**
     * HMDN.T_BASI_GOODS.MARK (备注)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private String mark;

    /**
     * HMDN.T_BASI_GOODS.STATE (物品状态（使用、损坏、丢失）)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private String state;

    /**
     * HMDN.T_BASI_GOODS.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_GOODS.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private String createUser;

    /**
     * HMDN.T_BASI_GOODS.UPDATE_TIME (最后修改人)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_GOODS.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:27:59
     */
    private String updateUser;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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
		return "TBasiGoods [id=" + id + ", name=" + name + ", type=" + type
				+ ", userId=" + userId + ", mark=" + mark + ", state=" + state
				+ ", createTime=" + createTime + ", createUser=" + createUser
				+ ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ "]";
	}
}