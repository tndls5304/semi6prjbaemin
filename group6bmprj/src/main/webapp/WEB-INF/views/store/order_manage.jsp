<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문관리</title>
    <!-- js -->
    <script defer src="./order_manage.js"></script>
    <!-- css -->
    <link rel="stylesheet" href="./order_manage.css">
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
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
            <h2>주문 관리</h2>
            <div>
                <input type="date" id="order-date">
                <select name="generation" id="generation">
                    <option value="">주문상태선택하세요</option>
                    <option value="주문접수">주문접수</option>
                    <option value="요리중">요리중</option>
                    <option value="요리완료">요리완료</option>
                    <option value="배달중">배달중</option>
                    <option value="배달완료">배달완료</option>
                </select>
                <button onclick="filterOrders()">검색</button>
            </div>
        </div>
        <table>
            <tr>
                <th>주문번호</th>
                <th>주문상태</th>
                <th>주문접수버튼</th>
                <th>요리중버튼</th>
                <th>요리완료버튼</th>
                <th>배달중버튼</th>
                <th>배달완료버튼</th>
                <th>주문날짜</th>
                <th>주문내역</th>
                <th>총 결제 금액</th>
                <th>주문상세조회</th>
            </tr>
            <tr data-date="2024-05-18">
                <td>01</td>
                <td class="order-status">배달완료</td>
                <td><button onclick="changeOrderStatus(this, '주문접수')">주문접수</button></td>
                <td><button onclick="changeOrderStatus(this, '요리중')">요리중</button></td>
                <td><button onclick="changeOrderStatus(this, '요리완료')">요리완료</button></td>
                <td><button onclick="changeOrderStatus(this, '배달중')">배달중</button></td>
                <td><button onclick="changeOrderStatus(this, '배달완료')">배달완료</button></td>
                <td>2024-05-18</td>
                <td>햄버거 2개</td>
                <td>15000원</td>
                <td><button onclick="showDetails()">상세조회</button></td>
            </tr>
        </table>
    </main>

    <!-- 상세조회 -->
    <div id="detailBlock" class="detail-block">
        <div class="detail-content">
            <p>음식 어떤거 갯수 : 가격</p>
            <p>음식 어떤거 갯수 : 가격</p>
            <p>음식 어떤거 갯수 : 가격</p>
            <p>음식 어떤거 갯수 : 가격</p>
            <p>총 결제 금액 :총 가격</p>
        </div>
        <div class="detail-delete">
            <button onclick="detailDelete()">닫기</button>
        </div>
    </div>
   
</body>
</html>