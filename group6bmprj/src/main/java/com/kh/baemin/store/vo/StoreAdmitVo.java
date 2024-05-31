package com.kh.baemin.store.vo;

public class StoreAdmitVo {
	
	private String no;
	private String name;
	private String address;
	private String addressDetail;
	private String storeCategoryNo;
	private String localNameNo;
	private String storeDeliveryZoneNo;
	private String companyResistraionNumber;
	private String businessRegistrationVertificateImg;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getStoreCategoryNo() {
		return storeCategoryNo;
	}
	public void setStoreCategoryNo(String storeCategoryNo) {
		this.storeCategoryNo = storeCategoryNo;
	}
	public String getLocalNameNo() {
		return localNameNo;
	}
	public void setLocalNameNo(String localNameNo) {
		this.localNameNo = localNameNo;
	}
	public String getStoreDeliveryZoneNo() {
		return storeDeliveryZoneNo;
	}
	public void setStoreDeliveryZoneNo(String storeDeliveryZoneNo) {
		this.storeDeliveryZoneNo = storeDeliveryZoneNo;
	}
	public String getCompanyResistraionNumber() {
		return companyResistraionNumber;
	}
	public void setCompanyResistraionNumber(String companyResistraionNumber) {
		this.companyResistraionNumber = companyResistraionNumber;
	}
	public String getBusinessRegistrationVertificateImg() {
		return businessRegistrationVertificateImg;
	}
	public void setBusinessRegistrationVertificateImg(String businessRegistrationVertificateImg) {
		this.businessRegistrationVertificateImg = businessRegistrationVertificateImg;
	}
	@Override
	public String toString() {
		return "StoreAdmitVo [no=" + no + ", name=" + name + ", address=" + address + ", addressDetail=" + addressDetail
				+ ", storeCategoryNo=" + storeCategoryNo + ", localNameNo=" + localNameNo + ", storeDeliveryZoneNo="
				+ storeDeliveryZoneNo + ", companyResistraionNumber=" + companyResistraionNumber
				+ ", businessRegistrationVertificateImg=" + businessRegistrationVertificateImg + "]";
	}
	public StoreAdmitVo(String no, String name, String address, String addressDetail, String storeCategoryNo,
			String localNameNo, String storeDeliveryZoneNo, String companyResistraionNumber,
			String businessRegistrationVertificateImg) {
		super();
		this.no = no;
		this.name = name;
		this.address = address;
		this.addressDetail = addressDetail;
		this.storeCategoryNo = storeCategoryNo;
		this.localNameNo = localNameNo;
		this.storeDeliveryZoneNo = storeDeliveryZoneNo;
		this.companyResistraionNumber = companyResistraionNumber;
		this.businessRegistrationVertificateImg = businessRegistrationVertificateImg;
	}
	public StoreAdmitVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
