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

@WebServlet("/member/orderCart")
public class MemberOrderCartController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String no = loginMemberVo.getNo();
			System.out.println(loginMemberVo);
			

			
        
        MemberService ms = new MemberService();
        List<StoreOrderVo> orderList = ms.getOrderListByUser(userId);
        
        req.setAttribute("orderList", orderList);
        req.getRequestDispatcher("/WEB-INF/views/member/orderCart.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
        
    
    }
}
