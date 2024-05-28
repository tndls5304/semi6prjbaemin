package com.kh.baemin.store.vo;

import javax.servlet.http.Part;

public class StoreOwnerVo {


	private String no;
	private String id;
	private String pwd;
	private String pwdCheck;
	private String name;
	private String phone;
	private String delYn;
	private String companyResitrationNumber;
	private String profile;
	
	public StoreOwnerVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreOwnerVo(String no, String id, String pwd, String pwdCheck, String name, String phone, String delYn,
			String companyResitrationNumber, String profile) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.pwdCheck = pwdCheck;
		this.name = name;
		this.phone = phone;
		this.delYn = delYn;
		this.companyResitrationNumber = companyResitrationNumber;
		this.profile = profile;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	public String getPwdCheck() {
		return pwdCheck;
	}
	public void setPwdCheck(String pwdCheck) {
		this.pwdCheck = pwdCheck;
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
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getCompanyResitrationNumber() {
		return companyResitrationNumber;
	}
	public void setCompanyResitrationNumber(String companyResitrationNumber) {
		this.companyResitrationNumber = companyResitrationNumber;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "StoreOwnerVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", pwdCheck=" + pwdCheck + ", name=" + name
				+ ", phone=" + phone + ", delYn=" + delYn + ", companyResitrationNumber=" + companyResitrationNumber
				+ ", profile=" + profile + "]";
	}
	

	
	
	
	
	
	
	
}
