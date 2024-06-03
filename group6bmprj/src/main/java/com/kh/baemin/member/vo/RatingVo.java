package com.kh.baemin.member.vo;

public class RatingVo {
private String Rating;

@Override
public String toString() {
	return "RatingVo [Rating=" + Rating + "]";
}

public RatingVo(String rating) {
	super();
	Rating = rating;
}

public RatingVo() {
	super();
	// TODO Auto-generated constructor stub
}
}
