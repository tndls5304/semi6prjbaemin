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

@WebServlet("/member/orderList")
public class MemberOrderListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			System.out.println(loginMemberVo);
			

			if (loginMemberVo == null) {
				System.out.println("로그인 필요");
				resp.sendRedirect("/baemin/member/login");
				return;
			}
			
			
			String no = req.getParameter("no");
			StoreOrderVo vo = new StoreOrderVo();
			vo.setMemberNo(no);
			
			MemberService ms = new MemberService();
			List<StoreOrderVo> orderList = ms.getOrderListByUser(no);
			
			req.setAttribute("no", no);
			req.setAttribute("orderList", orderList);
			req.getRequestDispatcher("/WEB-INF/views/member/orderList.jsp").forward(req, resp);

		} catch (Exception e) {
			req.setAttribute("errMsg", e.getMessage());
		
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
