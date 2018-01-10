package com.hm.entity.agency;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiAgency extends BaseEntity<TBasiAgency> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4985275203572739849L;

	/**
     * HMDN.T_BASI_AGENCY.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String id;

    /**
     * HMDN.T_BASI_AGENCY.NAME (姓名)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String name;

    /**
     * HMDN.T_BASI_AGENCY.PHONE (联系电话)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String phone;

    /**
     * HMDN.T_BASI_AGENCY.GSMC (公司名称)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String gsmc;

    /**
     * HMDN.T_BASI_AGENCY.YWLX (业务类型)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String ywlx;

    /**
     * HMDN.T_BASI_AGENCY.GM (规模)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String gm;

    /**
     * HMDN.T_BASI_AGENCY.FD (返点)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String fd;

    /**
     * HMDN.T_BASI_AGENCY.WHR (关系维护人)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String whr;

    /**
     * HMDN.T_BASI_AGENCY.ZT (状态（合作/不合作）)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String zt;

    /**
     * HMDN.T_BASI_AGENCY.MARK (备注)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String mark;

    /**
     * HMDN.T_BASI_AGENCY.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_AGENCY.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private String createUser;

    /**
     * HMDN.T_BASI_AGENCY.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:03
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_AGENCY.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:03
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGsmc() {
        return gsmc;
    }

    public void setGsmc(String gsmc) {
        this.gsmc = gsmc;
    }

    public String getYwlx() {
        return ywlx;
    }

    public void setYwlx(String ywlx) {
        this.ywlx = ywlx;
    }

    public String getGm() {
        return gm;
    }

    public void setGm(String gm) {
        this.gm = gm;
    }

    public String getFd() {
        return fd;
    }

    public void setFd(String fd) {
        this.fd = fd;
    }

    public String getWhr() {
        return whr;
    }

    public void setWhr(String whr) {
        this.whr = whr;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
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
}