package com.kh.baemin.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.store.service.StoreMenuService;
import com.kh.baemin.store.vo.CategoryVo;
import com.kh.baemin.store.vo.FoodInforVo;
import com.kh.baemin.store.vo.StoreOwnerVo;

@WebServlet("/store/category_list")
public class StoreCategoryListController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	
	try {
		HttpSession session = req.getSession();
		
		//세션에서 가게넘버 빼자
		String storeNo=(String) session.getAttribute("storeNo");
	
	
		// TODO StoreNo
		storeNo="16";
		
		
		StoreMenuService sms=new StoreMenuService();
		List<CategoryVo> categoryVolist=sms.selectCategoryList(storeNo);
		req.setAttribute("categoryVolist", categoryVolist);
		
		StoreMenuService service = new StoreMenuService();
		List<FoodInforVo> menuVolist = service.selectMenuList(storeNo);
		System.out.println("전체 메뉴조회 해오기:" + menuVolist);
		req.setAttribute("foodMenuInforVolist", menuVolist);
		
		req.getRequestDispatcher("/WEB-INF/views/store/menu_edit.jsp").forward(req, resp);
	
	} catch (Exception e) {
		e.printStackTrace();
	}

	
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
}
