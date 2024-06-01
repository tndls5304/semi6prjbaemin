package com.kh.baemin.member.vo;

public class SearchForStoreVo {
	
	
	private String storeCategoryNo;
	private String memberAddress;
	public SearchForStoreVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchForStoreVo(String storeCategoryNo, String memberAddress) {
		super();
		this.storeCategoryNo = storeCategoryNo;
		this.memberAddress = memberAddress;
	}
	public String getStoreCategoryNo() {
		return storeCategoryNo;
	}
	public void setStoreCategoryNo(String storeCategoryNo) {
		this.storeCategoryNo = storeCategoryNo;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	@Override
	public String toString() {
		return "SearchForStoreVo [storeCategoryNo=" + storeCategoryNo + ", memberAddress=" + memberAddress + "]";
	}
	
	
	
	
}
