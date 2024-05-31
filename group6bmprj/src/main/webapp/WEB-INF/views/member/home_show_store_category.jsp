<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script defer src="/baemin/resources/js/member/home_show_store_category.js"></script>
<link rel="stylesheet" href="/baemin/resources/css/member/home_show_store_category.css">
</head>
<body>
  <div class="content">
        <header>
          <div class="top-bar">
            <div class="left-bar"><img class="back-img" src="/baemin/resources/수인img/상단바_뒤로가기.jpg"></div>
           <div class="middle-bar"> <img class="top-bar-name" src="/baemin/resources/수인img/상단바_현재페이지이름_가게배달.jpg"> </div>
            <img  class="right-bar" src="/baemin/resources/수인img/홈.png">
          </div>
   
          <div class="middle"><div class="address">주소 ${sessionScope.loginMemberVo.address}</div><button  onclick="changeAddress()">주소바꾸기</button></div>
          <!-- <div class="bottom"><button>standardard</button><button>star☆</button></div> -->
        </header>
        <main>
          <!-- 제일 위  광고자리 -->
<div class="ad-img" ><img src="/baemin/resources/수인img/홈광고.jpg"></div>
<!-- 음식카테고리 -->

<div class="food-category">
  <img src="/baemin/resources/수인img/카테고리-찜탕찌개.png">
  <img src="/baemin/resources/수인img/카테고리-족발보쌈.png">
<img src="/baemin/resources/수인img/카테고리-돈까스회일식.png">
<img src="/baemin/resources/수인img/카테고리-패스트푸드.png">
<img src="/baemin/resources/수인img/카테고리-피자.png">
<img src="/baemin/resources/수인img/카테고리-고기구이.png">
<img src="/baemin/resources/수인img/카테고리-야식.png">
<img src="/baemin/resources/수인img/카테고리-양식.png">
<img src="/baemin/resources/수인img/카테고리-1인분.png">
<img src="/baemin/resources/수인img/카테고리-치킨.png">
<img src="/baemin/resources/수인img/카테고리-중식.png">
<img src="/baemin/resources/수인img/카테고리-아시안.png">
<img src="/baemin/resources/수인img/카테고리-백반국수.png">
<img src="/baemin/resources/수인img/카테고리-도시락.png">
<img src="/baemin/resources/수인img/카테고리-분식.png">
<img src="/baemin/resources/수인img/카테고리-카페디저트.png">

<img src="/baemin/resources/수인img/카테고리-채식.png">

<img src="/baemin/resources/수인img/카테고리-반찬.png">
</div>

<div class="addressBlock" id="address-Block">주소:
<input class="inputAddress" type="text" placeholder="시/구/동">
<input  type="text" placeholder="상세주소">
<button>go!</button><button>x</button></div>

        </main>
        <footer>
          <!-- 클릭하면 페이지 넘어갈 수 있게 온클릭에 url쓰기~  -->
          <div onclick=""><img src="/baemin/resources/수인img/하단바_돋보기.jpg">  <span>&nbsp&nbsp검색</span> </div>
          <div onclick=""> <img src="/baemin/resources/수인img/하단바_장바구니.jpg">  <span>장바구니</span></div>
          <div onclick=""> <img src="/baemin/resources/수인img/하단바_찜.jpg"> <span>&nbsp&nbsp&nbsp&nbsp찜</span></div>
          <div onclick=""> <img src="/baemin/resources/수인img/하단바_주문내역.jpg"> <span>주문내역</span></div>
          <div onclick="">  <img src="/baemin/resources/수인img/하단바_마이배민.jpg"> <span>my배민</span></div>
         
  
        </footer>

        </div>

    </div>
  
</body>
</html>