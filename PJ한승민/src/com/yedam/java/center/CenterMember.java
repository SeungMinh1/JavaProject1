package com.yedam.java.center;

import java.sql.Date;

public class CenterMember {
	
	//필드
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private Date birthdate;
	private String address;
	private int countTitle;
	
	//생성자
	
	//메서드

	
	public int getCountTitle() {
		return countTitle;
	}
	public void setCountTitle(int countTitle) {
		this.countTitle = countTitle;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "CenterMember [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", birthdate="
				+ birthdate + ", address=" + address + ", countTitle=" + countTitle + "]";
	}
	

}
