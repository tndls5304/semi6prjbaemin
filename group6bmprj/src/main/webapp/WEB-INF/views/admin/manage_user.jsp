<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

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

<script src="/baemin/resources/js/admin/manage_user.js"></script>
 <link rel="stylesheet" href="/baemin/resources/css/admin/manage_user.css">
</head>
<body>
    <aside>
        <nav>
            <ul>
                <li><a href=""><h1>관리자 페이지</h1></a></li>
                <li><a href="">스토어관리</a></li>
                <li><a href="/baemin/admin/manage">회원관리</a></li>
                <li><a href="">리뷰관리</a></li>
                 <button>로그아웃</button></a></li>
            </ul>
        </nav>
    </aside>

    <main>
        <div class="header">
            <h2>회원 관리</h2>
            <div>
                <select>
                    <option value="id">회원아이디</option>
                    <option value="name">이름</option>
                </select>
                <input type="text" placeholder="검색">
                <select>
                    <option value="all">전체회원</option>
                    <option value="all">계정삭제 회원</option>
                    <option value="all">탈퇴 회원</option>
                </select>
                <!-- <input type="date">
                <input type="date"> -->
                <button>조회</button>
            </div>
        </div>
        <table>
            <tr>
           
                <th>회원아이디</th>
                <th>회원 이름</th>
                <th>회원 닉네임</th>
                <th>계정상세조회</th>
                <th>계정삭제</th>
            </tr>
            <tr>
             
                <td>user01</td>
                <td>이땡땡</td>
                <td>zzang!</td>
                <td><button onclick="showDetails()">상세조회</button></td>
                <td><button class="delete-Button" id="deleteButton">삭제</button></td>
            </tr>
   
            
            <!-- 추가적인 행 필요 시 이곳에 삽입 -->
        </table>
    </main>

    <!-- 상세조회 -->

        <div id="detailBlock" class="detail-block">
            <div class="detail-content">
                <p>회원 아이디:</p>
                <p>회원주소:</p>
                <p>상세주소:</p>
                <p>연락처:</p>
                <p>배민페이잔액:</p>
                <p>연령대:</p>
                <p>성별:</p>
              
             
                
                
                
                
                
                
                
            </div>
            <div class="detail-delete">
                <button onclick="detailDelete()">닫기</button>  
            </div>

        

    
        </div>



    </div>

</body>
</html>