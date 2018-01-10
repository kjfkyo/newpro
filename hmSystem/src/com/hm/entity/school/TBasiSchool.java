package com.hm.entity.school;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiSchool extends BaseEntity<TBasiSchool> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1907304714108605512L;

	/**
     * HMDN.T_BASI_SCHOOL.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String id;

    /**
     * HMDN.T_BASI_SCHOOL.NAME (学校名称)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String name;

    /**
     * HMDN.T_BASI_SCHOOL.LXR (联系人)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String lxr;

    /**
     * HMDN.T_BASI_SCHOOL.LXDH (联系电话)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String lxdh;

    /**
     * HMDN.T_BASI_SCHOOL.ZW (职务)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String zw;

    /**
     * HMDN.T_BASI_SCHOOL.CC (层次)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String cc;

    /**
     * HMDN.T_BASI_SCHOOL.LX (类型)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String lx;

    /**
     * HMDN.T_BASI_SCHOOL.GM (规模)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String gm;

    /**
     * HMDN.T_BASI_SCHOOL.ZYBZ (专业比重)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String zybz;

    /**
     * HMDN.T_BASI_SCHOOL.WHR (维护人)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String whr;

    /**
     * HMDN.T_BASI_SCHOOL.HZYX (合作意向)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String hzyx;

    /**
     * HMDN.T_BASI_SCHOOL.HZQK (合作情况)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String hzqk;

    /**
     * HMDN.T_BASI_SCHOOL.MARK (备注)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String mark;

    /**
     * HMDN.T_BASI_SCHOOL.ZT (状态)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String zt;

    /**
     * HMDN.T_BASI_SCHOOL.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_SCHOOL.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private String createUser;

    /**
     * HMDN.T_BASI_SCHOOL.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:00
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_SCHOOL.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:00
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

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getGm() {
        return gm;
    }

    public void setGm(String gm) {
        this.gm = gm;
    }

    public String getZybz() {
        return zybz;
    }

    public void setZybz(String zybz) {
        this.zybz = zybz;
    }

    public String getWhr() {
        return whr;
    }

    public void setWhr(String whr) {
        this.whr = whr;
    }

    public String getHzyx() {
        return hzyx;
    }

    public void setHzyx(String hzyx) {
        this.hzyx = hzyx;
    }

    public String getHzqk() {
        return hzqk;
    }

    public void setHzqk(String hzqk) {
        this.hzqk = hzqk;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
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