<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- 글씨체 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">

<script defer src="/baemin/resources/js/admin/manage_user.js"></script>
<link rel="stylesheet"
	href="/baemin/resources/css/admin/manage_user.css">
</head>
<body>
	<aside>
		<nav>
			<ul>
				<li><a href=""><h1>관리자 페이지</h1></a></li>
				<li><a href="">스토어관리</a></li>
				<li><a href="/baemin/admin/manage">회원관리</a></li>
				<li><a href="">리뷰관리</a></li>
				<button>로그아웃</button>
				</a>
				</li>
			</ul>
		</nav>
	</aside>

	<main>
		<div class="header">
			<h2>회원 관리</h2>
			<div>

				<span>회원아이디</sapn> <input type="text" id="searchUserIdValue"
					placeholder="검색"> <select name="del_yn">
						<option value="N">전체회원</option>
						<option value="Y">탈퇴회원</option>
				</select> <!-- <input type="date">
                <input type="date"> -->
					<button onclick="adminSearchMember()">조회</button>
			</div>
		</div>
		<table>
			<thead>
				<tr>
					<th>회원아이디</th>
					<th>회원 이름</th>
					<th>회원 닉네임</th>
					<th>계정상세조회</th>
					<th>계정삭제</th>
				</tr>
			</thead>
			<tbody id="memberTbody">
	
			</tbody>

			<!-- 추가적인 행 필요 시 이곳에 삽입 -->
		</table>
	</main>

	<!-- 상세조회 -->

	<div id="detailBlock" class="detail-block">
		<div class="detail-content">
		

		</div>
	<div class="detail-delete">
		<button onclick="detailDelete()">닫기</button>
	</div>




	</div>



	</div>

</body>
</html>