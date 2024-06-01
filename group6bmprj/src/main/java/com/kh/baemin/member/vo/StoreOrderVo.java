package com.kh.baemin.member.vo;

public class StoreOrderVo {

	private String no;
	private String orderNo;
	private String memberNo;
	private String name;
	private String address;
	private String addressDetail;
	private String introductionImg;
	private String introduce;
	private String mainImg;
	private String phone;
	private String minimumOrderAmount;
	private String viewedCnt;
	private String orderStatus;
	private String orderDay;
	private String foodImg;
	private String storeImg;
	private String storeName;
	private String storeFoodName;
	private int  storeFoodPrice;
	private String storeOrderDate;
	private String storeOrderStatus;
	private String deliveryStatus;
	private int storeFoodCount;
	public StoreOrderVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreOrderVo(String no, String orderNo, String memberNo, String name, String address, String addressDetail,
			String introductionImg, String introduce, String mainImg, String phone, String minimumOrderAmount,
			String viewedCnt, String orderStatus, String orderDay, String foodImg, String storeImg, String storeName,
			String storeFoodName, int storeFoodPrice, String storeOrderDate, String storeOrderStatus,
			String deliveryStatus, int storeFoodCount) {
		super();
		this.no = no;
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.name = name;
		this.address = address;
		this.addressDetail = addressDetail;
		this.introductionImg = introductionImg;
		this.introduce = introduce;
		this.mainImg = mainImg;
		this.phone = phone;
		this.minimumOrderAmount = minimumOrderAmount;
		this.viewedCnt = viewedCnt;
		this.orderStatus = orderStatus;
		this.orderDay = orderDay;
		this.foodImg = foodImg;
		this.storeImg = storeImg;
		this.storeName = storeName;
		this.storeFoodName = storeFoodName;
		this.storeFoodPrice = storeFoodPrice;
		this.storeOrderDate = storeOrderDate;
		this.storeOrderStatus = storeOrderStatus;
		this.deliveryStatus = deliveryStatus;
		this.storeFoodCount = storeFoodCount;
	}
	@Override
	public String toString() {
		return "StoreOrderVo [no=" + no + ", orderNo=" + orderNo + ", memberNo=" + memberNo + ", name=" + name
				+ ", address=" + address + ", addressDetail=" + addressDetail + ", introductionImg=" + introductionImg
				+ ", introduce=" + introduce + ", mainImg=" + mainImg + ", phone=" + phone + ", minimumOrderAmount="
				+ minimumOrderAmount + ", viewedCnt=" + viewedCnt + ", orderStatus=" + orderStatus + ", orderDay="
				+ orderDay + ", foodImg=" + foodImg + ", storeImg=" + storeImg + ", storeName=" + storeName
				+ ", storeFoodName=" + storeFoodName + ", storeFoodPrice=" + storeFoodPrice + ", storeOrderDate="
				+ storeOrderDate + ", storeOrderStatus=" + storeOrderStatus + ", deliveryStatus=" + deliveryStatus
				+ ", storeFoodCount=" + storeFoodCount + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
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
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(String orderDay) {
		this.orderDay = orderDay;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public String getStoreImg() {
		return storeImg;
	}
	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreFoodName() {
		return storeFoodName;
	}
	public void setStoreFoodName(String storeFoodName) {
		this.storeFoodName = storeFoodName;
	}
	public int getStoreFoodPrice() {
		return storeFoodPrice;
	}
	public void setStoreFoodPrice(int storeFoodPrice) {
		this.storeFoodPrice = storeFoodPrice;
	}
	public String getStoreOrderDate() {
		return storeOrderDate;
	}
	public void setStoreOrderDate(String storeOrderDate) {
		this.storeOrderDate = storeOrderDate;
	}
	public String getStoreOrderStatus() {
		return storeOrderStatus;
	}
	public void setStoreOrderStatus(String storeOrderStatus) {
		this.storeOrderStatus = storeOrderStatus;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public int getStoreFoodCount() {
		return storeFoodCount;
	}
	public void setStoreFoodCount(int storeFoodCount) {
		this.storeFoodCount = storeFoodCount;
	} 
}