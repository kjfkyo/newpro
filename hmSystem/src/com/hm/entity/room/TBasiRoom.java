package com.hm.entity.room;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiRoom extends BaseEntity<TBasiRoom> {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4541002143222806616L;

	/**
     * HMDN.T_BASI_ROOM.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String id;

    /**
     * HMDN.T_BASI_ROOM.NAME (宿舍名称)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String name;

    /**
     * HMDN.T_BASI_ROOM.ADDR (宿舍地址)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String addr;

    /**
     * HMDN.T_BASI_ROOM.FD (房东)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String fd;

    /**
     * HMDN.T_BASI_ROOM.FD_PHONE (房东电话)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String fdPhone;

    /**
     * HMDN.T_BASI_ROOM.MONEY (租金)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private Integer money;

    /**
     * HMDN.T_BASI_ROOM.START_DATE (开始日期)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String startDate;

    /**
     * HMDN.T_BASI_ROOM.END_DATE (到期日期)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String endDate;

    /**
     * HMDN.T_BASI_ROOM.COUNT_STU (可容纳人数)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private Integer countStu;

    /**
     * HMDN.T_BASI_ROOM.mark (备注)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String mark;
    
    /**
     * HMDN.T_BASI_ROOM.STATE (状态)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String state;
    
    /**
     * HMDN.T_BASI_ROOM.DELFLAG (删除标识)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String delflag;

    /**
     * HMDN.T_BASI_ROOM.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_ROOM.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String createUser;

    /**
     * HMDN.T_BASI_ROOM.UPDATE_TIME (在以后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_ROOM.UPDATE_USER (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:05
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getFd() {
        return fd;
    }

    public void setFd(String fd) {
        this.fd = fd;
    }

    public String getFdPhone() {
        return fdPhone;
    }

    public void setFdPhone(String fdPhone) {
        this.fdPhone = fdPhone;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getCountStu() {
        return countStu;
    }

    public void setCountStu(Integer countStu) {
        this.countStu = countStu;
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

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
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
}