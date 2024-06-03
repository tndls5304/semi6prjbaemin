<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>리뷰 상태 작성 페이지</title>
    <link rel="stylesheet" href="/baemin/resources/css/member/reviewStatus.css">
    <script defer src="/baemin/resources/js/member/reviewStatus.js"> </script>
</head>
<body>


    <div class="content">
        <h1><a href="/baemin/member/orderList" class="custom-link">x</a></h1>
        <div class="review"><h1>리뷰쓰기</h1></div>
        <div class="emoji-buttons"></div>
        <div class="question"><h2>어떤 점이 불편하셨나요?</h2></div>
        <div class="container mt-5">
            <h1>배달 문제 선택</h1>
            <form id="reviewForm" action="/baemin/member/reviewContentWriter" method="GET">
              
                <div class="options d-flex flex-wrap gap-2 mt-3">
                <input class="hide" type="hidden" name="deliveryProblem" id="deliveryProblem"></input>
                <input class="hide" type="hidden" name="orderNo" value="<%=request.getParameter("orderNo") %>"></input>
             <c:forEach items="${selectList}" var="vo">
					
					 
					
					 <button type="button" onclick="btn(${vo.no})" class="option btn btn-danger">${vo.deliveryProblem}😒</button>
													
												
			</c:forEach>
   
        
        </div>
        <div>&nbsp;</div>
        <div>
            <button type="submit" id="nextButton"  class="next-button">다음</button>
        </div>
            </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
   
</body>

</html>
