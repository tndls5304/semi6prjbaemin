package com.kh.baemin.store.controller;

import com.kh.baemin.store.service.StoreInforService;
import com.kh.baemin.store.vo.StoreInforVo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/store/manage")
public class StoreManageController extends HttpServlet {

	private final StoreInforService storeInforService = new StoreInforService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("no");

		StoreInforVo storeInfor = storeInforService.getStoreInfor(no);

		req.setAttribute("storeInfor", storeInfor);

		req.getRequestDispatcher("/WEB-INF/views/store/manage.jsp").forward(req, resp);
	}
	

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String openYn = req.getParameter("openYn");
		String storeOwnerPhone = req.getParameter("storeOwnerPhone");
		String storePhone = req.getParameter("storePhone");
		String introDuce = req.getParameter("introDuce");

		StoreInforVo storeInfor = new StoreInforVo();
		storeInfor.setNo(no);
		storeInfor.setOpenYn(openYn);
		storeInfor.setStoreOwnerPhone(storeOwnerPhone);
		storeInfor.setPhone(storePhone);
		storeInfor.setIntroduce(introDuce);

		storeInforService.updateStoreInfor(storeInfor);

		doGet(req, resp);
	}


}
