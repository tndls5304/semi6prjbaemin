package com.kh.baemin.store.vo;

public class FoodInforVo {
	
	private String delYn;
	private String foodImg;
	private String foodMenuCategoryNo;
	private String name;
	private String no;
	private String price;
	private String storeNo;
	private String viewYn;
	
	
	public FoodInforVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodInforVo(String delYn, String foodImg, String foodMenuCategoryNo, String name, String no, String price,
			String storeNo, String viewYn) {
		super();
		this.delYn = delYn;
		this.foodImg = foodImg;
		this.foodMenuCategoryNo = foodMenuCategoryNo;
		this.name = name;
		this.no = no;
		this.price = price;
		this.storeNo = storeNo;
		this.viewYn = viewYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public String getFoodMenuCategoryNo() {
		return foodMenuCategoryNo;
	}
	public void setFoodMenuCategoryNo(String foodMenuCategoryNo) {
		this.foodMenuCategoryNo = foodMenuCategoryNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public String getViewYn() {
		return viewYn;
	}
	public void setViewYn(String viewYn) {
		this.viewYn = viewYn;
	}
	@Override
	public String toString() {
		return "FoodInforVo [delYn=" + delYn + ", foodImg=" + foodImg + ", foodMenuCategoryNo=" + foodMenuCategoryNo
				+ ", name=" + name + ", no=" + no + ", price=" + price + ", storeNo=" + storeNo + ", viewYn=" + viewYn
				+ "]";
	}

	
}
