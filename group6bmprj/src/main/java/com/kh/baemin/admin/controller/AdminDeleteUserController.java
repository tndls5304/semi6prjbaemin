package com.kh.baemin.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.baemin.admin.service.AdminManageUserService;

@WebServlet("/admin/delete_user")
public class AdminDeleteUserController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String memberId = req.getParameter("memberId");
			AdminManageUserService service = new AdminManageUserService();
			int result = service.adminDeleteUser(memberId);

			if (result == 1) {
				resp.getWriter().write("success");
			} else {
				throw new Exception("삭제실패ㅠㅠ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("fail");
		}
	}
}
