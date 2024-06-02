package com.kh.baemin.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.baemin.store.service.StoreInforService;
import com.kh.baemin.store.service.StoreOwnerService;
import com.kh.baemin.util.file.FileUpload;



import com.kh.baemin.store.service.StoreAdmitService;
import com.kh.baemin.store.vo.StoreInforVo;
import com.kh.baemin.store.vo.StoreOwnerVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50, 
		maxRequestSize = 1024 * 1024 * 500,
		fileSizeThreshold = 1024 * 1024 * 50
		)


@WebServlet("/store/admit")
public class StoreAdmitController extends HttpServlet {

	private final StoreInforService storeInforService = new StoreInforService();
	
	
	//화면 출력
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.getRequestDispatcher("/WEB-INF/views/store/admit.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg",  e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
	
	//허가 신청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String addressDetail = req.getParameter("addressDetail");
		String localName = req.getParameter("localName");
		String storeCategoryNo = req.getParameter("storeCategoryNo");
		Part businessRegistrationVertificateImg = req.getPart("businessRegistrationVertificateImg");
		String uploadImage = FileUpload.save(businessRegistrationVertificateImg, getServletContext());


		try {
			 HttpSession session=req.getSession();
			 StoreOwnerVo loginStoreOwnerVo= (StoreOwnerVo) session.getAttribute("loginStoreOwnerVo");
	         String storeOwnerNo=loginStoreOwnerVo.getNo();


			StoreInforVo storeInforVo = new StoreInforVo();
			storeInforVo.setName(name);
			storeInforVo.setAddress(address);
			storeInforVo.setAddressDetail(addressDetail);
			storeInforVo.setLocalName(localName);
			storeInforVo.setStoreCategoryNo(storeCategoryNo);
			storeInforVo.setBusinessRegistrationCertificateImg(uploadImage);

			storeInforService.insertStoreInfor(storeInforVo);

			req.setAttribute("storeInforVo", storeInforVo);
			
	        session.setAttribute("storeInforNo", storeInforVo.getNo());
			
			resp.sendRedirect("/baemin/store/admit");

	    }catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}



