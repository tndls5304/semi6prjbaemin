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

import org.apache.tomcat.util.http.fileupload.FileUpload;

import com.kh.baemin.store.service.StoreAdmitService;
import com.kh.baemin.store.vo.StoreInforVo;
import com.kh.baemin.store.vo.StoreOwnerVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50, 
		maxRequestSize = 1024 * 1024 * 500,
		fileSizeThreshold = 1024 * 1024 * 50
		)


@WebServlet
public class StoreAdmitController extends HttpServlet {
	
	
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
		
		try {
			HttpSession session = req.getSession();
			
			// 데이터 꺼내기
			String name = req.getParameter("name");
			String address = req.getParameter("address");
			String addressDetail = req.getParameter("addressDetail");
			String storeCategoryNo = req.getParameter("storeCategoryNo");
			String companyResitrationNumber  = req.getParameter("companyResitrationNumber ");
			String businessRegistrationVertificateImg = req.getParameter("businessRegistrationVertificateImg");
			
			
			Collection<Part> parts = req.getParts();
			
			List<Part> fileList = new ArrayList<Part>();
			for (Part part : parts) {
				if(part.getContentType() != null) {
					fileList.add(part);
				}
			}
			
			//서버에 파일 업로드
			List<StoreInforVo> storeInforVoList = new ArrayList<StoreInforVo>();
			for (Part f : fileList) {
				StoreInforVo storeInforVo = FileUpload.saveFile(f);
				storeInforVoList.add(storeInforVo);
			}
			

			
			StoreOwnerVo storeOwnerVo = (StoreOwnerVo) session.getAttribute("storeOwnerVo");
			String no = storeOwnerVo.getNo();
			
			StoreInforVo vo = new StoreInforVo();
			vo.setName(name);
			vo.setAddress(address);
			vo.setAddressDetail(addressDetail);
			vo.setStoreCategoryNo(storeCategoryNo);
			vo.setCompanyRestrationNumber(companyRestrationNumber);
			
			// 서비스 호출
			StoreAdmitService sas = new StoreAdmitService();
			int result = sas.insert(vo , storeInforVoList);
			
			// 결과
			if(result < 1) {
				throw new Exception("허가 신청 실패 ...");
			}
			resp.sendRedirect("/baemin/store/admit");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
		
		
	}

}
