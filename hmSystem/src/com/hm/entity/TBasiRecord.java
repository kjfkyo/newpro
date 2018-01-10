package com.hm.entity;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiRecord extends BaseEntity<TBasiRecord> {
    /**
     * HMDN.T_BASI_RECORD.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String id;

    /**
     * HMDN.T_BASI_RECORD.STU_ID (学员id)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String stuId;

    /**
     * HMDN.T_BASI_RECORD.NAME (企业名称)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String name;

    /**
     * HMDN.T_BASI_RECORD.MS_DATE (面试日期)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String msDate;

    /**
     * HMDN.T_BASI_RECORD.DLR (带领人)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String dlr;

    /**
     * HMDN.T_BASI_RECORD.ZW (职位)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String zw;

    /**
     * HMDN.T_BASI_RECORD.JG (结果)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String jg;

    /**
     * HMDN.T_BASI_RECORD.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_RECORD.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String createUser;

    /**
     * HMDN.T_BASI_RECORD.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_RECORD.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:00
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsDate() {
        return msDate;
    }

    public void setMsDate(String msDate) {
        this.msDate = msDate;
    }

    public String getDlr() {
        return dlr;
    }

    public void setDlr(String dlr) {
        this.dlr = dlr;
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
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