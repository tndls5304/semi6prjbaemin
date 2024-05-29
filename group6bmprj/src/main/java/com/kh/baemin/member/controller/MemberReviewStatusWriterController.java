package com.kh.baemin.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.ReviewWriterVo;

@WebServlet("/member/reviewStatusWriter")
public class MemberReviewStatusWriterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            resp.sendRedirect(req.getContextPath() + "/member/login");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/views/member/reviewStatusWriter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginMember") == null) {
            resp.sendRedirect(req.getContextPath() + "/member/login");
            return;
        }

        String deliveryProblem = req.getParameter("deliveryProblem");

        ReviewWriterVo vo = new ReviewWriterVo();
        vo.setDeliveryProblem(deliveryProblem);

        MemberService ms = new MemberService();
        int result = 0;

        try {
            result = ms.reviewStatus(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == 1) {
            session.setAttribute("deliveryProblem", deliveryProblem);
            req.setAttribute("message", "리뷰가 성공적으로 저장되었습니다.");
            req.setAttribute("deliveryProblem", deliveryProblem);
            req.getRequestDispatcher("/WEB-INF/views/member/reviewContentWriter.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "리뷰 저장에 실패했습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }
}
