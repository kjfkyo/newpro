package com.hm.entity.company;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiCompany extends BaseEntity<TBasiCompany> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8735104572709227785L;

	/**
     * HMDN.T_BASI_COMPANY.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String id;

    /**
     * HMDN.T_BASI_COMPANY.NAME (企业名称)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String name;

    /**
     * HMDN.T_BASI_COMPANY.ADDRESS (企业地址)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String address;

    /**
     * HMDN.T_BASI_COMPANY.LXR (联系人)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String lxr;

    /**
     * HMDN.T_BASI_COMPANY.LXDH (联系电话)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String lxdh;

    /**
     * HMDN.T_BASI_COMPANY.HZYX (合作意向)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String hzyx;

    /**
     * HMDN.T_BASI_COMPANY.WHR (关系维护人)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String whr;

    /**
     * HMDN.T_BASI_COMPANY.ZT (状态（合作/不合作）)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String zt;

    /**
     * HMDN.T_BASI_COMPANY.MARK (备注)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String mark;

    /**
     * HMDN.T_BASI_COMPANY.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_COMPANY.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private String createUser;

    /**
     * HMDN.T_BASI_COMPANY.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:06
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_COMPANY.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:06
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    public String getHzyx() {
        return hzyx;
    }

    public void setHzyx(String hzyx) {
        this.hzyx = hzyx;
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