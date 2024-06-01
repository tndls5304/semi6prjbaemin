<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kh.baemin.member.vo.StoreOrderVo"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/baemin/resources/css/member/orderList.css">
<title>Order List</title>
</head>
<body>
	<div class="content">
		<header>
			<div class="top-bar">
				 <div class="left-bar" onclick="goToPage('/baemin/member/info')">
        <img class="back-img" src="/baemin/resources/수인img/상단바_뒤로가기.jpg" alt="Back">
    </div>
				<div class="middle-bar">
					<img class="top-bar-name" src="/baemin/resources/수인img/하단바_주문내역.jpg"
						alt="Current Page Name">
				</div>
				
				
				 <img class="right-bar" src="/baemin/resources/수인img/홈.png" alt="Home" onclick="goToPage('/baemin/member/home')">
				
				
			</div>
			<div class="middle">주소입력칸&nbsp&nbsp&nbsp▽</div>
		</header>
		<main>

			<div class="deal">
				<div class="deal-header">
					<c:forEach items="${orderList}" var="vo">
					<!-- 가게사진 -->
					<div class="storelogo" 
						>
					     <img width="100px" height="100px" alt="${vo.storeImg}" src="/baemin/resources/upload/${vo.storeImg}">
					<!-- 가게이름링크 -->
					<div class="store">
						<h2>
							<a href="store_link_here">${vo.storeName}</a>
						</h2>
					</div>
				</div>
			
				<p class="deal-price"> ${vo.storeFoodName} (${vo.storeFoodCount}),${vo.storeFoodPrice}</p>
				<div class="deal-details">
					<p class="date-text">${vo.storeOrderDate}:</p>				
					<p class="status-text">${vo.storeOrderStatus}</p>
				<a href="/baemin/member/reviewStatusWriter">
				</div>
					<button type="submit" class="link-button">주문상세</button>
					</a>
				<!-- 같은 메뉴 담기 버튼 -->
				<a href="/baemin/member/reviewStatusWriter">
					<button type="submit" class="link-button">같은메뉴담기</button>
				</a>
				<!-- 리뷰쓰기 버튼 -->
				<a href="/baemin/member/reviewStatusWriter"> 
					<button type="submit" class="link-button">리뷰쓰기</button>
				</a>
				<input
					type="hidden" name="no"
					value="${sessionScope.LoginMemberVo.no}">
	</div>
				
				</c:forEach>
				<!-- 가게음식 ,가게음식 가격 -->
				
				

	
	
	
	 <script>
        function goToPage(url) {
            window.location.href = url; // 클릭 시 URL로 이동
        }
    </script>
		</main>
</body>
</html>
