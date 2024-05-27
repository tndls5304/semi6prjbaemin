package com.kh.baemin.member.vo;

public class MemberVo {


	private String no;
	private String nick;
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String addressdDetail;
	private String phone;
	private String accountBalance;
	private String delYn;
	private String gender;
	private String profile;
	private String generation;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String no, String nick, String id, String pwd, String name, String address, String addressdDetail,
			String phone, String accountBalance, String delYn, String gender, String profile, String generation) {
		super();
		this.no = no;
		this.nick = nick;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.addressdDetail = addressdDetail;
		this.phone = phone;
		this.accountBalance = accountBalance;
		this.delYn = delYn;
		this.gender = gender;
		this.profile = profile;
		this.generation = generation;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", nick=" + nick + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address="
				+ address + ", addressdDetail=" + addressdDetail + ", phone=" + phone + ", accountBalance="
				+ accountBalance + ", delYn=" + delYn + ", gender=" + gender + ", profile=" + profile + ", generation="
				+ generation + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressdDetail() {
		return addressdDetail;
	}
	public void setAddressdDetail(String addressdDetail) {
		this.addressdDetail = addressdDetail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getGeneration() {
		return generation;
	}
	public void setGeneration(String generation) {
		this.generation = generation;
	}

}