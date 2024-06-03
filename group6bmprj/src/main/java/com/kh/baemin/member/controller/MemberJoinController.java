package com.kh.baemin.member.controller;

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
import javax.servlet.http.Part;

import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.MemberVo;

@WebServlet("/member/join")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,  // 1 MB
    maxFileSize = 1024 * 1024 * 10,       // 10 MB
    maxRequestSize = 1024 * 1024 * 50     // 50 MB
)
public class MemberJoinController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("test");
        req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");
            String name = req.getParameter("name");
            String nick = req.getParameter("nick");
            String phone = req.getParameter("phone");
            String address= req.getParameter("address");
            String addressDetail = req.getParameter("addressDetail");
            String generation = req.getParameter("generation");
            String gender = req.getParameter("gender");
            Part memberImg = req.getPart("f"); // "profile" 파라미터로 업로드된 파일을 Part 객체로 받음

            String changeName = ""; // 파일 이름 변경을 위한 변수 초기화

            // 파일이 업로드된 경우
            if (memberImg.getSize() > 0) {
                // 파일을 서버에 저장하기
                String originFileName = memberImg.getSubmittedFileName(); // 원본 파일 이름을 가져옴
                InputStream is = memberImg.getInputStream(); // 파일의 입력 스트림을 가져옴
                
                ServletContext context = getServletContext();
                String path = context.getRealPath("/baemin/resources/upload/"); 
                
                java.io.File dir = new java.io.File(path); // 파일 저장 경로의 디렉토리 객체 생성
                if (!dir.exists()) {
                    dir.mkdirs(); // 디렉토리가 존재하지 않으면 생성
                }
                
                String random = UUID.randomUUID().toString(); // 고유한 파일 이름 생성을 위한 랜덤 문자열 생성
                String ext = originFileName.substring(originFileName.lastIndexOf(".")); // 파일 확장자를 가져옴
                changeName = System.currentTimeMillis() + "_" + random + ext; // 현재 시간과 랜덤 문자열을 조합하여 고유한 파일 이름 생성
                FileOutputStream fos = new FileOutputStream(path + changeName); // 파일 저장을 위한 출력 스트림 생성
                System.out.println(path + changeName);
                byte[] buf = new byte[1024]; // 파일을 읽고 쓰기 위한 버퍼 생성
                int size = 0;
                while ((size = is.read(buf)) != -1) { // 입력 스트림에서 데이터를 읽어 버퍼에 저장
                    fos.write(buf, 0, size); // 버퍼에 있는 데이터를 출력 스트림에 씀
                }

                is.close(); // 입력 스트림 닫기
                fos.close(); // 출력 스트림 닫기
            }


            MemberVo vo = new MemberVo();
            vo.setId(id);
     
            vo.setPwd(pwd);
            vo.setName(name);
            vo.setNick(nick);
            vo.setPhone(phone);
            vo.setAddress(address);
            vo.setAddressDetail(addressDetail);
            vo.setGeneration(generation);
            vo.setGender(gender);
            vo.setMemberImg(changeName);

            MemberService ms = new MemberService();
            
            int result = ms.join(vo);

            if (result == 1) {
            	
                req.setAttribute("resultMsg", "회원가입 성공 !!!");
                resp.sendRedirect("/baemin/member/login");
            } else {
                req.setAttribute("resultMsg", "회원가입 실패 ...");
              resp.sendRedirect("/baemin/member/join");
            }
        } catch (Exception e) {
            System.out.println("[ERROR-M0001] " + e.getMessage());
            e.printStackTrace();
            req.setAttribute("errMsg", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }
}


