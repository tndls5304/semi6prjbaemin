package com.kh.baemin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.member.service.MemberCartService;
import com.kh.baemin.member.vo.CartVo;
import com.kh.baemin.member.vo.MemberVo;

@WebServlet("/member/addcart")
public class MemberAddCartContoller extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		 MemberVo loginMemberVo=(MemberVo)session.getAttribute("loginMemberVo");
		
		String MemberNo=loginMemberVo.getNo();
		String foodNo=req.getParameter("foodNo");
		String foodCount=req.getParameter("foodCount");
		
		CartVo cartVo=new CartVo();
		cartVo.setMemberNo(MemberNo);
		cartVo.setFoodNo(foodNo);
		cartVo.setFoodCount(foodCount);
		
		MemberCartService service=new MemberCartService();
		int result=service.addCart(cartVo);
	}
}
