package com.kh.baemin.member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
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
        String memberContent = req.getParameter("memberContent");
        String deliveryProblem = (String) session.getAttribute("deliveryProblem");

        // 리뷰 이미지 파일 처리
        Part reviewImgPart = req.getPart("reviewImg");
        String reviewImg = ""; // 파일 이름 변경을 위한 변수 초기화

        // 파일이 업로드된 경우
        if (reviewImgPart.getSize() > 0) {
            // 파일을 서버에 저장하기
            String originFileName = reviewImgPart.getSubmittedFileName(); // 원본 파일 이름을 가져옴
            InputStream is = reviewImgPart.getInputStream(); // 파일의 입력 스트림을 가져옴

            
            ServletContext context = getServletContext();
            String path = context.getRealPath("/resources/upload/"); 
            // 파일 저장 경로 설정
  
            File dir = new File(path); // 파일 저장 경로의 디렉토리 객체 생성
            if (!dir.exists()) {
                dir.mkdirs(); // 디렉토리가 존재하지 않으면 생성
            }

            String random = UUID.randomUUID().toString(); // 고유한 파일 이름 생성을 위한 랜덤 문자열 생성
            String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 파일 확장자를 가져옴
            reviewImg = System.currentTimeMillis() + "_" + random + ext; // 현재 시간과 랜덤 문자열을 조합하여 고유한 파일 이름 생성
            FileOutputStream fos = new FileOutputStream(new File(dir, reviewImg)); // 파일 저장을 위한 출력 스트림 생성

            byte[] buf = new byte[1024]; // 파일을 읽고 쓰기 위한 버퍼 생성
            int size = 0;
            while ((size = is.read(buf)) != -1) { // 입력 스트림에서 데이터를 읽어 버퍼에 저장
                fos.write(buf, 0, size); // 버퍼에 있는 데이터를 출력 스트림에 씀
            }

            is.close(); // 입력 스트림 닫기
            fos.close(); // 출력 스트림 닫기
        }

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
            req.setAttribute("rating", rating);
            req.getRequestDispatcher("/WEB-INF/views/member/reviewList.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "리뷰 저장에 실패했습니다.");
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }
}
