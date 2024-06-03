package com.kh.baemin.member.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
   //1. 별점 문제 선택항목 조회한다 
    	MemberService service =new MemberService();
    	List<ReviewWriterVo> ratingList = service.selectRating();
    	
    	//조회한 별점을 배열 화면 뿌리기 위하여 어트리뷰트에 담는다 
    	req.setAttribute("ratingList", ratingList);

        req.getRequestDispatcher("/WEB-INF/views/member/reviewContentWriter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();
        System.out.println(loginMemberVo);
       
        
    
        String orderNo = req.getParameter("orderNo");
        String deliveryProblem = req.getParameter("deliveryProblem");
        System.out.println("배달문제선택 번호 값 화면 받아 온지? #@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+ deliveryProblem);

        String rating = req.getParameter("rating");
        String memberContent = req.getParameter("memberContent");
       
        Part reviewImgPart = req.getPart("reviewImg");
        String reviewImg = ""; 

       
        if (reviewImgPart.getSize() > 0) {
     
            String originFileName = reviewImgPart.getSubmittedFileName(); 
            InputStream is = reviewImgPart.getInputStream(); 


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

        int ratingValue = Integer.parseInt(rating);
        ReviewWriterVo vo = new ReviewWriterVo();
        vo.setOrderNo(orderNo);
        vo.setRating(rating);
        vo.setMemberContent(memberContent);
        vo.setReviewImg(reviewImg);  // 저장된 파일 이름 설정
        vo.setDeliveryProblem(deliveryProblem);  // deliveryProblem 설정
        
        System.out.println("############################ vo" + vo);

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
