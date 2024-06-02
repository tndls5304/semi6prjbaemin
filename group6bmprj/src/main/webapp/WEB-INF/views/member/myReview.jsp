<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="stylesheet" href="/baemin/resources/css/member/myeview.css">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>



<body>
    <div class="content">
        <header>
          <div class="top-bar">
            <div class="left-bar"><img class = "back-img" src="/baemin/resources/img/상단바_뒤로가기.jpg"></div>
            <div class="middle-bar"> <h2>리뷰관리</h2> </div>

            <img  class="right-bar" src="/baemin/resources/img/홈.png">
          </div>
   
          <!-- <div class="bottom"><button>standardard</button><button>star☆</button></div> -->
        </header>
        <main>
    <div>
        <h3 class = "main-top-div">내가 쓴 총 리뷰 ${reviewCount}개</h3>
    </div>


    <%--reviewList--%>
    <c:forEach var="review" items="${reviewList}">
        <div class="main-div">
            <b class="margin-left">${review.storeName} <img style="width: 20px" src="/baemin/resources${review.introductionImg}" ></h4><br></b>

            <img src="/baemin/resources/img/star.JPG" class="margin-left"><small class="small-text">
            ${review.rating}

            </small><br>

            <small class="margin-left">${review.userContent}</small><br>

            <img style="width: 200px" src="/baemin/resources${review.reviewImg}" > <br>
            <img src="/baemin/resources/img/menu.JPG" class="margin-left">
            ${review.foodNames}

            <br>
            사장님 : ${review.storeContent}

        </div>
    </c:forEach>


  
</body>
</html>