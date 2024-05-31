<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: rgb(236, 206, 227);
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: "Jua", sans-serif;
            font-weight: 400;
            font-style: normal;
        }

        /* 배민 앱은 content에요 */
        .content {
            width: 515px;
            height: 100vh;
            background-color: rgb(255, 255, 255);
            display: grid;
            grid-template-rows: auto 1fr auto;
        }

        /* 고정 상단바 입니다 */
        header {
            position: fixed;
            width: 515px;
            height: 70px;
            display: grid;
            grid-template-rows: 1.5fr 1fr;
        }

        /* 제일 위 고정 상단이 header이고 
        윗 상단바의 첫번째 디브 */
        header > div:nth-child(1) {
            background-color: white;
            display: grid;
            grid-template-columns: 0.5fr 7fr 1fr;
            padding-bottom: 0px;
        }

        h2 {
            text-align: center;
        }

        .ranking-list {
            display: flex;
            justify-content: space-between;
        }

        .column {
            flex: 1;
            padding: 10px;
        }

        .column p {
            margin: 0;
            padding: 5px;
        }

        /* 홈 이미지 버튼이에요 */
        .right-bar, .back-img {
            margin-top: 25px; /* 위치 조정 */
            margin-left: 5px;
            width: 35px;
            height: 35px;
        }

        /* 상단바에서 뒤로가기 버튼 */
        .left-bar :nth-child(1) {
            width: 20px;
            height: 30px;
        }

        /* 뒤로가기 버튼 옆에 이 페이지의 제목을 담당 */
        .top-bar-name {
            margin-top: 14px;
            margin-left: 0px;
            width: 60px;
            height: 30px;
        }

        /* 메인페이지 ----------------------------- */
        main {
            margin-top: 90px;
            display: grid;
        }

        .main-div {
            border: 1px solid rgb(216, 211, 211);
            background-color: white;
            border-radius: 10px;
            margin-bottom: 10px;
            margin-left: 9px;
            margin-right: 9px;
            padding: 10px;
            position: relative;
        }

        .search-bar {
            margin-top: 21px;
            position: relative;
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 20px;
            background-color: #f1f1f1;
            outline: none;
            box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.1);
            font-size: 14px;
            padding-right: 70px; /* 오른쪽 여백을 버튼 공간으로 만듦 */
        }

        .search-button {
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 20px;
            cursor: pointer;
            font-size: 14px;
            outline: none;
        }

        .search-button:hover {
            background-color: #0056b3;
        }

        .margin-left {
            margin-left: 15px;
            position: relative;
        }

        #margin-left {
            margin-left: 15px;
        }

        .small-text {
            color: rgb(143, 136, 136);
        }

        .blue-font {
            color: rgb(44, 105, 218);
        }

        .payment-font {
            color: white;
            font-size: 15px;
            font-family: "Jua", sans-serif;
            font-weight: 100;
            font-style: normal;
            text-align: center;
        }

        footer img {
            width: 33px;
            height: 27px;
            margin-left: 32px;
        }

        footer span {
            font-size: 12px;
            margin-left: 28px;
        }

        .popular {
            position: absolute;
            top: 10px;
            right: 10px;
            width: 50px;
            height: auto;
        }

        .main-div2 {
            display: flex;
            justify-content: space-between;
        }

        .column {
            flex: 1;
            padding: 10px;
        }

        .column p {
            margin: 10px 0; /* 간격 조정 */
            padding: 5px;
        }
    </style>
</head>
<body>
    <div class="content">
        <header>
            <div class="top-bar">
                <div class="left-bar">
                    <img class="back-img" src="/baemin/resources/img/상단바_뒤로가기.jpg">
                </div>
                <div class="middle-bar"> 
                    <div class="search-bar-container">
                        <input id="SearchInput" type="text" name="" placeholder="검색어를 입력하세요" class="search-bar">
                        <button class="search-button" onclick="submitSearch()">검색</button>
                    </div>
                </div>
                <img class="right-bar" src="/baemin/resources/img/홈.png">
            </div>
        </header>
        <main>
            <div class="main-div">
                <strong class="margin-left">가장 많이 검색하고 있어요<br></strong>
                <small class="small-text" id="margin-left">05.15 기준</small>
                <img src="/baemin/resources/img/popular.jpg" class="popular">
                <div class="main-div2">
                    <div class="column">
                        <p>1. 요아정</p>
                        <p>2. 타코야끼</p>
                        <p>3. 피자나라치킨공주</p>
                        <p>4. 가마치통닭</p>
                        <p>5. 뭐시기</p>
                    </div>
                    <div class="column">
                        <p>6. 뭐시기</p>
                        <p>7. 뭐시기</p>
                        <p>8. 뭐시기</p>
                        <p>9. 뭐시기</p>
                        <p>10. 뭐시기</p>
                    </div>
                </div>
            </div>
        </main>
    </div>

    <script>
        // JavaScript to handle empty search input alert
        const searchInput = document.getElementById('SearchInput');
        const footerSpan = document.querySelector('footer span');

        function submitSearch() {
            const searchTerm = searchInput.value.trim();
            if (searchTerm === '') {
                alert('검색어를 입력해주세요!'); // 검색어가 비어있을 때 알림창 띄우기
                footerSpan.style.display = 'block';
            } else {
                alert(`Searching for: ${searchTerm}`);
                footerSpan.style.display = 'none';
            }
        }
    </script>
</body>
</html>
