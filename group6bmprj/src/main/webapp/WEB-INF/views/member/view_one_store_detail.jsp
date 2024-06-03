<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script defer src="/baemin/resources/js/member/view_one_store_detail.js"></script>
<link rel="stylesheet"
	href="/baemin/resources/css/member/view_one_store_detail.css">

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
			</div>
			<img class="right-bar" src="/baemin/resources/수인img/홈.png">

		</header>
		<main>

			<div class="top-viewStore">

				<!-- 가게이름 -->
				<div class="store-name">${memberViewStoreInforVo.name}</div>
				<!-- 평균별점 사진, 글-->
				<div class="star">
					<span>⭐⭐⭐</span><span>3.5???</span>
				</div>
				<!-- 리뷰 총 갯수 -->
				<div class="review-count">총 리뷰갯수: ???</div>
				<!-- 찜하기 -->
				<div class="heart">🤍💛💗</div>
				<!-- 배달정보 -->
				<div class="delivery-information">
					<div>
						<span>가게 주소:</span> <span>${memberViewStoreInforVo.address}
							${memberViewStoreInforVo.addressDetail}</span>
					</div>
					<div>
						<span>최소주문금액:</span> <span>${memberViewStoreInforVo.minimumOrderAmount}</span><span>원</span>
					</div>
					<div>
						<sapn>배달시간:30분</span>
					</div>
					<div>
						<span>배달팁: 무료</span>
					</div>
				</div>
				<!-- 메뉴/가게정보/리뷰     3가지 탭-->
				<div class="select-tab">
					<div class="tab1" id="menuTab">
						<span>메뉴 </span>
					</div>
					<div class="tab2" id="storeInfoTab">
						<span>가게정보</span>
					</div>
					<div class="tab3" id="reviewTab">
						<span>리뷰</span>
					</div>
				</div>
			</div>

			<div class="under-viewFood">

				<!-- 메뉴 탭 클릭했을때 보이는 공간  menutab-content 에는 여러개의 category List 묶음들이 올것이다.-->

				<div id="menuTab-content">
					<c:forEach items="${storeOfFoodCategoryVoList}"
						var="storeOfFoodCategoryVo">
						<div class="categoryList">
							<!--카테고리리스트 안은 2개로 나눔 categoryName,category-foodContentList로 나뉜다 한개의 카테고르이름안에 여러개의 내용들이 오기때문 -->
							<div class="categoryName">카테고리자리${storeOfFoodCategoryVo.name}</div>


							<c:forEach items="${storeOfFoodCategoryVo.foodInforVoList}"
								var="FoodInforVo">
								<div class="category-foodContentList">
									<!--category-foodContentList 안은 왼쪽 중간 오른쪽 디브로 나눔. 왼쪽은 food-info/ 오른쪽은 음식이미지-->
									<div class="food-info">
										<div class="foodName">${FoodInforVo.name}</div>
										<div class="foodPrice">
											<span>메뉴가격 ${FoodInforVo.price}</span> <span></span>원
										</div>
									</div>

									<div class="count">
										 COUNT<input type="number" class="countInput" id="countInputPlace">
										<button onclick="addCart(${FoodInforVo.no})">담기</button>
									</div>


									<img width="90" height="90"
										src="/baemin/resources/upload/${FoodInforVo.foodImg}">
								</div>
							</c:forEach>
							<!-- 같은 카테로리 안에서 반복  -->

						</div>
						<!-- 또 다른 카테고리  -->

					</c:forEach>
				</div>





				<div id="storeInfoTab-content" style="display: none;">

					<div class="operationInfo">


						<div class="operationInfo-left">
							<p>상호명:</p>
							<p>운영시간:</p>
							<p>브레이크타임: ~</p>
							<p>휴무일:</p>
							<p>전화번호:</p>
							<p>배달지역:</p>

						</div>
						<div class="operationInfo-right">
							<p>${memberViewStoreInforVo.name}</p>
							<p>${memberViewStoreInforVo.openTime}~${memberViewStoreInforVo.endTime}</p>
							<p>${memberViewStoreInforVo.breakTimeStart}~${memberViewStoreInforVo.breakTimeEnd}</p>
							<c:forEach items="${memberViewStoreInforVo.closedayList}"
								var="ClosedayVo">
        ${ClosedayVo.closeday} :${ClosedayVo.closeComment}
        </c:forEach>
							<p>${memberViewStoreInforVo.phone}</p>
							<p>${memberViewStoreInforVo.address}</p>


						</div>




					</div>

					<div class="mainPhoto">
						<!-- 크기 변경 고정하길!!! -->

							<img width="250px" height="250px" src="/baemin/resources/upload/${MemberViewStoreInforVo.introductionImg}">
					</div>
					${memberViewStoreInforVo.introduce}

					<div class="store-introduce"></div>
					<div class="business-infor">
						<div class="businessInfor-left">
					<!-- 	<p>사업자 주소:</p>
							<p>사업자 등록번호:</p>  -->	

						</div>

						<div class="businessInfor-right">
							<p>??</p>
							<p>??</p>


						</div>



					</div>


				</div>



				<div id="reviewTab-content" style="display: none;">
					<!-- 여기는 리뷰 -->
<c:forEach items="oneStoreReviewVoList" var="OneStoreReviewVo">
					<!-- 손님+ 사장 리뷰 디브 -->
					<div class="case">
						<!-- 손님 사진() -->
						<img div class="profile-pic" src="" alt="">
						<!-- 손님 닉네임 -->
						<div class="member-name">손님 ${OneStoreReviewVo.nick}</div>

						<!-- 별점  -->
						<div class="star-rating">${OneStoreReviewVo.rating}점</div>
						<!-- 손님 리뷰 -->
						<div class="member-comment">리뷰내용 ${OneStoreReviewVo.userContent}</div>
						<!-- 리뷰 사진 -->
					
						<img div class="review-images" src="/baemin/resources/upload/${OneStoreReviewVo.img}">

						<div></div>
						<!--내가 시킨 음식 이름(jstl) -->
						<div class="my-food">음식이름</div>
						<div class="delivery-problem">배달문제선택</div>


					<c:if test="${!empty OneStoreReviewVo.storeContent}">
						<!-- 사장 사진 -->
						<div class="profile-pic">

							<img src="/baemin/resources/upload/${OneStoreReviewVo.storeownerpic}" alt="">
						</div>
						<!-- 사장 이름 표시 -->
						<div class="ceoname">사장님</div>
						<!-- 사장 대답 -->
						<div class="comment-box">${OneStoreReviewVo.storeContent} 
							...</div>
					</c:if>
			</div>
</c:forEach>


					<!--  리뷰테스트용 반복 하는거 -->
				

					<!-- 리뷰테스트 끝 -->
		</main>
		<footer>
			<!-- 클릭하면 페이지 넘어갈 수 있게 온클릭에 url쓰기~  -->
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

</body>
</html>