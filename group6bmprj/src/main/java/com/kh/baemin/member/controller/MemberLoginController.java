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

/**
 * 일반회원 로그인
 *
 * @author 이수인
 */
@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 세션 생성 또는 기존 세션 가져오기
			HttpSession session = req.getSession();

			// 데이터 꺼내기
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");

			MemberVo vo = new MemberVo();
			vo.setId(id);
			vo.setPwd(pwd);

			// 로그인 서비스 호출
			MemberService ms = new MemberService();
			MemberVo loginMemberVo = ms.login(vo);

			// 로그인 결과 처리
			if (loginMemberVo == null) {
				req.setAttribute("errorMessage", "로그인 실패: 아이디 또는 비밀번호를 확인하세요.");
				req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
				return;
			}
			// 로그인 성공
			session.setAttribute("loginMemberVo", loginMemberVo);
			session.setAttribute("alertMsg", "로그인 성공!!!");

			resp.sendRedirect("/baemin/member/home"); // 홈 페이지로 리디렉트
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("alertMsg", "로그인 중 오류가 발생했습니다. 다시 시도해주세요.");
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		}
	}
}