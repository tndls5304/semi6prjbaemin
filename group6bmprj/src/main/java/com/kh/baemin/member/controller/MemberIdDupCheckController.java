package com.kh.baemin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.baemin.member.service.MemberService;

@WebServlet("/member/id-dup")
public class MemberIdDupCheckController extends HttpServlet {

	
	@Override // 이 메소드는 클라한테 문자열 내보내기 하는데
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 아디 중복검사
			// html하는게 아니고 짧은 문자열 사용 가능 불가능 내보내기
			// 문자열 내보내기 편하게 할려 jsp하는게
			// 전달받은 아이디를 이용하여 디비에 존재하는지 검사
			// 데꺼
			String id = req.getParameter("id");

			// 서비스
			MemberService ms = new MemberService();
			boolean isAvailable = ms.checkIdDup(id);

			// 결과

			if (!isAvailable) {

				throw new Exception("중복검사 실패..");
			}

			resp.getWriter().write("good");
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = resp.getWriter();
			resp.getWriter().write("bad");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
	

