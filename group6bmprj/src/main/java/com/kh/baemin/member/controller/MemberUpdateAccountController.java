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

@WebServlet
public class MemberUpdateAccountController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {	HttpSession session = req.getSession();
		MemberVo loginMemberVo =(MemberVo)session.getAttribute("loginMemberVo");
		String no = loginMemberVo.getNo();
		
		String chargeAmount = req.getParameter("chargeAmount");
		
		MemberVo vo = new MemberVo();
		vo.setChargeAmount(chargeAmount);
		
		
		MemberService ms = new MemberService();
		
		
		
		
		MemberVo memberVo = ms.updateAccount(no);
		req.getRequestDispatcher("/WEB-INF/views/member/info.jsp").forward(req, resp);
	
	} catch (

			Exception e) {
				req.setAttribute("errMsg", e.getMessage());

				e.printStackTrace();
				System.out.println(e.getMessage());
				req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
			}

	}
}

		
		
		
