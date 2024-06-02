package com.kh.baemin.member.controller;

import com.kh.baemin.store.service.StoreInforService;
import com.kh.baemin.store.vo.StoreInforVo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/search")
public class MemberSearchController extends HttpServlet{

	private final StoreInforService storeInforService = new StoreInforService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String searchText = req.getParameter("searchText");

		List<StoreInforVo> storeInforList = null;

		if( searchText == null || searchText.isEmpty() ) {
			storeInforList = storeInforService.getTop10StoreList();

			// 첫 번째 리스트: 첫 5개 요소
			List<StoreInforVo> firstPart = storeInforList.subList(0, Math.min(storeInforList.size(), 5));

			// 두 번째 리스트: 다음 5개 요소
			List<StoreInforVo> secondPart = storeInforList.subList(Math.min(storeInforList.size(), 5), Math.min(storeInforList.size(), 10));

			req.setAttribute("firstPart", firstPart);
			req.setAttribute("secondPart", secondPart);

		} else {
			storeInforList = storeInforService.getStoreInforList(searchText);
			req.setAttribute("storeInforList", storeInforList);
		}

		req.setAttribute("searchText", searchText);

		req.getRequestDispatcher("/WEB-INF/views/member/search.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
