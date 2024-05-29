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
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        
        String id = (String) session.getAttribute("MemberVo");

        MemberService ms = new MemberService();
        List<StoreOrderVo> orderList = null;
		try {
			orderList = ms.getOrderListByUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        req.setAttribute("orderList", orderList);
        req.getRequestDispatcher("/WEB-INF/views/member/orderList.jsp").forward(req, resp);
    }
}
