package com.kh.baemin.member.vo;

public class MemberCartVo {
	private String cartNo;
	private String userNo;
	private String foodNo;
	private String foodCount;
	private String foodName;
	private String foodPrice;
	private String foodImg;
	private String storeName;
	private String storeImg;
	public String getCartNo() {
		return cartNo;
	}
	public void setCartNo(String cartNo) {
		this.cartNo = cartNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getFoodNo() {
		return foodNo;
	}
	public void setFoodNo(String foodNo) {
		this.foodNo = foodNo;
	}
	public String getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(String foodCount) {
		this.foodCount = foodCount;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreImg() {
		return storeImg;
	}
	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}
	@Override
	public String toString() {
		return "MemberCartVo [cartNo=" + cartNo + ", userNo=" + userNo + ", foodNo=" + foodNo + ", foodCount="
				+ foodCount + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodImg=" + foodImg
				+ ", storeName=" + storeName + ", storeImg=" + storeImg + "]";
	}
	public MemberCartVo(String cartNo, String userNo, String foodNo, String foodCount, String foodName,
			String foodPrice, String foodImg, String storeName, String storeImg) {
		super();
		this.cartNo = cartNo;
		this.userNo = userNo;
		this.foodNo = foodNo;
		this.foodCount = foodCount;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImg = foodImg;
		this.storeName = storeName;
		this.storeImg = storeImg;
	}
	public MemberCartVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
