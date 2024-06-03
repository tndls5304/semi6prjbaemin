package com.kh.baemin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		try {
			HttpSession session=req.getSession();
			MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
			
			String memberNo=loginMemberVo.getNo();
			String foodNo=req.getParameter("foodNo");
			String foodCount=req.getParameter("foodCount");
			System.out.println("장바구니추가하면 음식넘버들고왔니?"+foodNo);
			System.out.println("장바구니추가하면 음식수량 들고왔니?"+foodCount);
			
			CartVo cartVo=new CartVo();
			cartVo.setMemberNo(memberNo);
			cartVo.setFoodNo(foodNo);
			cartVo.setFoodCount(foodCount);
			
			MemberCartService service=new MemberCartService();
			int result=service.addCart(cartVo);
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
			
		}catch(Exception e){
			e.printStackTrace();

		}
	}
}
