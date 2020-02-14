package com.cqipc.demo.bean;

public class Student {
	private int s_id;
	private String s_name;
	private int s_age;
	private Sclass cid;
	public Sclass getCid() {
		return cid;
	}
	public void setCid(Sclass cid) {
		this.cid = cid;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_age() {
		return s_age;
	}
	public void setS_age(int s_age) {
		this.s_age = s_age;
	}
	public Student() {
	}
	public Student(int s_id, String s_name, int s_age, Sclass cid) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_age = s_age;
		this.cid = cid;
	}
	public Student(String s_name, int s_age, Sclass cid) {
		this.s_name = s_name;
		this.s_age = s_age;
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_age="
				+ s_age + ", cid=" + cid + "]";
	}
}
