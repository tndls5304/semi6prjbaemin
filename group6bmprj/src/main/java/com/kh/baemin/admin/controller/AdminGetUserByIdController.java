package com.kh.baemin.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.baemin.admin.service.AdminManageUserService;
import com.kh.baemin.member.vo.MemberVo;

@WebServlet("/admin/get_user/byid")
public class AdminGetUserByIdController extends HttpServlet {
	private final AdminManageUserService service;
	public AdminGetUserByIdController() {
		this.service=new AdminManageUserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String userId= req.getParameter("searchUserIdValue");
			String delYn= req.getParameter("delYn");
			System.out.println(userId);
			System.out.println(delYn);


		MemberVo memberVo=null;
			if(delYn.equals("Y")) {
				System.out.println("if ~~~");
				 memberVo= service.adminGetInactiveUserById(userId);
			}else if(delYn.equals("N")){
				System.out.println("else if ~~~");
				 memberVo = service.adminGetUserById(userId);
			}
			System.out.println("컨트롤러 멤버vo 는?"+memberVo);
			
			Gson gson = new Gson();
			String jsonStr = gson.toJson(memberVo);
			resp.setContentType("application/json; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			System.out.println("jsonStr : " + jsonStr);
			out.write(jsonStr);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
