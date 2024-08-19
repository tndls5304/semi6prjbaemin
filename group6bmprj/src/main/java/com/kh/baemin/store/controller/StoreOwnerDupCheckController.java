
package com.kh.baemin.store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.baemin.store.service.StoreOwnerService;

/**
 * 스토어 사장님 가입시 중복검사
 * 
 * @author 이수인
 */
@WebServlet("/store/store_owner_idcheck")
public class StoreOwnerDupCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");

			StoreOwnerService service = new StoreOwnerService();
			boolean isAvailable = service.checkIdDup(id);

			// 결과
			if (!isAvailable) {
				throw new Exception("중복검사실패");
			}
			resp.getWriter().write("good");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("bad");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
