package com.kh.baemin.store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.store.service.StoreMenuService;
import com.kh.baemin.store.vo.CategoryVo;

/**
 * 스토어관리:카테고리 삭제 요청
 * 
 * @author 이수인
 */
@WebServlet("/store/category_delete")
public class StoreCategoryDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			HttpSession session = req.getSession();
			String storeNo = (String) session.getAttribute("storeNo");

			String categoryNoText = req.getParameter("categoryNoText");
			// 뽑아내는 categoryNoText는 "checkCategoryNo-10"문자열 형태. 숫자만 뽑아내는작업 하기
			int indexOfDash = categoryNoText.indexOf("-");
			String no = categoryNoText.substring(indexOfDash + 1);

			CategoryVo vo = new CategoryVo();
			vo.setNo(no);

			// TODO StoreNo
			vo.setStoreNo("7");

			StoreMenuService sms = new StoreMenuService();
			;
			int result = sms.categoryDelete(vo);
			if (result == 1) {
				req.setAttribute("resultMsg", "카테고리 삭제 성공!");
			} else {
				req.setAttribute("resultMsg", "카테고리 삭제 실패!ㅜㅜ");
			}
			resp.sendRedirect("/baemin/store/category_list");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
