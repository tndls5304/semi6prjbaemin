package com.kh.baemin.member.vo;

public class OneStoreReviewVo {
	private String img;
	private String rating;
	private String user_content;
	private String store_content;
	private String enroll_date;
	
	
	public OneStoreReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OneStoreReviewVo(String img, String rating, String user_content, String store_content, String enroll_date) {
		super();
		this.img = img;
		this.rating = rating;
		this.user_content = user_content;
		this.store_content = store_content;
		this.enroll_date = enroll_date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getUser_content() {
		return user_content;
	}
	public void setUser_content(String user_content) {
		this.user_content = user_content;
	}
	public String getStore_content() {
		return store_content;
	}
	public void setStore_content(String store_content) {
		this.store_content = store_content;
	}
	public String getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(String enroll_date) {
		this.enroll_date = enroll_date;
	}
	@Override
	public String toString() {
		return "OneStoreReviewVo [img=" + img + ", rating=" + rating + ", user_content=" + user_content
				+ ", store_content=" + store_content + ", enroll_date=" + enroll_date + "]";
	}
	
	
	
}
