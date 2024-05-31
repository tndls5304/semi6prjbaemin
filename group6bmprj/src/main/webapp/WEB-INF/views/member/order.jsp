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
    <link rel="stylesheet" href="/baemin/resources/css/member/order.css">
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>



<body>
    <div class="content">
        <header>
          <div class="top-bar">
            <div class="left-bar"><img class = "back-img" src="/baemin/resources/img/상단바_뒤로가기.jpg"></div>
            <div class="middle-bar"> <h2>주문하기</h2> </div>

            <img  class="right-bar" src="/baemin/resources/img/홈.png">
          </div>
   
          <!-- <div class="bottom"><button>standardard</button><button>star☆</button></div> -->
        </header>
        <main>
<div class="main-div">
<h4 class = "margin-left">배달주소</h4>
<!-- 유저 주소 받아오기 -->
<p><img class = "location-img" src = "/baemin/resources/img/위치.PNG"> 강남구 도산대로 222 <small class = "small-text">호산빌딩</small></p> <br>
</div>
<!-- 유저 연락처 받아오기 -->
<div class="main-div"><h4 class = "margin-left">내 연락처 : 000-0000-0000</h4></div>
<div class="main-div"><p><strong class = "margin-left">가게 사장님께</strong><small>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</small><small class = "blue-font" onclick ="showRequest()">요청 입력&nbsp></small></p>
<p class = "margin-left">입력시 내용 여기 출력</p>
</div>
<div class="main-div"><p><strong class = "margin-left">배민페이</strong></p>
<p class = "margin-left">배민페이 잔액 : 00000원</p></div>
<div class="main-div"><p><strong class = "margin-left">결제금액</strong></p>
<p class = "margin-left">결제금액 : 48300원</p></div>
<div><p>&nbsp&nbsp예상 도착 시간 : 30분 후</p></div>

        </main>
        <footer>
          <!-- 클릭하면 페이지 넘어갈 수 있게 온클릭에 url쓰기~  -->
          <div onclick="paymentRequest()" class = "paymentRequest"> <p class = "payment-font">48,300원 결제하기</p> </div>

         
  
        </footer>

        </div>

    </div>

    <div id="requestBlock" class="request-block">
      <form action=""></form>
      <div class="request-content">
        
          <p>사장님께 : <input type = "text" class = "request_msg" id = "request_msg" name = "request_msg"></p>
        
      </div>
      <div class="request-delete">
        <button onclick="requestSubmit()" class = "request-button">입력 완료</button>  
      </form>
    </div>
  
</body>
<script>
  function showRequest() {
      var requestBlock = document.getElementById("requestBlock");
      if (requestBlock.style.display === "none" || requestBlock.style.display === "") {
          requestBlock.style.display = "block";
      } else {
          requestBlock.style.display = "none";
      }
  }

  function requestSubmit(){
    requestBlock.style.display="none";
}

// 작동하는지 안하는지 정확히모름 일단 만들어놓음
function paymentRequest() {
            var paymentAmount = 48300;

            fetch('process_payment.php', { 
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    amount: paymentAmount
                })
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert('결제가 성공적으로 처리되었습니다.');
                } else {
                    alert('결제 처리에 실패했습니다. 다시 시도해주세요.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('결제 처리 중 오류가 발생했습니다. 다시 시도해주세요.');
            });
        }
  
  
      </script>
</html>