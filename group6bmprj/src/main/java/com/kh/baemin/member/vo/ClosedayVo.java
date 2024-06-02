package com.kh.baemin.member.vo;

public class ClosedayVo {
private String closeday;
private String closeComment;
public ClosedayVo() {
	super();
	// TODO Auto-generated constructor stub
}
public ClosedayVo(String closeday, String closeComment) {
	super();
	this.closeday = closeday;
	this.closeComment = closeComment;
}
public String getCloseday() {
	return closeday;
}
public void setCloseday(String closeday) {
	this.closeday = closeday;
}
public String getCloseComment() {
	return closeComment;
}
public void setCloseComment(String closeComment) {
	this.closeComment = closeComment;
}
@Override
public String toString() {
	return "ClosedayVo [closeday=" + closeday + ", closeComment=" + closeComment + "]";
}


}
