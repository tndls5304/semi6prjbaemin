<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.kh.baemin.member.vo.StoreOrderVo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/baemin/resources/css/member/orderList.css">
    <title>Order List</title>
</head>
<body>
   <div class="content">
        <header>
            <div class="top-bar">
                <div class="left-bar"><img class="back-img" src="/배민캡쳐/상단바_뒤로가기.jpg" alt="Back"></div>
                <div class="middle-bar"><img class="top-bar-name" src="/배민캡쳐/상단바_현재페이지이름_가게배달.jpg" alt="Current Page Name"></div>
                <img class="right-bar" src="/배민캡쳐/홈.png" alt="Home">
            </div>
            <div class="middle">주소입력칸&nbsp&nbsp&nbsp▽</div>
        </header>
        <main>
        
            <div class="deal">
                <div class="deal-header">
                  <!-- 가게사진 -->
                    <img src="/path_to_bbq_logo.jpg" class="storelogo" alt="가게로고" style="width: 50px; height: 50px;">
                    <!-- 가게이름링크 -->
                    <div class="store"><h2><a href="store_link_here">가게</a></h2>
                    </div>
                </div>
                <!-- 가게음식 ,가게음식 가격 -->
                <p class="deal-price">가게음식,가게음식 가격</p>
                <div class="deal-details">
                    <p class="date-text">주문 날짜 :</p>
                    <p class="status-text">배달 상태 :</p>
                </div>
                <!-- 주문상세 버튼 -->
                <form action="/baemin/member/reviewContentWriter" method="get">
                    <input type="hidden" name="memberNo" value="<%= request.getAttribute("memberNo") != null ? request.getAttribute("memberNo") : "" %>">
                    <button type="submit" class="link-button">주문상세</button>
                <!-- 같은 메뉴 담기 버튼 -->
                  <form action="/baemin/member/reviewContentWriter" method="get">
                    <input type="hidden" name="memberNo" value="<%= request.getAttribute("memberNo") != null ? request.getAttribute("memberNo") : "" %>">
                    <button type="submit" class="link-button">같은메뉴담기</button>
              <!-- 리뷰쓰기 버튼 -->
                <a href="/baemin/member/reviewStatusWriter" >
                    <input type="hidden" name="memberNo" value="<%= request.getAttribute("memberNo") != null ? request.getAttribute("memberNo") : "" %>">
                    <button type="submit" class="link-button">리뷰쓰기</button>
                       <h1>memberNo ::: ${memberNo}</h1>
           </a>
        
        </main>
    </div>
</body>
</html>
