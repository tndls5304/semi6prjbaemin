<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사장 회원가입</title>
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
 
   <link rel="stylesheet" href="/baemin/resources/css/store/owner_login.css">
   <script defer src="/baemin/resources/js/store/owner_login.js"> </script>
   
<title>Insert title here</title>
</head>
<body>

 <aside>
        <nav>
            <ul>
                
                <li><a href=""><h1>사장님 페이지</h1></a></li>
                <li><a href="">스토어 허가 신청</a></li>
                <li><a href="">주문관리🕗</a></li>
                <li><a href="">스토어 관리</a></li>
                <li><a href="/baemin/store/category_list">음식메뉴편집</a></li>
                <li><a href="">매출관리</a></li>
                <li><a href="">리뷰관리</a></li>
                <li> <button onclick="location.href='/baemin/store/store_owner_join'">회원가입</button></li>

            </ul>
        </nav>
    </aside>
    <main>
        <!-- 로그인 로고 -->
        <div class="mainjoin">
            <h1>사장 로그인 📃</h1>
        </div>
        <form  action="/baemin/store/store_owner_login" method="post">
            <div class="form-group">
                <!-- 아이디 -->
                <label for="id"><h3>아이디</h3> </label>
                <!-- 입력 하는곳 -->
                <input type="text" id="id" name="id" placeholder="아이디 입력">
      
            </div>
            <div class="form-group">
                <!-- 비번 -->
                <label for="password"><h3>비밀번호</h3></label>
                <!-- 비번 입력 -->
                <input type="password" id="password" name="pwd" placeholder="비밀번호 입력">
  
            </div>
            <div class="button-container">
                <button type="submit" >로그인하기</button>
           
         
            </div>
        </form>
    </main>

</body>
</html>