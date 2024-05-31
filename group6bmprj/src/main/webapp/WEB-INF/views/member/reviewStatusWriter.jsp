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
    <script defer src="/baemin/resources/js/member/reviewStatus.js"></script>
    <link rel="stylesheet" href="/baemin/resources/css/member/reviewStatus.css">
</head>
<body>
    <div class="content">
        <h1><a href="/home" class="custom-link">x</a></h1>
        <div class="review"><h1>리뷰쓰기</h1></div>
        <div class="emoji-buttons"></div>
        <div class="question"><h2>어떤 점이 불편하셨나요?</h2></div>
        <div class="container mt-5">
            <h1>배달 문제 선택</h1>
            <form id="reviewForm" action="/baemin/member/reviewContentWriter" method="GET">
                <input type="hidden" name="deliveryProblem" id="deliveryProblem">
                <div class="options d-flex flex-wrap gap-2 mt-3">
                    <button type="button" value="1" class="option btn btn-danger">매우 늦게 도착😒</button>
                    <button type="button" value="2" class="option btn btn-danger">요청사항 불이행😒</button>
                    <button type="button" value="3" class="option btn btn-danger">포장 불량😒</button>
                    <button type="button" value="4" class="option btn btn-danger">음식 파손😒</button>
                    <button type="button" value="5" class="option btn btn-danger">배달 지연😒</button>
                    <button type="button" value="6" class="option btn btn-danger">다른 주소에 도착😒</button>
                    <button type="button" value="7" class="option btn btn-danger">해당 사항 없음 😊</button>
                    
            </form>
        </div>
        <div>
           <input type="hidden" name="orderNo" value="<%= request.getAttribute("orderNo") != null ? request.getAttribute("orderNo") : "" %>">
            <button id="nextButton" class="next-button">다음</button>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const form = document.getElementById('reviewForm');
            const buttons = document.querySelectorAll('.option');
            const nextButton = document.getElementById('nextButton');
            const deliveryProblemInput = document.getElementById('deliveryProblem');

            buttons.forEach(button => {
                button.addEventListener('click', () => {
                    deliveryProblemInput.value = button.value;
                });
            });

            nextButton.addEventListener('click', () => {
                form.submit();
            });
        });
    </script>
</body>
</html>
