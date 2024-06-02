package com.kh.baemin.member.vo;

import java.util.List;

public class MemberViewStoreInforVo {
	private String no;
	private String name;
	private String address;
	private String addressDetail;
	private String introductionImg;
	private String introduce;
	private String mainImg;
	private String phone;
	private String minimumOrderAmount;
	private String viewedCnt;
	private String openTime;
	private String endTime;
	private String breakTimeStart;
	private String breakTimeEnd;
	
	//-수인 작업해야할거
	private List<ClosedayVo> closedayList;

	public MemberViewStoreInforVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberViewStoreInforVo(String no, String name, String address, String addressDetail, String introductionImg,
			String introduce, String mainImg, String phone, String minimumOrderAmount, String viewedCnt,
			String openTime, String endTime, String breakTimeStart, String breakTimeEnd,
			List<ClosedayVo> closedayList) {
		super();
		this.no = no;
		this.name = name;
		this.address = address;
		this.addressDetail = addressDetail;
		this.introductionImg = introductionImg;
		this.introduce = introduce;
		this.mainImg = mainImg;
		this.phone = phone;
		this.minimumOrderAmount = minimumOrderAmount;
		this.viewedCnt = viewedCnt;
		this.openTime = openTime;
		this.endTime = endTime;
		this.breakTimeStart = breakTimeStart;
		this.breakTimeEnd = breakTimeEnd;
		this.closedayList = closedayList;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getIntroductionImg() {
		return introductionImg;
	}

	public void setIntroductionImg(String introductionImg) {
		this.introductionImg = introductionImg;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMinimumOrderAmount() {
		return minimumOrderAmount;
	}

	public void setMinimumOrderAmount(String minimumOrderAmount) {
		this.minimumOrderAmount = minimumOrderAmount;
	}

	public String getViewedCnt() {
		return viewedCnt;
	}

	public void setViewedCnt(String viewedCnt) {
		this.viewedCnt = viewedCnt;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBreakTimeStart() {
		return breakTimeStart;
	}

	public void setBreakTimeStart(String breakTimeStart) {
		this.breakTimeStart = breakTimeStart;
	}

	public String getBreakTimeEnd() {
		return breakTimeEnd;
	}

	public void setBreakTimeEnd(String breakTimeEnd) {
		this.breakTimeEnd = breakTimeEnd;
	}

	public List<ClosedayVo> getClosedayList() {
		return closedayList;
	}

	public void setClosedayList(List<ClosedayVo> closedayList) {
		this.closedayList = closedayList;
	}

	@Override
	public String toString() {
		return "MemberViewStoreInforVo [no=" + no + ", name=" + name + ", address=" + address + ", addressDetail="
				+ addressDetail + ", introductionImg=" + introductionImg + ", introduce=" + introduce + ", mainImg="
				+ mainImg + ", phone=" + phone + ", minimumOrderAmount=" + minimumOrderAmount + ", viewedCnt="
				+ viewedCnt + ", openTime=" + openTime + ", endTime=" + endTime + ", breakTimeStart=" + breakTimeStart
				+ ", breakTimeEnd=" + breakTimeEnd + ", closedayList=" + closedayList + "]";
	}


	
	
	
	
}
