package com.hm.entity.account;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.hm.entity.common.BaseEntity;
/**
 * Created by limiao on 2017-07-08.
 */
public class User extends BaseEntity<User> {
	private static final long serialVersionUID = 1L;
	protected Long id;
    private String loginName;//登录名
    private String name;//真实姓名
    private String plainPassword;
    private String password;//密码
    private String salt;//加密盐
    private String roles;//角色
    private String department;//部门
    private String grade;//级别
    private String position;//职位
    private String email;//邮箱
    private String phone;//电话
    private String sex;//性别
    private String birthday;//生日
    private String card;//身份证号
    private String place;//籍贯
    private String education;//学历
    private String office;//办事处
    private String status;//状态
    private String delflag;//删除标记
    private String mark;//备注
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 不持久化到数据库，也不显示在Restful接口的属性.
    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
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

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	public User(Long id, String loginName, String name, String plainPassword,
			String password, String salt, String roles, String department,
			String grade, String position, String email, String phone,
			String sex, String birthday, String card, String place,
			String education, String office, String status, String delflag,
			String mark, Date createTime, String createUser, Date updateTime,
			String updateUser) {
		this.id = id;
		this.loginName = loginName;
		this.name = name;
		this.plainPassword = plainPassword;
		this.password = password;
		this.salt = salt;
		this.roles = roles;
		this.department = department;
		this.grade = grade;
		this.position = position;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.card = card;
		this.place = place;
		this.education = education;
		this.office = office;
		this.status = status;
		this.delflag = delflag;
		this.mark = mark;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
	}

	public User(String loginName, String name, String plainPassword,
			String password, String salt, String roles, String department,
			String grade, String position, String email, String phone,
			String sex, String birthday, String card, String place,
			String education, String office, String status, String delflag,
			String mark, Date createTime, String createUser, Date updateTime,
			String updateUser) {
		this.loginName = loginName;
		this.name = name;
		this.plainPassword = plainPassword;
		this.password = password;
		this.salt = salt;
		this.roles = roles;
		this.department = department;
		this.grade = grade;
		this.position = position;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.card = card;
		this.place = place;
		this.education = education;
		this.office = office;
		this.status = status;
		this.delflag = delflag;
		this.mark = mark;
		this.createTime = createTime;
		this.createUser = createUser;
		this.updateTime = updateTime;
		this.updateUser = updateUser;
	}
}