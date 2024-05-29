<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.baemin.member.vo.StoreOrderVo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/baemin/resources/css/member/orderCart.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <title>유저 장바구니</title>
</head>
<body>
   <div class="content">
        <header>
          <div class="top-bar">
            <div class="left-bar"><img class="back-img" src="/배민캡쳐/상단바_뒤로가기.jpg" alt="Back"></div>
            <div class="middle-bar"><img class="top-bar-name" src="/배민캡쳐/상단바_현재페이지이름_가게배달.jpg" alt="Current Page Name"></div>
            <img class="right-bar" src="/배민캡쳐/홈.png" alt="Home">
          </div>
          <div class="middle">주소입력칸&nbsp;&nbsp;&nbsp;▽</div>
        </header>
        <main>
            <%
                List<StoreOrderVo> orderList = (List<StoreOrderVo>) request.getAttribute("orderList");
                if (orderList != null && !orderList.isEmpty()) {
                    for (StoreOrderVo order : orderList) {
            %>
                        <div class="restaurant">
                            <div class="restaurant-header">
                                <img class="menulogo" src="<%= order.getStoreImg() %>" alt="가게로고">
                                <div class="restaurant-info">
                                    <div class="storename"><a href="store_link_here"><%= order.getStoreName() %> ></a></div>
                                    <div class="restaurant-menuname"><span><%= order.getStoreFood() %></span></div>
                                    <div class="restaurant-rating">
                                        <span><%= order.getFoodPrice() %></span>
                                        <div class="totallmoney">정산가격: <%= order.getFoodPrice() %></div>
                                    </div>
                                </div>
                            </div>
                        </div>
            <%
                    }
                } else {
            %>
                <p>주문 내역이 없습니다.</p>
            <%
                }
            %>
            <div class="amountpay">결제금액을 확인해 주세요💲</div>
            <div class="restaurant">
                <div class="restaurant-header">
                    <div class="restaurant-info">
                        <div class="restaurant-menuname">
                            <span class="label">주문금액</span>
                            <span class="amount">25000원</span>
                        </div>
                        <div class="restaurant-rating">
                            <div class="deliverytip">배달 이벤트</div>
                            <div class="deliverymoney">무료</div>
                            <div class="totallmoney">
                                <span class="expectedmoney">결제 예정 금액:</span>
                                <span class="totallmoney">200000원</span>
                            </div>
                        </div>
                        <div class="payment">
                            <a href="/home" class="paymentbtn">주문하기</a>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <footer>
            <div onclick=""><img src="/배민캡쳐/하단바_돋보기.jpg"> <span>&nbsp;&nbsp;검색</span></div>
            <div onclick=""><img src="/배민캡쳐/하단바_장바구니.jpg"> <span>장바구니</span></div>
            <div onclick=""><img src="/배민캡쳐/하단바_찜.jpg"> <span>&nbsp;&nbsp;&nbsp;&nbsp;찜</span></div>
            <div onclick=""><img src="/배민캡쳐/하단바_주문내역.jpg"> <span>주문내역</span></div>
            <div onclick=""><img src="/배민캡쳐/하단바_마이배민.jpg"> <span>my배민</span></div>
        </footer>
    </div>
</body>
</html>
