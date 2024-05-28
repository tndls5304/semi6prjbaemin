package com.kh.baemin.member.vo;

public class ReviewWriterVo {
	private String no;
	private String orderNo;
	private String rating;
	private String userContent;
	private String storeContent;
	private String reviewImg;
	private String enrollDate;
	private String delYn;
	private String deliveryProblem; // 수정된 부분
	private String storeName;
	private String foodName;

	public ReviewWriterVo() {
		super();
	}

	public ReviewWriterVo(String no, String orderNo, String rating, String userContent, String storeContent,
			String reviewImg, String enrollDate, String delYn, String deliveryProblem, String storeName,
			String foodName) {
		super();
		this.no = no;
		this.orderNo = orderNo;
		this.rating = rating;
		this.userContent = userContent;
		this.storeContent = storeContent;
		this.reviewImg = reviewImg;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
		this.deliveryProblem = deliveryProblem; // 수정된 부분
		this.storeName = storeName;
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "ReviewWriterVo [no=" + no + ", orderNo=" + orderNo + ", rating=" + rating + ", userContent="
				+ userContent + ", storeContent=" + storeContent + ", reviewImg=" + reviewImg + ", enrollDate="
				+ enrollDate + ", delYn=" + delYn + ", deliveryProblem=" + deliveryProblem + ", storeName=" + storeName
				+ ", foodName=" + foodName + "]";
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getUserContent() {
		return userContent;
	}

	public void setUserContent(String userContent) {
		this.userContent = userContent;
	}

	public String getStoreContent() {
		return storeContent;
	}

	public void setStoreContent(String storeContent) {
		this.storeContent = storeContent;
	}

	public String getReviewImg() {
		return reviewImg;
	}

	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getDeliveryProblem() {
		return deliveryProblem; // 수정된 부분
	}

	public void setDeliveryProblem(String deliveryProblem) {
		this.deliveryProblem = deliveryProblem; // 수정된 부분
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
}
