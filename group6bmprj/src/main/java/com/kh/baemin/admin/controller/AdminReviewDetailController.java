package com.kh.baemin.admin.controller;

import com.kh.baemin.admin.service.AdminReviewService;
import com.kh.baemin.admin.vo.AdminReviewVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/review/detail")
public class AdminReviewDetailController extends HttpServlet {

	private final AdminReviewService adminReviewService = new AdminReviewService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		String reviewNo = req.getParameter("reviewNo");

		AdminReviewVO adminReviewVO = adminReviewService.getReviewDetail(reviewNo);

		req.getRequestDispatcher("/WEB-INF/views/admin/review_detail.jsp").forward(req, resp);
	}



}
