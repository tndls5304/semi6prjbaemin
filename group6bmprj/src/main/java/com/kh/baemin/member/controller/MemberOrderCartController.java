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
			

			if (loginMemberVo == null) {
				System.out.println("로그인 필요");
				resp.sendRedirect("/baemin/member/login");
				return;
			}
			
        
        MemberService ms = new MemberService();
        List<StoreOrderVo> orderList = ms.getOrderListByUser(userId);
        
        req.setAttribute("orderList", orderList);
        req.getRequestDispatcher("/WEB-INF/views/member/orderCart.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String storeImg = req.getParameter("storeImg"); 
        String storeName = req.getParameter("storeName"); 
        String storeFood = req.getParameter("storeFood"); 
        String foodPrice = req.getParameter("foodPrice"); 
        String foodImg = req.getParameter("foodImg"); 
        
        StoreOrderVo vo = new StoreOrderVo();
        vo.setStoreImg(storeImg);
        vo.setStoreName(storeName);
        vo.setStoreFood(storeFood);
        vo.setFoodImg(foodImg);
        vo.setFoodPrice(foodPrice);
        
        // 실제로 주문을 저장하는 로직을 추가합니다.
        MemberService ms = new MemberService();
        int result = ms.saveOrder(vo);
        
        if (result == 1) {
            req.setAttribute("message", "Order saved successfully!");
        } else {
            req.setAttribute("message", "Failed to save order.");
        }
        
        req.getRequestDispatcher("/WEB-INF/views/member/orderCart.jsp").forward(req, resp);
    }
}
