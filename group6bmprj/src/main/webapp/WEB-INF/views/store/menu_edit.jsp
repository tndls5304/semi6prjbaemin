<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/baemin/resources/css/store/menu_edit.css">
<script defer src="/baemin/resources/js/store/menu_edit.js"></script>

</head>
<body>
	<aside>
		<aside>
			<%@ include file="/WEB-INF/views/store/common/nav.jsp"%>
		</aside>
	</aside>
	<main>
		<div class="header">
			<h2>음식 메뉴편집🍴🍴</h2>
			<div>
				<form action="/baemin/store/category_delete" id="deleteForm"
					method="post">
					<input type="hidden" name="categoryNoText"
						id="submitCategoryNoText">
					<button type="button" onclick="showSelectionEdit()">선택수정</button>
					<td class="menu"><button type="submit" class="delete-Button"
							onclick="showSelectionDelete()">선택삭제</button></td>
				</form>
			</div>
		</div>
		<!-- -------------------------카테고리 추가 시 화면에 나타나는 테이블(❗❗❗나중에 JSTL로 하기) --------------------- -->
		<c:if test="${!empty categoryVolist}">
			<c:forEach var="categoryVo" items="${categoryVolist}">

				<table id="plusTable" class="plus-table">
					<tr>
						<th class="select">선택</th>
						<th colspan="3" name>카테고리</th>
						<th class="display">노출여부</th>
						<th class="edit"></th>
						<th class="edit"></th>
					</tr>
					<tr>
						<form action="/baemin/store/category_delete" method="post">
							<td><input type="checkbox" name="checkbox"
								id="checkCategoryNo-${categoryVo.no}" data-type="category"
								data-name="${categoryVo.name}"></td>
							<td class="category" colspan="3">${categoryVo.name}<input
								type="hidden" name="categoryNoText" value="${categoryVo.no}"></td>
							<td class="category">${categoryVo.viewYn}</td>
							<td class="category" id="categoryEdit">
								<button type="button"
									onclick="tableShowCategoryEdit(${categoryVo.no})">카테고리수정</button>
							</td>
							<td class="category"><button type="submit"
									class="delete-Button">삭제</button></td>
						</form>
					</tr>
					<tr>
						<th></th>
						<th>메뉴
							<button class="menuPlus-button"
								onclick="showMenuPlus(${categoryVo.no})">추가</button>
						</th>
						<th>메뉴가격</th>
						<th>사진</th>
						<th>노출여부</th>
						<th></th>
						<th></th>
					</tr>
					<!--- 추가적인 행 필요 시 이곳에 삽입 ----->

					<tbody id="foodmenu">
						<c:if test="${!empty foodMenuInforVolist}">
							<c:forEach var="foodMenuInforVo" items="${foodMenuInforVolist}">
								<c:if
									test="${foodMenuInforVo.foodMenuCategoryNo eq categoryVo.no}">
									<tr>
										<td></td>
										<td>${foodMenuInforVo.name}</td>
										<td>${foodMenuInforVo.price}</td>
										<td><img width="80px" height="80px"
											src="/baemin/resources/upload/${foodMenuInforVo.foodImg}"></td>
										<td>${foodMenuInforVo.delYn}</td>
										<td></td>
										<td></td>
									<tr>
								</c:if>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</c:forEach>
		</c:if>
		<button class="category-plus" onclick="showCategoryRegist()">카테고리추가</button>
	</main>
	<!------------------------------ hidden 모달창-------------------------------------------->

	<!--  체크박스 누르고 카테고리변경클릭시 뜨는 창   showCategoryEdit()        -->

	<form action="/baemin/store/category_edit" id="categoryEditForm"
		method="POST">
		<div id="categoryEditBlock" class="categoryEdit-block">
			<div class="detail-content">
				<p>카테고리 수정하기</p>
				<p>
					NAME(20글자이내) : <input type="text" name="name"
						id="categoryEditNaming" value="" maxlength='20' />
				</p>
				<div id="errorMsg-categoryName" class="errorMsgCategoryName"></div>
				<p>
					노출여부 : <select name="viewYn">
						<option value="Y">Y</option>
						<option value="N">N</option>
					</select>
				</p>
				<input name="categoryNoText" type="text" id="modalCategoryNo"
					value="">
			</div>
			<div class="detail-delete">
				<button type="submit" id="categoryEditDelete-click"
					onclick="categoryEditDelete()">등록</button>
			</div>
		</div>
	</form>

	<!--  카테고리등록 클릭시 뜨는 모달창   showCategoryRegist()        -->

	<div id="categoryRegistBlock" class="categoryRegist-block">
		<form action="/baemin/store/category_add" method="post">
			<div class="detail-content">
				<p>카테고리 추가</p>
				<p>
					NAME: <input name="name" type="text" value="" id="categoryPlusName"
						maxlength='20' required>
				</p>
				<h5>(20글자이내)</h5>
				노출여부 : <select name="viewYn">
					<option value="Y">Y</option>
					<option value="N">N</option>
				</select>
			</div>
			<div class="detail-delete">
				<button type="submit">등록</button>
			</div>
		</form>
	</div>

	<!-- 메뉴 수정 클릭시 뜨는 창 showMenuEdit()-->

	<div id="menuEditBlock" class="menuEdit-block">
		<form action="url" method="post" class="menu-form">
			<div>
				<p>메뉴 변경</p>
				<p>name(20글자이내):</p>
				<p>
					<input type="text" class="menuEdit-naming" id="menuEditnaming"
						value="" maxlength='20'>
				</p>
				<div id="errorMsg-menuName" class="errorMsgMenu"></div>
				<p>
					price : <input type="number" id="menuEditPrice" value="">
				</p>
				<div id="errorMsg-menuPrice" class="errorMsgMenu"></div>
				<p>
					사 진 : <img src="" id="menuEditImg">
				</p>
				<p>
					<button type="button">삭제</button>
					<button type="button">추가</button>
				</p>

				<p>
					노출여부 : <select name="" id="">
						<option value="Y">Y</option>
						<option value="N">N</option>
					</select>
				</p>
			</div>
			<div class="detail-delete">
				<button id="menuEditRegister-click" onclick="menuEditRegister()"
					type="submit">등록</button>
			</div>
		</form>
	</div>

	<!-- 메뉴 추가 클릭시 뜨는 창  showMenuPlus()-->
	<form action="/baemin/store/menu_add" method="post" id="menuPlusForm"
		enctype="multipart/form-data">
		<div id="menuPlusBlock" class="menuPlus-block">
			<div>
				<p>메뉴 추가</p>
				<p>
					name : <input name="name" type="text" id="menuPlusName" required
						maxlength='20'>
				</p>
				<p>
					price : <input name="price" type="number" id="menuPlusPrice"
						required>
				</p>
				<p>
					사 진 : <input type="file" name="foodImg" id="modalAddFoodImg">
				</p>
				<p>
					노출여부 : <select name="view_yn">
						<option value="Y">Yes</option>
						<option value="N">No(비공개)</option>
					</select>
				</p>
				<input id="modalCategyryNo" name="categyryNo" value=""
					placeholder="categyryNo">
			</div>
			<div class="detail-delete">
				<button onclick="menuPlusDelete()" type="submit">등록</button>
			</div>
		</div>
	</form>
</body>
</html>
