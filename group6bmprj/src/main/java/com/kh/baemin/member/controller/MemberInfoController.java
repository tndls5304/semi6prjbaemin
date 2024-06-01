package com.kh.baemin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.MemberVo;
import com.kh.baemin.member.vo.StoreOrderVo;

@WebServlet("/member/info")
public class MemberInfoController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String no = loginMemberVo.getNo();

			if (loginMemberVo == null) {
				resp.sendRedirect("/baemin/member/login");
				return;
			}

			MemberService ms = new MemberService();
			MemberVo memberVo = ms.info(no);
			
			String accountBalance =memberVo.getAccountBalance();
			String nick = memberVo.getNick();
			String memberImg = memberVo.getMemberImg();
			
			
			

		loginMemberVo.setAccountBalance(accountBalance);
		loginMemberVo.setNick(nick);
		loginMemberVo.setMemberImg(memberImg);
		
		req.getRequestDispatcher("/WEB-INF/views/member/info.jsp").forward(req, resp);

		} catch (

		Exception e) {
			req.setAttribute("errMsg", e.getMessage());

			e.printStackTrace();
			System.out.println(e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
