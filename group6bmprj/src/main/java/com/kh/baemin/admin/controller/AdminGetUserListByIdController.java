package com.kh.baemin.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.baemin.admin.service.AdminManageUserService;
import com.kh.baemin.member.vo.MemberVo;

@WebServlet("/admin/get_userlist_by_id")
public class AdminGetUserListByIdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String userId=req.getParameter("userId");
		
		AdminManageUserService service =new AdminManageUserService();
		List<MemberVo>voList=service.getUserListById(userId);
		Gson gson=new Gson();
		String jsonStr=gson.toJson(voList);
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter out=resp.getWriter();
		out.write(jsonStr);
		
		
	}
}
