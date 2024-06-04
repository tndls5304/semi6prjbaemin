package com.kh.baemin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.baemin.member.service.MemberSearchForStoreService;
import com.kh.baemin.member.vo.MemberViewStoreInforVo;
import com.kh.baemin.member.vo.OneStoreReviewVo;
import com.kh.baemin.member.vo.StoreOfFoodCategoryVo;

@WebServlet("/member/view_one_store_detail")
public class MemberViewOneStoreInDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String storeNo=req.getParameter("storeNo");
			System.out.println("유저가 가게를 클릭하면 가게넘버가 나오니?"+storeNo);
			
			
			MemberSearchForStoreService service=new MemberSearchForStoreService();
		
			//전반적인 가게정보 보여줌
			MemberViewStoreInforVo memberViewStoreInforVo =service.memberViewStoreInfor(storeNo);
			req.setAttribute("memberViewStoreInforVo", memberViewStoreInforVo);
			System.out.println("클릭했을때 한가게의 정보를 보여주는 vo:"+memberViewStoreInforVo);
			
			//가게의 음식 카테고리, 메뉴 정보를 보여줌
			List<StoreOfFoodCategoryVo> storeOfFoodCategoryVoList  =service.memberViewStoreFoodMenu(storeNo);
			System.out.println("손님이 가게 클릭하고 음식리스트 보여주는 vo 바로확인하자!!"+storeOfFoodCategoryVoList);
			req.setAttribute("storeOfFoodCategoryVoList", storeOfFoodCategoryVoList);
			
			//한가게의 리뷰를 보여주는 
			
			List<OneStoreReviewVo> oneStoreReviewVoList=service.memberViewReview(storeNo);
			req.setAttribute("oneStoreReviewVoList", oneStoreReviewVoList);
			
			req.getRequestDispatcher("/WEB-INF/views/member/view_one_store_detail.jsp").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
}
