package com.hm.entity;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiVisit extends BaseEntity<TBasiVisit> {
    /**
     * HMDN.T_BASI_VISIT.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String id;

    /**
     * HMDN.T_BASI_VISIT.STU_ID (学员id)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String stuId;

    /**
     * HMDN.T_BASI_VISIT.HF_DATE (回访日期)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String hfDate;

    /**
     * HMDN.T_BASI_VISIT.NR (回访内容)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String nr;

    /**
     * HMDN.T_BASI_VISIT.HFR (回访人)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String hfr;

    /**
     * HMDN.T_BASI_VISIT.TYPE (类型（网咨、咨询）)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String type;

    /**
     * HMDN.T_BASI_VISIT.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_VISIT.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String createUser;

    /**
     * HMDN.T_BASI_VISIT.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_VISIT.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:03
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

    public String getHfDate() {
        return hfDate;
    }

    public void setHfDate(String hfDate) {
        this.hfDate = hfDate;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getHfr() {
        return hfr;
    }

    public void setHfr(String hfr) {
        this.hfr = hfr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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