package com.kh.baemin.store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/StoreOwner/logout")
public class StoreLogOutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("loginStoreOwnerVo");
		session.setAttribute("alertMsg", "사장님 로그아웃 완료되었습니다");
		resp.sendRedirect("/baemin/store/admit/insert");
	}
}
