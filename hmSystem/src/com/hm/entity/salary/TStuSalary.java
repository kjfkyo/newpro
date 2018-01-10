package com.hm.entity.salary;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TStuSalary extends BaseEntity<TStuSalary> {
    /**
     * HMDN.T_STU_SALARY.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String id;

    /**
     * HMDN.T_STU_SALARY.STU_ID (学员id)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String stuId;

    /**
     * HMDN.T_STU_SALARY.BANK_NM (银行名称)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String bankNm;

    /**
     * HMDN.T_STU_SALARY.BANK_NUM (银行卡号)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String bankNum;

    /**
     * HMDN.T_STU_SALARY.SAL_MONEY (金额)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private Integer salMoney;

    /**
     * HMDN.T_STU_SALARY.FF_DATE (发放日期)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String ffDate;

    /**
     * HMDN.T_STU_SALARY.STATE (状态)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String state;

    /**
     * HMDN.T_STU_SALARY.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private Date createTime;

    /**
     * HMDN.T_STU_SALARY.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String createUser;

    /**
     * HMDN.T_STU_SALARY.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private Date updateTime;

    /**
     * HMDN.T_STU_SALARY.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:02
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

    public String getBankNm() {
        return bankNm;
    }

    public void setBankNm(String bankNm) {
        this.bankNm = bankNm;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public Integer getSalMoney() {
        return salMoney;
    }

    public void setSalMoney(Integer salMoney) {
        this.salMoney = salMoney;
    }

    public String getFfDate() {
        return ffDate;
    }

    public void setFfDate(String ffDate) {
        this.ffDate = ffDate;
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
}