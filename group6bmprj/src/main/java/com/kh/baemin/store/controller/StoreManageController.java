package com.kh.baemin.store.controller;

import com.kh.baemin.store.service.StoreInforService;
import com.kh.baemin.store.vo.ClosedDayVo;
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
		List<ClosedDayVo> closedDays = storeInforService.getClosedDays(no);

		req.setAttribute("storeInfor", storeInfor);
		req.setAttribute("closedDays", closedDays);
		req.getRequestDispatcher("/WEB-INF/views/store/manage.jsp").forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String openYn = req.getParameter("openYn");
		String storeOwnerPhone = req.getParameter("storeOwnerPhone");
		String phone = req.getParameter("phone");
		String introduce = req.getParameter("introduce");
		String openTime = req.getParameter("openTime");
		String endTime = req.getParameter("endTime");
		String breakTimeStart = req.getParameter("breakTimeStart");
		String breakTimeEnd = req.getParameter("breakTimeEnd");
		String minimumOrderAmount = req.getParameter("minimumOrderAmount");
		String closedDays1 = req.getParameter("closedDays1");
		String closedDays2 = req.getParameter("closedDays2");
		String closedDays3 = req.getParameter("closedDays3");
		String closedDays4 = req.getParameter("closedDays4");
		String closedDays5 = req.getParameter("closedDays5");

		StoreInforVo storeInfor = new StoreInforVo();
		storeInfor.setNo(no);
		storeInfor.setOpenYn(openYn);
		storeInfor.setStoreOwnerPhone(storeOwnerPhone);
		storeInfor.setPhone(phone);
		storeInfor.setIntroduce(introduce);
		storeInfor.setOpenTime(openTime);
		storeInfor.setEndTime(endTime);
		storeInfor.setBreakTimeStart(breakTimeStart);
		storeInfor.setBreakTimeEnd(breakTimeEnd);
		storeInfor.setMinimumOrderAmount(minimumOrderAmount);
		storeInfor.setClosedDays1(closedDays1);
		storeInfor.setClosedDays2(closedDays2);
		storeInfor.setClosedDays3(closedDays3);
		storeInfor.setClosedDays4(closedDays4);
		storeInfor.setClosedDays5(closedDays5);


		storeInforService.updateStoreInfor(storeInfor);

		// ���� ����
		resp.setCharacterEncoding("UTF-8");

		// JSON ���� ����
		resp.getWriter().write("����");
	}


}
