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
/**
 * 일반회원의 가게 조회 
 * @author 이수인
 */
@WebServlet("/member/search_store_by_basic")
public class MemberSearchForStoreByBasicController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		//가게 카테고리와 카테고리 이름 받아오기
			String storeCategoryNo=req.getParameter("storeCategoryNo");
			String storeCategoryName=req.getParameter("storeCategoryName");
			System.out.println("홈에서 클릭한 가게종목 가져왔니?"+storeCategoryName);
			
			//세션에서 회원주소가져오기
			HttpSession session=req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String memberAddress=loginMemberVo.getAddress();
			
			
			//가게종목번호랑 회원주소 뭉쳐서 이제 가보자~
			SearchForStoreVo searchForStoreVo=new SearchForStoreVo();
			searchForStoreVo.setStoreCategoryNo(storeCategoryNo);
			searchForStoreVo.setMemberAddress(memberAddress);
			
			//가게목록들 뽑으러 가기~
			MemberSearchForStoreService service=new MemberSearchForStoreService();
			List<StoreInforVo>storeInforVoList=service.searchForStoreByBasic(searchForStoreVo);
			
			System.out.println("storeInforVoList받아왔니?"+storeInforVoList);
			req.setAttribute("storeInforVoList", storeInforVoList);
			req.setAttribute("storeCategoryName", storeCategoryName);
			
			req.getRequestDispatcher("/WEB-INF/views/member/searchForStore.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
