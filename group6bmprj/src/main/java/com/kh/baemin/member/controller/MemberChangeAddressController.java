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
	try{
		
		//회원번호 가져오기 
	HttpSession session = req.getSession();
	MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
	String no=loginMemberVo.getNo();
		//회원이 입력한 주소
		String changeAddress = req.getParameter("changeAddress");
		String changeAddressdDetail = req.getParameter("changeAddressdDetail");
		
		//뭉쳐서
		MemberVo vo=new MemberVo();
		vo.setNo(no);
		vo.setAddress(changeAddress);
		vo.setAddressdDetail(changeAddressdDetail);
		
		//디비로 가는길
		MemberGetInforService service = new MemberGetInforService();
		int result = service.changeAddress(vo);
		
		if (result != 1) {
			throw new Exception("주소바꾸기실패!");
		}
		
		// 디비에 주소 바꾼 후에 세션에 바뀐주소 넣기
		loginMemberVo.setAddress(changeAddress);
		loginMemberVo.setAddressdDetail(changeAddressdDetail);

	
	}catch(Exception e) {
		e.printStackTrace();
		req.setAttribute("errMsg", e.getMessage());
		req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
	}
	}
}
