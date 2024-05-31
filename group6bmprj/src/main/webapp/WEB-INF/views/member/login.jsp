<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
       <script>
      <c:if test="${not empty resultMsg}">
             alert('${resultMsg}');
      </c:if>
   </script>
</head>
<body>
    
</body>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>유저 로그인</title>
       <!-- js -->
       <script defer src="/baemin/resources/js/member/login.js"></script>
       <!-- css -->
       <link rel="stylesheet" href="/baemin/resources/css/member/login.css">
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<style>


</style>


<body>
  <div class="content">
      <header>
          <div class="top-bar">
              <div class="left-bar"><img class="back-img" src="/배민캡쳐/상단바_뒤로가기.jpg"></div>
              <div class="middle-bar"><img class="top-bar-name" src="/배민캡쳐/상단바_현재페이지이름_가게배달.jpg"></div>
              <img class="right-bar" src="/배민캡쳐/홈.png">
          </div>
          <div class="middle">주소입력칸&nbsp&nbsp&nbsp▽</div>
      </header>
      <main>
          <div class="main">
              <div class="mainjoin"><h1>회원 로그인 📃</h1></div>
            <form id="loginForm" action="/baemin/member/login" method="post">
                  <div class="form-group">
                      <label for="id">아이디</label>
                      <input type="text" id="id" name="id" placeholder="아이디 입력">
                      <div class="error-message" id="id-error"></div>
                  </div>
                  <div class="form-group">
                      <label for="pwd">비밀번호</label>
                      <input type="password" id="password" name="pwd" placeholder="비밀번호 입력">
                      <div class="error-message" id="password-error"></div>
                  </div>
                  <div class="button-container">
                      <button type="button" onclick="validateLogin()">로그인하기</button>
                      
                  </div>
				     

              </form>
				<button class="button">
    <a href="/baemin/member/join" class="link">회원가입하기</a>
</button>
          </div>
      </main>
      <footer>
          <div onclick=""><img src="/배민캡쳐/하단바_돋보기.jpg"><span>&nbsp&nbsp검색</span></div>
          <div onclick=""><img src="/배민캡쳐/하단바_장바구니.jpg"><span>장바구니</span></div>
          <div onclick=""><img src="/배민캡쳐/하단바_찜.jpg"><span>&nbsp&nbsp&nbsp&nbsp찜</span></div>
          <div onclick=""><img src="/배민캡쳐/하단바_주문내역.jpg"><span>주문내역</span></div>
          <div onclick=""><img src="/배민캡쳐/하단바_마이배민.jpg"><span>my배민</span></div>
      </footer>
  </div>

  <script>
    
  </script>
</html>