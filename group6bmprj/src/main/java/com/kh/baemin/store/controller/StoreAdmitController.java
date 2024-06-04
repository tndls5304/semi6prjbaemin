package com.kh.baemin.store.controller;

import java.io.IOException;
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
import com.kh.baemin.store.vo.StoreCategory;
import com.kh.baemin.store.vo.StoreInforVo;
import com.kh.baemin.store.vo.StoreOwnerVo;
import com.kh.baemin.util.file.FileUpload;

@MultipartConfig(
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 500,
        fileSizeThreshold = 1024 * 1024 * 50
)


@WebServlet("/store/admit")
public class StoreAdmitController extends HttpServlet {

    private final StoreInforService storeInforService = new StoreInforService();


    //ȭ�� ���
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

           List<StoreCategory> storeCategories =  storeInforService.getStoreCategoryList();
           req.setAttribute("storeCategories", storeCategories);
           req.getRequestDispatcher("/WEB-INF/views/store/admit.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            req.setAttribute("errMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }

    }

    //�㰡 ��û
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String addressDetail = req.getParameter("addressDetail");
        String deliveryZoneName = req.getParameter("deliveryZoneName");
        String storeCategoryNo = req.getParameter("storeCategoryNo");
        String openTime = req.getParameter("openTime");
        String endTime = req.getParameter("endTime");



        Part businessRegistrationVertificateImg = req.getPart("businessRegistrationVertificateImg");
        Part introduceImage = req.getPart("introduceImage");
        Part mainImage = req.getPart("mainImage");
        String uploadBusinessRegistrationVertificateImgName = FileUpload.save(businessRegistrationVertificateImg, getServletContext(), "store");
        String uploadIntroduceImageName = FileUpload.save(introduceImage, getServletContext(), "store");
        String uploadMainImageName = FileUpload.save(mainImage, getServletContext(), "store");


        try {
            HttpSession session = req.getSession();
            StoreOwnerVo loginStoreOwnerVo = (StoreOwnerVo) session.getAttribute("loginStoreOwnerVo");
            String storeOwnerNo = loginStoreOwnerVo.getNo();

            StoreInforVo storeInforVo = new StoreInforVo();
            storeInforVo.setName(name);
            storeInforVo.setOpenTime(openTime);
            storeInforVo.setEndTime(endTime);
            storeInforVo.setAddress(address);
            storeInforVo.setAddressDetail(addressDetail);
            storeInforVo.setLocalName(deliveryZoneName);
            storeInforVo.setStoreCategoryNo(storeCategoryNo);
            storeInforVo.setBusinessRegistrationCertificateImg(uploadBusinessRegistrationVertificateImgName);
            storeInforVo.setMainImg(uploadMainImageName);
            storeInforVo.setIntroductionImg(uploadIntroduceImageName);
			storeInforVo.setStoreOwnerNo(storeOwnerNo);
            storeInforVo.setApprovalStatusNo("2");


            storeInforService.insertStoreInfor(storeInforVo);

            //req.setAttribute("storeInforVo", storeInforVo);

            session.setAttribute("storeInforNo", storeInforVo.getNo());

            resp.sendRedirect("/baemin/store/manage?no=" + storeInforVo.getNo());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            req.setAttribute("errMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }
}



