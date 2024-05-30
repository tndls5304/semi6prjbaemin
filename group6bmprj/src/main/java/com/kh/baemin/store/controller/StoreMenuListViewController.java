package com.kh.baemin.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.baemin.store.service.StoreMenuService;
import com.kh.baemin.store.vo.FoodInforVo;

@WebServlet("/store/menu_list")
public class StoreMenuListViewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			// TODO StoreNo
			String storeNo = "1";

			StoreMenuService service = new StoreMenuService();
			List<FoodInforVo> menuVolist = service.selectMenuList(storeNo);
			System.out.println("전체 메뉴조회 해오기:" + menuVolist);
			req.setAttribute("foodMenuInforVolist", menuVolist);

			req.getRequestDispatcher("/WEB-INF/views/store/menu_edit.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
