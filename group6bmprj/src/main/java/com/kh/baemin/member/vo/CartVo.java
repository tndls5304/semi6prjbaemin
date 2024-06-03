package com.kh.baemin.member.vo;

public class CartVo {
private String MemberNo;
private String foodNo;
private String foodCount;
public CartVo() {
	super();
	// TODO Auto-generated constructor stub
}
public CartVo(String memberNo, String foodNo, String foodCount) {
	super();
	MemberNo = memberNo;
	this.foodNo = foodNo;
	this.foodCount = foodCount;
}
public String getMemberNo() {
	return MemberNo;
}
public void setMemberNo(String memberNo) {
	MemberNo = memberNo;
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
@Override
public String toString() {
	return "CartVo [MemberNo=" + MemberNo + ", foodNo=" + foodNo + ", foodCount=" + foodCount + "]";
}


}
