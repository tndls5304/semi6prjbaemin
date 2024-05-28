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



</head>
<style>

  body {
    
  font-family: "Jua", sans-serif;
  font-weight: 400;
  font-style: normal;
  background-color: rgb(236, 206, 227);
  display: flex;
  justify-content: center;
  align-items: center;
 
}

/*  배민 앱은 content에요 */
main{
  width: 515px;
  height: 100vh;
  background-color:white;
overflow-y: auto;
  display: grid;
  grid-template-rows: 1fr 10fr 1fr;
}
/* 고정 상단바 입니다 */
header{
  position: fixed;

  width: 515px;
  height: 90px;
  border: solid 1px;
display: grid;
grid-template-rows: 1.5fr 1fr;
}
/* 제일 위 고정 상단이 header이고 
윗 상단바의 첫번째 디브 */
header > div:nth-child(1){
background-color:white;
display: grid;
grid-template-columns: 0.5fr 7fr 1fr ;

padding-bottom: 0px;
}
/* 윗 상단바의 두번째 디브 */
header >div:nth-child(2){
  font-size: 15px;
  font-weight: 100;

  margin-top: 0px;

  padding-left: 30px;
  margin-bottom: 5px;
  padding-bottom: 0px;
background-color: rgb(249, 220, 220);
}



/* 맨 밑의  검색,장바구니,찜,주문내역, my배민 클릭할 수 있는 하단바 입니다 */
footer{
  position: fixed;
margin-bottom: 5px;
width: 513px;
height: 45px;
border: solid 1px;
bottom:1px;
display: grid;
grid-template-columns: repeat(5,1fr);
}



/* 홈이미지 버튼이에요 */
.right-bar,.back-img{
  margin-top: 10px;
  margin-left: 5px;
  width: 35px;
  height: 35px;
}

/* 상단바에서 뒤로가기버튼   */
.left-bar :nth-child(1){
width: 20px;
height: 30px;
}
/* 뒤로가기버튼 옆에 이 페이지의 제목을 담당 */
.top-bar-name{
  margin-top: 14px;
  margin-left: 0px;
  width: 60x;
  height: 30px;
}

/* 메인페이지----------------------------- */

main{
      
      
      margin-top: 90px;
    }

footer div{
  display: grid;
  grid-template-columns: 3fr lfr;
}
footer img{
  width: 33px;
  height: 27px;
  margin-left: 32px;
}

footer span{
  font-size: 12px;
  margin-left: 28px;
}

    .review-container {
        background: white;
        margin: 20px;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }
    .review-header {
        display: flex;
        align-items: center;
    }
    .profile-pic {
        width: 50px;
        height: 50px;
        border-radius: 50%;
        background: #ccc;
        margin-right: 10px;
    }
    .star-rating {
        color: #f5b01d;
        font-size: 18px;
    }
    .review-content {
        margin-top: 10px;
    }
    .review-images {
        margin-top: 10px;
    }
    .review-images img {
        width: 100%;
        height: auto;
        border-radius: 8px;
    }
    .comment-box {
        background: #f0f0f0;
        border-radius: 5px;
        padding: 10px;
        margin-top: 10px;
    }
.review-images {
    width: 50%; /* or any specific width */
    max-width: 100px; /* maximum width to ensure responsiveness */
    height: auto; /* maintains aspect ratio */
}
.my-food,.delivery-problem {
    border: 1px solid #8b8b8b; /* 테두리를 진하게 */
    padding: 2px 5px; /* 상하 패딩을 줄이고 좌우 패딩을 유지 */
    margin: 0; /* 외부 여백 제거 */
    font-size: 16px; /* 글꼴 크기 유지 */
    border-radius: 10px; /* 모서리 둥글게 */
    display: inline-block; /* 내용 너비에 맞게 표시 */
    text-align: center; /* 텍스트 왼쪽 정렬 */
}
/* 스크롤바 숨기기 (크롬, 사파리, 오페라) */
main::-webkit-scrollbar {
    display: none; /* 스크롤바가 보이지 않도록 설정 */
}

/* 스크롤바 숨기기 (파이어폭스) */
main {
    scrollbar-width: none; /* 파이어폭스에서 스크롤바를 숨김 */
}

/* IE와 엣지 브라우저 */
main {
    -ms-overflow-style: none; /* 스크롤바 숨기기 */
}
.review-images,.my-food,.profile-pic,.comment-box{
  margin: 7px;
}
.case{
  margin: 15px;
  background-color: rgb(221, 250, 248);
}
</style>


<body>
    <div class="content">
        <header>
          <div class="top-bar">
            
            <div class="left-bar"><img class="back-img" src="/주형 img/상단바_뒤로가기.jpg"></div>
           <div class="middle-bar"> <img class="top-bar-name" src="/배민캡쳐/상단바_현재페이지이름_가게배달.jpg"> </div>
            <img  class="right-bar" src="/배민캡쳐/홈.png">
          </div>
   
          <div class="middle">주소입력칸&nbsp&nbsp&nbsp▽</div>
          <!-- <div class="bottom"><button>standardard</button><button>star☆</button></div> -->
        </header>
        <main>
           
          <!-- 리뷰전체 -->
             <div class="case"> 
                  <!-- 손님 사진() -->
                    <img  div class="profile-pic" src ="/img/고양이.png">
                    <!-- 손님 닉네임 -->
                    <div class="member-name">손님 닉네임</div>
                   
                <!-- 별점  -->
                <div class="star-rating">★★★★★</div>
                <!-- 손님 리뷰 -->
                 <div class="member-comment">
                   너무 맛있어요너무 맛있어요너무 맛있어요너무 맛있어요너무 맛있어요너무 맛있어요너무 맛있어요너무 맛있어요
               </div>
               <!-- 리뷰 사진 -->
                <img  div class="review-images"src="/주형 img/햄버거사진.png">
    
                     <div></div>
                     <!--내가 시킨 음식 이름(jstl) -->
                     <div class="my-food" >
                     음식이름 
                     </div>
                     <div class="delivery-problem" >
                      배달문제선택
                      </div>
                      
                      
                     <!-- 사장 사진 -->
                     <div class="profile-pic">

                      <img  src ="/img/고양이.png"></div>
                         <!-- 사장 이름 표시 -->
                        <div class="ceoname">사장님</div>
                        <!-- 사장 대답 -->
                     <div class="comment-box">
                          안녕하세요! kh 입니다 
                         맛있게 즐겨주셔서 너무 감사합니다
                         ...
                     </div>

                     
                     
                            
        
           











             
                    
                  
        
    
            

        </main>
     

       
  
</body>
</html>