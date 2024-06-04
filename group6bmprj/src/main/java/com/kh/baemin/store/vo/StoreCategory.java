package com.kh.baemin.store.vo;

public class StoreCategory {
    private String no;
    private String name;
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
	@Override
	public String toString() {
		return "StoreCategory [no=" + no + ", name=" + name + "]";
	}
	public StoreCategory(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public StoreCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
