package com.kh.baemin.member.vo;

import java.util.List;

public class StoreOfFoodCategoryVo {
	private String no;
	private String name;
	private List<String> foodInforVoList;
	public StoreOfFoodCategoryVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreOfFoodCategoryVo(String no, String name, List<String> foodInforVoList) {
		super();
		this.no = no;
		this.name = name;
		this.foodInforVoList = foodInforVoList;
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
	public List<String> getFoodInforVoList() {
		return foodInforVoList;
	}
	public void setFoodInforVoList(List<String> foodInforVoList) {
		this.foodInforVoList = foodInforVoList;
	}
	@Override
	public String toString() {
		return "StoreOfFoodCategoryVo [no=" + no + ", name=" + name + ", foodInforVoList=" + foodInforVoList + "]";
	}
	
	

	
	
}
