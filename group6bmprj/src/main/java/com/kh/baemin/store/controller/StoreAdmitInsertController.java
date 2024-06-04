package com.kh.baemin.store.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.kh.baemin.store.service.StoreAdmitService;
import com.kh.baemin.store.vo.StoreAdmitVo;
import com.kh.baemin.store.vo.StoreInforVo;
import com.kh.baemin.util.file.FileUpload;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50, 
		maxRequestSize = 1024 * 1024 * 500,
		fileSizeThreshold = 1024 * 1024 * 50
		)


@WebServlet("/store/admit/insert")
public class StoreAdmitInsertController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			String addressDetail = req.getParameter("address_detail");
			String deliveryZone = req.getParameter("delivery_zone");
			String storeCategoryNo = req.getParameter("store_category_no");
			String companyResistraionNumber = req.getParameter("company_resistraion_number");
			String businessResistration = req.getParameter("business_resistration");
			
			StoreAdmitVo storeAdmitVo = (StoreAdmitVo) session.getAttribute("StoreInforVo");
			String no = storeAdmitVo.getNo();
			
			Collection<Part> parts = req.getParts();
			
			List<Part> fileList = new ArrayList<Part>();
			for (Part part : parts) {
				if(part.getContentType() != null) {
					fileList.add(part);
				}
			}
			

			List<StoreAdmitVo> storeAdmitVoList = new ArrayList<StoreAdmitVo>();
			for (Part f : fileList) {
				//StoreAdmitVo storeAdmitVo = FileUpload.saveFile(f);
				storeAdmitVoList.add(storeAdmitVo);
			}
	
			storeAdmitVo.setName(name);
			storeAdmitVo.setAddress(address);
			storeAdmitVo.setAddressDetail(addressDetail);
			storeAdmitVo.setStoreDeliveryZoneNo(deliveryZone);
			storeAdmitVo.setStoreCategoryNo(storeCategoryNo);
			storeAdmitVo.setCompanyResistraionNumber(companyResistraionNumber);
			storeAdmitVo.setBusinessRegistrationVertificateImg(businessResistration);
			
			StoreAdmitService service = new StoreAdmitService();
			int result = service.writeStoreInfor(storeAdmitVo);
			
			
			
			
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//method
	
}
