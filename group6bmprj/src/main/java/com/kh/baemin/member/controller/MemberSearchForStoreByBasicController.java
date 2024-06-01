package com.kh.baemin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.member.service.MemberSearchForStoreService;
import com.kh.baemin.member.vo.MemberVo;
import com.kh.baemin.member.vo.SearchForStoreVo;
import com.kh.baemin.store.vo.StoreInforVo;

@WebServlet("/member/search_store_by_basic")
public class MemberSearchForStoreByBasicController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 화면에서 가게종목 번호 받아오기
		String storeCategoryNo=req.getParameter("storeCategoryNo");
		
		//회원주소가져오기
		HttpSession session=req.getSession();
		MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
		String memberAddress=loginMemberVo.getAddress();
		
		
		//가게종목번호랑 회원주소 뭉쳐서 이제 가보자~
		SearchForStoreVo searchForStoreVo=new SearchForStoreVo();
		
		MemberSearchForStoreService service=new MemberSearchForStoreService();
		
		List<StoreInforVo>storeInforVo=service.searchForStoreByBasic(searchForStoreVo);
		
		
		super.doGet(req, resp);
	}
}
