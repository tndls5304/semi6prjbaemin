package com.kh.baemin.admin.controller;

import com.kh.baemin.admin.service.AdminReviewService;
import com.kh.baemin.admin.vo.AdminReviewVO;
import com.kh.baemin.member.service.MemberReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/review")
public class AdminReviewManageController extends HttpServlet {

	private final AdminReviewService adminReviewService = new AdminReviewService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userContent = req.getParameter("userContent");
		String memberId = req.getParameter("memberId");

		AdminReviewVO adminReviewVO = new AdminReviewVO();
		adminReviewVO.setUserContent(userContent);
		adminReviewVO.setMemberId(memberId);

		List<AdminReviewVO> reviewList = adminReviewService.getReviewList(adminReviewVO);

		req.setAttribute("reviewList", reviewList);
		req.getRequestDispatcher("/WEB-INF/views/admin/review_manage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	// delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewNo = req.getParameter("reviewNo");

		adminReviewService.deleteReview(reviewNo);

		req.getRequestDispatcher("/WEB-INF/views/admin/review_manage.jsp").forward(req, resp);
	}


}
