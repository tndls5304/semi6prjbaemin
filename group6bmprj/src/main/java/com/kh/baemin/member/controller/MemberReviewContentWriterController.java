package com.kh.baemin.member.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.ReviewWriterVo;

@WebServlet("/member/reviewContentWriter")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB
    maxFileSize = 1024 * 1024 * 10,       // 10 MB
    maxRequestSize = 1024 * 1024 * 100    // 100 MB
)
public class MemberReviewContentWriterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/member/reviewContentWriter.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String storeName = req.getParameter("storeName");
        String rating = req.getParameter("rating");
        String userContent = req.getParameter("userContent");
        String foodName = req.getParameter("foodName");
        String deleveryProblem = req.getParameter("deleveryProblem");  // deleveryProblem 값 추가

        // 리뷰 이미지 파일 처리
        Part filePart = req.getPart("review_image");
        String fileName = getFileName(filePart);
        String fileSavePath = getServletContext().getRealPath("/upload") + File.separator + fileName;
        filePart.write(fileSavePath);

        ReviewWriterVo vo = new ReviewWriterVo();
        vo.setStoreName(storeName);
        vo.setRating(rating);
        vo.setUserContent(userContent);
        vo.setReviewImg(fileName);  // 저장된 파일 이름 설정
        vo.setFoodName(foodName);
        vo.setDeleveryProblem(deleveryProblem);  // deleveryProblem 설정
        
        MemberService ms = new MemberService();
        int result = 0;
        try {
            result = ms.reviewStatus(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == 1) {
            req.setAttribute("message", "리뷰가 성공적으로 저장되었습니다.");
            req.setAttribute("deleveryProblem", deleveryProblem);  // deleveryProblem 값 전달
            req.getRequestDispatcher("/WEB-INF/views/member/review2.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "리뷰 저장에 실패했습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
