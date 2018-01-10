package com.hm.entity;

import java.util.Date;

import com.hm.entity.common.BaseEntity;

public class TBasiCode extends BaseEntity<TBasiCode> {
    /**
     * HMDN.T_BASI_CODE.ID (主键)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String id;

    /**
     * HMDN.T_BASI_CODE.FLAG (代码标识)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String flag;

    /**
     * HMDN.T_BASI_CODE.KIND (代码种类)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String kind;

    /**
     * HMDN.T_BASI_CODE.NAME (代码名称)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String name;

    /**
     * HMDN.T_BASI_CODE.DATA_SJ (代码数据)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String dataSj;

    /**
     * HMDN.T_BASI_CODE.ORDERB (排序字段)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private Integer orderb;

    /**
     * HMDN.T_BASI_CODE.CODE_NR (代码内容)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String codeNr;

    /**
     * HMDN.T_BASI_CODE.DELFLAG (删除标识)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String delflag;

    /**
     * HMDN.T_BASI_CODE.GRADE (代码级别)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private Integer grade;

    /**
     * HMDN.T_BASI_CODE.RELKIND (是否有父节点)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String relkind;

    /**
     * HMDN.T_BASI_CODE.RELATION (关联关系)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String relation;

    /**
     * HMDN.T_BASI_CODE.CREATE_TIME (创建时间)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private Date createTime;

    /**
     * HMDN.T_BASI_CODE.CREATE_USER (创建人)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String createUser;

    /**
     * HMDN.T_BASI_CODE.UPDATE_TIME (最后修改时间)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private Date updateTime;

    /**
     * HMDN.T_BASI_CODE.UPDATE_USER (最后修改人)
     * @ibatorgenerated 2017-09-05 16:28:02
     */
    private String updateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataSj() {
        return dataSj;
    }

    public void setDataSj(String dataSj) {
        this.dataSj = dataSj;
    }

    public Integer getOrderb() {
        return orderb;
    }

    public void setOrderb(Integer orderb) {
        this.orderb = orderb;
    }

    public String getCodeNr() {
        return codeNr;
    }

    public void setCodeNr(String codeNr) {
        this.codeNr = codeNr;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String delflag) {
        this.delflag = delflag;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getRelkind() {
        return relkind;
    }

    public void setRelkind(String relkind) {
        this.relkind = relkind;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
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
		return "TBasiCode [id=" + id + ", flag=" + flag + ", kind=" + kind
				+ ", name=" + name + ", dataSj=" + dataSj + ", orderb="
				+ orderb + ", codeNr=" + codeNr + ", delflag=" + delflag
				+ ", grade=" + grade + ", relkind=" + relkind + ", relation="
				+ relation + ", createTime=" + createTime + ", createUser="
				+ createUser + ", updateTime=" + updateTime + ", updateUser="
				+ updateUser + "]";
	}
    
}