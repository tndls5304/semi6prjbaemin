package com.kh.baemin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet()
public class MemberViewStoreListOfSelectedFoodController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 화면에서 가게종목 번호 받아오기
		HttpSession session=req.getSession();
		=session.getAttribute("loginMemberVo");
		String storeCategoryNo=req.getParameter("storeCategoryNo");
		super.doGet(req, resp);
	}
}
