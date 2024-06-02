<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>가게 허가 신청</title>
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: rgb(247, 237, 244);
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: "Jua", sans-serif;
            font-weight: 500;
            font-style: normal;
        }

        .content {
            width: 715px;
            height: 100vh;
            background-color: rgb(252, 246, 247);
            display: grid;
            grid-template-rows: 1fr 10fr 1fr;
        }

        aside {
            background-color: #f0f0f0;
            width: 200px;
            padding: 20px;
            position: fixed;
            left: 0;
            top: 0;
            bottom: 0;
        }

        aside nav ul {
            list-style: none;
            padding: 0;
        }

        aside nav ul li a {
            display: block;
            padding: 10px;
            color: black;
            text-decoration: none;
        }

        main {
            flex-grow: 1;
            padding: 20px;
            margin-left: 240px;
        }

        .file-upload {
            margin-top: 50px;
            padding: 20px;
            border: 1px solid #555151;
            border-radius: 5px;
        }

        .file-upload h2 {
            margin-bottom: 20px;
            margin-top: 0; 
        }

        .file-upload .form-group {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            margin-bottom: 15px;
        }

        .file-upload .form-group-row {
            display: flex;
            align-items: center;
            width: 100%;
        }

        .file-upload label {
            flex: 0 0 150px;
            margin-right: 10px;
        }

        .file-upload input[type="text"],
        .file-upload input[type="file"],
        .file-upload select {
            flex: 1;
            padding: 10px;
            border: 1px solid #aaaaaa;
            background-color: #dddddd;
            border-radius: 5px;
            font-size: 16px;
        }

        .file-upload .form-group p {
            color: red;
            font-size: 14px;
            margin-left : 165px;
            align-self: flex-start;
            display: none; /* 초기에는 숨김 */
        }

        .file-upload button {
            background-color: #19209b;
            border-radius: 10px;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            margin-left: auto; /* This line will move the button to the right */
        }

        .file-upload button:hover {
            background-color: #97b8c2;
        }
    </style>
</head>
<body>
    <aside>
        <nav>
            <ul>
                
                <li><a href=""><h1>사장님 페이지</h1></a></li>
                <li><a href="">스토어 허가 신청</a></li>
                <li><a href="">주문관리🕗</a></li>
                <li><a href="">스토어 관리</a></li>
                <li><a href="">회원관리</a></li>
                <li><a href="">음식메뉴편집</a></li>
                <li><a href="">매출관리</a></li>
                <li><a href="">리뷰관리</a></li>
                <li><a href="">
                 <button>로그아웃</button></a></li>

            </ul>
        </nav>
    </aside>

    <main>
        <div class="header">
            <h2>가게 허가 신청</h2>
        </div>
        <div class="file-upload">
            <form action="/baemin/store/admit"  method="post" enctype="multipart/form-data" id = "storeAdmit" onsubmit="return validateForm()">
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="name">가게 이름:</label>
                        <input type="text" id="name" name="name" required>
                    </div>
                    <p id="nameError">10글자 내로 작성해주세요.</p>
                </div>      
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="address">가게 주소:</label>
                        <input type="text" id="address" name="address" required>
                    </div>
                    <p id="addressError">25글자 내로 작성해주세요.</p>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="address">영업 시작 일시:</label>
                        <input type="text" id="openTime" name="openTime" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="address">영업 종료 일시:</label>
                        <input type="text" id="endTime" name="endTime" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="address-detail">가게 상세 주소:</label>
                        <input type="text" id="addressDetail" name="addressDetail" required>
                    </div>
                    <p id="addressDetailError">15글자 내로 작성해주세요.</p>
                </div>
                 <div class="form-group">
                    <div class="form-group-row">
                        <label for="delivery_zone">배달 지역 : </label>
                        <input type="text" id="deliveryZoneName" name="deliveryZoneName" required>
                       <!-- 조건 안맞으면 되돌리기 --> 
                    </div>
                    <p id="addressDetailError">15글자 내로 작성해주세요.</p>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="storeCategoryNo">가게 종목:</label>
                        <select id="storeCategoryNo" name="storeCategoryNo" required>
                        <%--storeCategories  for el expression --%>
                        <c:forEach items="${storeCategories}" var="storeCategory">
                            <option value="${storeCategory.no}">${storeCategory.name}</option>
                        </c:forEach>
                        </select>
                    </div>
                </div>
                <%--                <div class="form-group">--%>
                <%--                    <div class="form-group-row">--%>
                <%--                        <label for="companyResistraionNumber">사업자 등록 번호:</label>--%>
                <%--                        <input type="text" id="companyResistraionNumber" name="companyResistraionNumber" required>--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="businessRegistrationVertificateImg">사업자 등록증:</label>
                        <input type="file" id="businessRegistrationVertificateImg" name="businessRegistrationVertificateImg" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="introduceImage">가게 소개 사진:</label>
                        <input type="file" id="introduceImage" name="introduceImage" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <label for="mainImage">가게 메인 사진:</label>
                        <input type="file" id="mainImage" name="mainImage" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-group-row">
                        <button type="submit">제출</button>
                    </div>
                </div>
            </form>
        </div>
    </main>

    <script>
        function validateForm() {
            var name = document.getElementById("name").value;
            var address = document.getElementById("address").value;
            var addressDetail = document.getElementById("address-detail").value;

            var nameError = document.getElementById("nameError");
            var addressError = document.getElementById("addressError");
            var addressDetailError = document.getElementById("addressDetailError");

            var valid = true;

            if (name.length > 10) {
                nameError.style.display = "block";
                valid = false;
            } else {
                nameError.style.display = "none";
            }

            if (address.length > 25) {
                addressError.style.display = "block";
                valid = false;
            } else {
                addressError.style.display = "none";
            }

            if (addressDetail.length > 15) {
                addressDetailError.style.display = "block";
                valid = false;
            } else {
                addressDetailError.style.display = "none";
            }

            return valid;
        }
    </script>   
    <script>
      <c:if test="${not empty resultMsg}">
             alert('${resultMsg}');
      </c:if>
   </script>
</body>
</html>
