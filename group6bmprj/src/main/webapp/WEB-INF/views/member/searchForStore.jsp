<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script defer src="/baemin/resources/js/member/searchForStore.js"></script>
<link rel="stylesheet"
	href="/baemin/resources/css/member/searchForStore.css">

<!-- 글씨체 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="content">
		<header>
			<div class="top-bar">
				<div class="left-bar">
					<img class="back-img" src="/baemin/resources/수인img/상단바_뒤로가기.jpg">
				</div>
				<div class="middle-bar"></div>
				<img class="right-bar" src="/baemin/resources/수인img/홈.png">
			</div>

			<div class="food-category">${storeCategoryName}</div>
			<div>
				<select name="" id="">
					<option>기본순</option>
					<option>많이찾는순</option>
					<option>찜 많은순</option>
				</select> <select name="" id="">
					<option value="">별점순</option>
					<option value="">⭐⭐⭐⭐ 4점이상</option>
					<option value="">⭐⭐⭐ 3점 이상</option>
				</select>
		</header>
		<main>
			<c:forEach items="${storeInforVoList}" var="storeInforVo">
				<a
					href="/baemin/member/view_one_store_detail?storeNo=${storeInforVo.no}">
					<div class="storeList">
						<c:forEach items="${storeInforVo.foodImgList}" var="foodImgVo">
							<img width="110px" height="110px"
								src="/baemin/resources/upload/${foodImgVo}" alt="">
						</c:forEach>
						<div class="storeName">${storeInforVo.name}</div>
						<div class="minimumMoney">최소주문:
							${storeInforVo.minimumOrderAmount}</div>
					</div>
				</a>
			</c:forEach>


		</main>
		<footer>
			<!-- 클릭하면 페이지 넘어갈 수 있게 온클릭에 url쓰시면 될듯 합니다  -->
			<div onclick="">
				<img src="/baemin/resources/수인img/하단바_돋보기.jpg"> <span>&nbsp&nbsp검색</span>
			</div>
			<div onclick="">
				<img src="/baemin/resources/수인img/하단바_장바구니.jpg"> <span>장바구니</span>
			</div>
			<div onclick="">
				<img src="/baemin/resources/수인img/하단바_찜.jpg"> <span>&nbsp&nbsp&nbsp&nbsp찜</span>
			</div>
			<div onclick="">
				<img src="/baemin/resources/수인img/하단바_주문내역.jpg"> <span>주문내역</span>
			</div>
			<div onclick="">
				<img src="/baemin/resources/수인img/하단바_마이배민.jpg"> <span>my배민</span>
			</div>


		</footer>

	</div>

	</div>

	<!-- 상단에   기본순,배달빠른순....등등 배달정렬 클릭할때 나오는 옵션창  -->
	<div class="option-look"></div>

	<!-- 상단에 별점 버튼 클릭할때 나오는 옵션창  -->
	<div class="option-star"></div>
</body>
</html>