package com.kh.baemin.member.vo;

public class OneStoreReviewVo {
	private String img;
	private String rating;
	private String userContent;
	private String storeContent;
	private String enrollDate;
	private String nick;
	private String profile;
	private String  storeownerpic;
	public OneStoreReviewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OneStoreReviewVo(String img, String rating, String userContent, String storeContent, String enrollDate,
			String nick, String profile, String storeownerpic) {
		super();
		this.img = img;
		this.rating = rating;
		this.userContent = userContent;
		this.storeContent = storeContent;
		this.enrollDate = enrollDate;
		this.nick = nick;
		this.profile = profile;
		this.storeownerpic = storeownerpic;
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
	public String getUserContent() {
		return userContent;
	}
	public void setUserContent(String userContent) {
		this.userContent = userContent;
	}
	public String getStoreContent() {
		return storeContent;
	}
	public void setStoreContent(String storeContent) {
		this.storeContent = storeContent;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getStoreownerpic() {
		return storeownerpic;
	}
	public void setStoreownerpic(String storeownerpic) {
		this.storeownerpic = storeownerpic;
	}
	@Override
	public String toString() {
		return "OneStoreReviewVo [img=" + img + ", rating=" + rating + ", userContent=" + userContent
				+ ", storeContent=" + storeContent + ", enrollDate=" + enrollDate + ", nick=" + nick + ", profile="
				+ profile + ", storeownerpic=" + storeownerpic + "]";
	}

	
	
	
}
