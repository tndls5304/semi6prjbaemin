package com.kh.baemin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.member.service.MemberGetInforService;
import com.kh.baemin.member.vo.MemberVo;

@WebServlet("/member/change_address")
public class MemberChangeAddressController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String changeAddress = req.getParameter("changeAddress");
		String changeAddressdDetail=req.getParameter("changeAddressdDetail");
		
		MemberVo vo=new MemberVo();
		vo.setAddress(changeAddress);
		vo.setAddressdDetail(changeAddressdDetail);
		
		MemberGetInforService service=new MemberGetInforService();
		int result=service.changeAddress();
		
		if(result!=1) {
			throw new Exception();
		}
		HttpSession session=req.getSession();
		MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
		session.setAttribute(, session);
}
