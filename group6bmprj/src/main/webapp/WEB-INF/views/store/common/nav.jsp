<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="en">
    <!-- 로그인 결과 메시지 알림 -->
    <%
        String resultMsg = (String) session.getAttribute("resultMsg");
        if (resultMsg != null) {
    %>
        <script type="text/javascript">
            alert("<%= resultMsg %>");
        </script>
    <%
            session.removeAttribute("resultMsg"); // 메시지를 한 번 표시한 후 제거
        }
    %>

      <nav>
         <ul>
            <li><a href=""><h1>사장님 페이지</h1></a></li>
            <li><a href="">스토어 허가 신청</a></li>
            <li><a href="">주문관리🕗</a></li>
            <li><a href="">스토어 관리</a></li>
            <li><a href="/baemin/store/category_list">음식메뉴편집</a></li>
            <li><a href="">매출관리</a></li>
            <li><a href="">리뷰관리</a></li>
            <li>
            	<button onclick="location.href='/baemin/StoreOwner/logout'">로그아웃</button>        
            </li>
         </ul>
      </nav>