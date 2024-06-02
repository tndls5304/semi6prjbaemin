package com.kh.baemin.member.vo;

public class DeliveryProblemVo {
	private String no;
	private String deliveryProblem;
	
	public DeliveryProblemVo(String no, String deliveryProblem) {
		super();
		this.no = no;
		this.deliveryProblem = deliveryProblem;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getDeliveryProblem() {
		return deliveryProblem;
	}
	public void setDeliveryProblem(String deliveryProblem) {
		this.deliveryProblem = deliveryProblem;
	}
	@Override
	public String toString() {
		return "DeliveryProblemVo [no=" + no + ", deliveryProblem=" + deliveryProblem + "]";
	}
	
	
}
