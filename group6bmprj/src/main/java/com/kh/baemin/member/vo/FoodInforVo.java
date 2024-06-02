package com.kh.baemin.member.vo;

public class FoodInforVo {
	private String no;
	private String name;
	private String price;
	private String foodImg;
	public FoodInforVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodInforVo(String no, String name, String price, String foodImg) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.foodImg = foodImg;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	@Override
	public String toString() {
		return "FoodInforVo [no=" + no + ", name=" + name + ", price=" + price + ", foodImg=" + foodImg + "]";
	}
	
	
}
