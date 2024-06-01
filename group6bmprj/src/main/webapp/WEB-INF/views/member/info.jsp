<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kh.baemin.member.vo.MemberVo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script defer src="/baemin/resources/js/member/info.js"></script>
    <link rel="stylesheet" href="/baemin/resources/css/member/info.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
    <title>Member Information</title>
</head>
<body>
    <div class="content">
        <header>
            <div class="top-bar">
                <div class="left-bar">
                    <img class="back-img" src="/배민캡쳐/상단바_뒤로가기.jpg">
                </div>
                <div class="middle-bar">
                    <img class="top-bar-name" src="/배민캡쳐/상단바_현재페이지이름_가게배달.jpg">
                </div>
                <img class="right-bar" src="/배민캡쳐/홈.png">
            </div>
            <div class="middle">주소입력칸&nbsp&nbsp&nbsp▽</div>
        </header>
        <main>
            <div class="center">
                <%
                    MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
                    if (loginMemberVo != null) {
                %>
                    <img class="picprofile" src="<%= loginMemberVo.getMemberImg() %>" alt="Profile Picture">
                    <div class="membername">
                        <span><%= loginMemberVo.getNick() %></span>
                    </div>
                <%
                    } else {
                %>
                    <img class="picprofile" src="/기본이미지/profilepic.png" alt="Profile Picture">
                    <div class="membername">
                        <span>로그인해주세요</span>
                    </div>
                <%
                    }
                %>
                <div class="icon-container">
                    <div class="icon">
                        <a href="/baemin/member/orderList" class="icon-link">
                            <h1><i class="fa fa-file-alt"></i></h1>
                        </a>
                        <h3>주문내역</h3>
                    </div>
                    <div class="icon">
                        <a href="나의_찜_링크_URL" class="icon-link">
                            <h1><i class="fa fa-heart"></i></h1>
                        </a>
                        <h3>❤ 나의 찜 ❤</h3>
                    </div>
                    <div class="icon">
                        <a href="리뷰관리_링크_URL" class="icon-link">
                            <h1><i class="fa fa-rocket"></i></h1>
                        </a>
                        <h3>리뷰관리</h3>
                    </div>
                </div>
            </div>
            <div class="baeminpay">
                <h1>페이💰</h1>
                <form id="chargeForm" method="POST" action="/baemin/member/info" class="mt-3">
                    <input type="number" id="amountInput" name="accountBalance" class="form-control" placeholder="충전할 금액을 입력하세요">
                    <button type="submit" class="btn btn-primary blue-button mt-5">충전</button>
                    <div id="balanceDisplay">현재 잔액: <span id="balanceAmount"><%= loginMemberVo.getAccountBalance() %></span>원</div>
                </form>
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
</body>
</html>
