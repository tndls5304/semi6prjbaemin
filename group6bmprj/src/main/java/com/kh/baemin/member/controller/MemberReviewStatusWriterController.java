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
import com.kh.baemin.member.vo.ReviewWriterVo;

@WebServlet("/member/reviewStatusWriter")
public class MemberReviewStatusWriterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/member/reviewStatusWriter.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
		System.out.println(loginMemberVo);
		String no = loginMemberVo.getNo();

		String deliveryProblem = req.getParameter("deliveryProblem");

		ReviewWriterVo vo = new ReviewWriterVo();
		vo.setDeliveryProblem(deliveryProblem);

		System.out.println("배달 문제" + vo);

		MemberService ms = new MemberService();
		int result = 0;

		try {
			result = ms.reviewStatus(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result == 1) {

			resp.sendRedirect("/baemin/member/reviewContentWriter");

		} else {

			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
