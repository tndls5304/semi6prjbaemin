package com.kh.baemin.member.controller;

import com.kh.baemin.member.service.MemberReviewService;
import com.kh.baemin.member.vo.MemberVo;
import com.kh.baemin.member.vo.MemberReviewVo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/review")
public class MemberReviewController extends HttpServlet {

    private final MemberReviewService memberReviewService = new MemberReviewService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        List<MemberReviewVo> reviewList =  memberReviewService.getMyReviewList(loginMemberVo.getNo());
        req.setAttribute("reviewList", reviewList);
        req.getRequestDispatcher("/WEB-INF/views/member/myReview.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
