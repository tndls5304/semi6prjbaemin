package com.kh.baemin.member.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.MemberVo;
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
        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        System.out.println(loginMemberVo);

        if (loginMemberVo == null) {
            System.out.println("로그인 필요");
            resp.sendRedirect("/baemin/member/login");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/views/member/reviewContentWriter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        System.out.println(loginMemberVo);

        if (loginMemberVo == null) {
            System.out.println("로그인 필요");
            resp.sendRedirect("/baemin/member/login");
            return;
        }

        String rating = req.getParameter("rating");
        String memberContent = req.getParameter("memberContent");  // 변수명을 소문자로 시작하도록 수정
        String deliveryProblem = (String) session.getAttribute("deliveryProblem");

        // 리뷰 이미지 파일 처리
        Part filePart = req.getPart("reviewImage");
        String reviewImg = getFileName(filePart);

        // 파일 저장 경로
        String fileSavePath = getServletContext().getRealPath("/upload") + File.separator + reviewImg;

        // 경로가 존재하지 않으면 생성
        File fileSaveDir = new File(fileSavePath).getParentFile();
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        filePart.write(fileSavePath);

        ReviewWriterVo vo = new ReviewWriterVo();
        vo.setRating(rating);
        vo.setMemberContent(memberContent);
        vo.setReviewImg(reviewImg);  // 저장된 파일 이름 설정
        vo.setDeliveryProblem(deliveryProblem);  // deliveryProblem 설정

        MemberService ms = new MemberService();
        int result = 0;
        try {
            result = ms.reviewContent(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == 1) {
            req.setAttribute("message", "리뷰가 성공적으로 저장되었습니다.");
            req.setAttribute("deliveryProblem", deliveryProblem);
            req.setAttribute("memberContent", memberContent);
            req.setAttribute("reviewImg", reviewImg);
            req.getRequestDispatcher("/WEB-INF/views/member/reviewList.jsp").forward(req, resp);
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
