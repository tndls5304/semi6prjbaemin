package com.kh.baemin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

	  @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        try {
	            // 세션
	            HttpSession session = req.getSession();

	            // 데이터 꺼내기 
	            String id = req.getParameter("id");
	            String pwd = req.getParameter("pwd");

	            MemberVo vo = new MemberVo();
	            vo.setId(id);
	            vo.setPwd(pwd);

	            MemberService ms = new MemberService();
	            MemberVo loginMemberVo = ms.login(vo);

	            // result
	            if (loginMemberVo == null) {
	                throw new Exception("로그인 실패: 사용자 정보를 찾을 수 없습니다.");
	            }

	            // 로그인 성공
	            session.setAttribute("alertMsg", "로그인 성공!!!");
	            session.setAttribute("loginMemberVo", loginMemberVo);
	           // resp.sendRedirect("/baemin/home");
	        } catch (Exception e) {
	            e.printStackTrace();
	            // 에러 페이지로 리디렉션 등 에러 처리 로직 추가 가능
	        }
	    }
	}

