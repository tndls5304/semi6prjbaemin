package com.kh.baemin.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.MemberVo;

@WebServlet("/member/info")
public class MemberInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo != null) {
            req.setAttribute("memberInfo", loginMemberVo);
            req.getRequestDispatcher("/WEB-INF/views/member/info.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/baemin/member/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberImg = req.getParameter("memberImg");
        String memberNickName = req.getParameter("memberNickName");
        String memberPayStr = req.getParameter("memberPay");

        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo != null) {
            loginMemberVo.setMemberImg(memberImg);
            loginMemberVo.setMemberNickName(memberNickName);

            // 기존 페이 금액에 입력된 금액을 더함
            int existingPay = Integer.parseInt(loginMemberVo.getMemberPay());
            int additionalPay = Integer.parseInt(memberPayStr);
            int updatedPay = existingPay + additionalPay;
            loginMemberVo.setMemberPay(String.valueOf(updatedPay));

            MemberService ms = new MemberService();
            int result = ms.info(loginMemberVo);

            if (result == 1) {
                req.setAttribute("message", "정보가 성공적으로 업데이트되었습니다.");
                session.setAttribute("loginMemberVo", loginMemberVo);  // 업데이트된 정보 세션에 반영
            } else {
                req.setAttribute("message", "정보 업데이트에 실패했습니다.");
            }
        } else {
            req.setAttribute("message", "로그인이 필요합니다.");
        }
        
        req.getRequestDispatcher("/WEB-INF/views/member/info.jsp").forward(req, resp);
    }
}
