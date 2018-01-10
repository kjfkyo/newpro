package com.hm.entity.clzss;

import java.io.Serializable;
import java.util.Date;

public class TBasiClzss implements Serializable {
    /**
     * HMDN.T_BASI_CLZSS.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String id;

    /**
     * HMDN.T_BASI_CLZSS.NAME (项目组名称)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String name;
    /**
     * HMDN.T_BASI_CLZSS.teaId (项目组工程师)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String teaId;

  
	/**
     * HMDN.T_BASI_CLZSS.START_DATE (开班日期)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String startDate;

    /**
     * HMDN.T_BASI_CLZSS.END_DATE (结课日期)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String endDate;

    /**
     * HMDN.T_BASI_CLZSS.QQ (QQ群)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String qq;

    /**
     * HMDN.T_BASI_CLZSS.MARK (备注)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String mark;

    /**
     * HMDN.T_BASI_CLZSS.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_CLZSS.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private String createUser;

    /**
     * HMDN.T_BASI_CLZSS.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:05
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_CLZSS.UPDATE_USER (最后修改人)
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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
    public String getTeaId() {
  		return teaId;
  	}

  	public void setTeaId(String teaId) {
  		this.teaId = teaId;
  	}

	@Override
	public String toString() {
		return "TBasiClzss [id=" + id + ", name=" + name + ", teaId=" + teaId
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", qq="
				+ qq + ", mark=" + mark + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", updateTime=" + updateTime
				+ ", updateUser=" + updateUser + "]";
	}

	
    
}