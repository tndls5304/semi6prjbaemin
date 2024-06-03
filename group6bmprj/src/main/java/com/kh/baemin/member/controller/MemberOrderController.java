package com.kh.baemin.member.controller;

import com.kh.baemin.member.service.MemberOrderService;
import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.MemberOrderVo;
import com.kh.baemin.member.vo.MemberVo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/order")
public class MemberOrderController extends HttpServlet {

    private final MemberOrderService memberOrderService = new MemberOrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo == null) {
            resp.sendRedirect("/baemin/member/login");
            return;
        }

        String storeNo = req.getParameter("storeNo");
        String memberNo = loginMemberVo.getNo();

        MemberVo memberVo = memberOrderService.getMember(memberNo);

        String phone = memberVo.getPhone();
        String address = memberVo.getAddress();
        String accountBalance = memberVo.getAccountBalance();

        Integer taotalPrice = memberOrderService.getTotalPrice(memberNo);

        MemberOrderVo memberOrderVo = new MemberOrderVo();
        memberOrderVo.setStoreNo(storeNo);
        memberOrderVo.setMemberNo(memberNo);
        memberOrderVo.setPhone(phone);
        memberOrderVo.setAddress(address);
        memberOrderVo.setAccountBalance(accountBalance);
        memberOrderVo.setTotalOrderPay(taotalPrice);

        req.setAttribute("memberOrder", memberOrderVo);

        req.getRequestDispatcher("/WEB-INF/views/member/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo == null) {
            resp.sendRedirect("/baemin/member/login");
            return;
        }

        String storeNo = req.getParameter("storeNo");
        String memberNo = loginMemberVo.getNo();
        String requestMsg = req.getParameter("requestMsg");
        Integer toalOrderPay = memberOrderService.getTotalPrice(memberNo);
        MemberVo memberVo = memberOrderService.getMember(memberNo);

        MemberOrderVo memberOrderVo = new MemberOrderVo();
        memberOrderVo.setMemberNo(loginMemberVo.getNo());
        memberOrderVo.setStoreNo(storeNo);
        memberOrderVo.setAddress(memberVo.getAddress());
        memberOrderVo.setRequestMsg(requestMsg);
        memberOrderVo.setOrderStatus("6");
        memberOrderVo.setTotalOrderPay(toalOrderPay);

        memberOrderService.insertOrder(memberOrderVo);

        resp.sendRedirect("/baemin/member/home");

    }


}
