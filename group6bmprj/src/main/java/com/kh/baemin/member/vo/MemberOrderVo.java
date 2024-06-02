package com.kh.baemin.member.vo;

public class MemberOrderVo {


    // ¿¿¥‰
    private String storeNo;
    private String memberNo;
    private String phone;
    private String address;
    private String accountBalance;
    private Integer totalOrderPay;
    private String requestMsg;
    private String orderStatusNo;
    private String orderStatus;
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRequestMsg() {
        return requestMsg;
    }

    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getTotalOrderPay() {
        return totalOrderPay;
    }

    public void setTotalOrderPay(Integer totalOrderPay) {
        this.totalOrderPay = totalOrderPay;
    }

    public String getOrderStatusNo() {
        return orderStatusNo;
    }

    public void setOrderStatusNo(String orderStatusNo) {
        this.orderStatusNo = orderStatusNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
