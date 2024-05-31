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
          System.out.println(loginMemberVo);

          if (loginMemberVo == null) {
              System.out.println("로그인 필요");
              resp.sendRedirect("/baemin/member/login");
              return;
          }
              req.getRequestDispatcher("/WEB-INF/views/member/info.jsp").forward(req, resp);
          
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memberImg = req.getParameter("memberImg");
        String nick = req.getParameter("nick");
        String memberPayStr = req.getParameter("memberPay");
        String no = req.getParameter("no");
        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo != null) {
            loginMemberVo.setMemberImg(memberImg);
            loginMemberVo.setNick(nick);

            // 기존 페이 금액에 입력된 금액을 더함
            int existingPay = Integer.parseInt(loginMemberVo.getMemberPay());
            int additionalPay = Integer.parseInt(memberPayStr);
            int updatedPay = existingPay + additionalPay;
            loginMemberVo.setMemberPay(String.valueOf(updatedPay));

        	MemberVo vo = new MemberVo();
			vo.setMemberImg(memberImg);
			vo.setNick(nick);
			vo.setMemberPay(memberPayStr);
			vo.setNo(no);
			
            
            
            MemberService ms = new MemberService();
            int result = ms.info(loginMemberVo);

            if (result == 1) {
            	
                req.setAttribute("message", "정보가 성공적으로 업데이트되었습니다.");
                session.setAttribute("loginMemberVo", loginMemberVo); 
               
            } else {
                req.setAttribute("message", "정보 업데이트에 실패했습니다.");
            }
        } else {
            req.setAttribute("message", "로그인이 필요합니다.");
        }
        
        req.getRequestDispatcher("/WEB-INF/views/member/info.jsp").forward(req, resp);
    }
}
