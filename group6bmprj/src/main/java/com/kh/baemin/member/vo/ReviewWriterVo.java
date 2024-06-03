package com.kh.baemin.member.vo;

public class ReviewWriterVo {
	private String no;
	private String orderNo;
	private String rating;
	private String memberContent;
	private String CeoContent;
	private String reviewImg;
	private String memberImg;
	private String enrollDate;
	private String delYn;
	private String deliveryProblem; // 수정된 부분
	private String storeName;
	private String foodName;
	private String ceoImg;
	private String nick;
	private String id;
	public ReviewWriterVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewWriterVo(String no, String orderNo, String rating, String memberContent, String ceoContent,
			String reviewImg, String memberImg, String enrollDate, String delYn, String deliveryProblem,
			String storeName, String foodName, String ceoImg, String nick, String id) {
		super();
		this.no = no;
		this.orderNo = orderNo;
		this.rating = rating;
		this.memberContent = memberContent;
		CeoContent = ceoContent;
		this.reviewImg = reviewImg;
		this.memberImg = memberImg;
		this.enrollDate = enrollDate;
		this.delYn = delYn;
		this.deliveryProblem = deliveryProblem;
		this.storeName = storeName;
		this.foodName = foodName;
		this.ceoImg = ceoImg;
		this.nick = nick;
		this.id = id;
	}
	@Override
	public String toString() {
		return "ReviewWriterVo [no=" + no + ", orderNo=" + orderNo + ", rating=" + rating + ", memberContent="
				+ memberContent + ", CeoContent=" + CeoContent + ", reviewImg=" + reviewImg + ", memberImg=" + memberImg
				+ ", enrollDate=" + enrollDate + ", delYn=" + delYn + ", deliveryProblem=" + deliveryProblem
				+ ", storeName=" + storeName + ", foodName=" + foodName + ", ceoImg=" + ceoImg + ", nick=" + nick
				+ ", id=" + id + "]";
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
	public String getMemberContent() {
		return memberContent;
	}
	public void setMemberContent(String memberContent) {
		this.memberContent = memberContent;
	}
	public String getCeoContent() {
		return CeoContent;
	}
	public void setCeoContent(String ceoContent) {
		CeoContent = ceoContent;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	public String getMemberImg() {
		return memberImg;
	}
	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
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
		return deliveryProblem;
	}
	public void setDeliveryProblem(String deliveryProblem) {
		this.deliveryProblem = deliveryProblem;
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
	public String getCeoImg() {
		return ceoImg;
	}
	public void setCeoImg(String ceoImg) {
		this.ceoImg = ceoImg;
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
}