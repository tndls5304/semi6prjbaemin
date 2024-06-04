<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <img class = "back-img" src="/baemin/resources/img/상단바_뒤로가기.jpg" onclick="history.back()">
            <div class="middle-bar"><img class="top-bar-name" src="/baemin/resources/수인img/장바구니.png" alt="Current Page Name"></div>
            <img class="right-bar" onclick="location.href='/baemin/member/home'" src="/baemin/resources/수인img/홈.png" alt="Home">
        </div>
        <div class="middle">주소입력칸&nbsp;&nbsp;&nbsp;▽</div>
    </header>
    <main>
    <form action="/baemin/member/order">
        <c:forEach items="${orderCartList}" var="vo">
            <div class="time">
                <!-- 가게사진 -->
                <img class="menulogo" src="${vo.storeImg}" alt="가게로고">
                <!-- 가게이름 -->
                <a href="리뷰관리_링크_URL" class="storename black-link">${vo.storeName} ></a>
                <!-- 이시간은 구현은 못하지만 없으면 심심해서 넣었습니다.. -->
                🧭 22~32분 후 도착
            </div>
            <div class="restaurant">
                <div class="restaurant-header">
                    <div class="restaurant-info">
                        <div class="menu-container">
                            <!-- 메뉴 로고 이미지 -->
                            ${vo.storeImg}
                        </div>
                        <!-- 가게 음식 이름 -->
                        <div class="restaurant-menuname">
                            <span>${vo.foodName}</span>
                            <span>${vo.foodPrice}원</span>
                        </div>
                        <!-- 가게 음식 가격 및 정산 가격 -->
                        <div class="restaurant-rating">
                            <!-- 가게음식 가격 -->
                            <!-- 정산가격 -->
                            <div class="totallmoney"></div>
                        </div>
                        <!-- 메뉴 추가 버튼 -->
                        <div class="menuplus"><a href="/home" class="menuplusbtn">감사합니다</a></div>
                    </div>
                </div>
            </div>
            <div class="amountpay">결제금액을 확인해 주세요💲</div>
            <div class="restaurant">
                <div class="restaurant-header">
                    <div class="restaurant-info">
                        <div class="menu-container"></div>
                        <!-- 주문금액 -->
                        <div class="restaurant-menuname">
                            <span class="label">주문금액</span>
                            <!-- 주문금액 달라서 jstl -->
                            <span class="amount">${vo.foodPrice}</span>
                        </div>
                        <!-- 배달팁 -->
                        <div class="restaurant-rating">
                            <div class="deliverytip">알뜰배달</div>
                            <!-- 배달팁 가격 가게마다 달라서 jstl -->
                            <div class="deliverymoney">무료</div>
                            <!-- 결제 예정 금액 -->
                            <div class="totallmoney">
                                <span class="expectedmoney">결제 예정 총합 금액:</span>
                                <!-- 결제 예정 금액 달라서 jstl -->
                                <span class="totallmoney">${vo.foodPrice}</span>
                            </div>
                        </div>
                        <!-- 주문하기 버튼 -->
                        <div class="payment">
                             <button type="submit" class="next-button">주문하기</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        </form>
    </main>
    <footer>
        <div onclick="location.href='/baemin/member/search'"><img src="/baemin/resources/수인img/하단바_돋보기.jpg"><span>&nbsp&nbsp검색</span></div>
            <div onclick="location.href='/baemin/member/orderCart'"><img src="/baemin/resources/수인img/하단바_장바구니.jpg"><span>장바구니</span></div>
            <div onclick="location.href='/baemin/member/'"><img src="/baemin/resources/수인img/하단바_찜.jpg"><span>&nbsp&nbsp&nbsp&nbsp찜</span></div>
            <div onclick="location.href='/baemin/member/orderList'"><img src="/baemin/resources/수인img/하단바_주문내역.jpg"><span>주문내역</span></div>
            <div onclick="location.href='/baemin/member/info'"><img src="/baemin/resources/수인img/하단바_마이배민.jpg"><span>my배민</span></div>
    </footer>
</div>
</body>
</html>
