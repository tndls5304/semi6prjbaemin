package com.kh.baemin.store.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.baemin.store.service.StoreOwnerService;
import com.kh.baemin.store.vo.StoreOwnerVo;

@MultipartConfig(
		maxFileSize = 1024*1024*10 ,
		maxRequestSize = 1024*1024*50 ,
		fileSizeThreshold = 1024*1024*10
)
@WebServlet("/store/store_owner_join")
public class StoreOwnerJoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/store/owner_join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	try {
		
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String pwdCheck=req.getParameter("pwdCheck");
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String companyResitrationNumber=req.getParameter("companyResitrationNumber");
		Part profile=req.getPart("profile");
		
		
		String changeName="";
		if(profile.getSize()>0) {
			// 파일을 서버에 저장하기
			String originFileName=profile.getSubmittedFileName();
			InputStream is=profile.getInputStream();
			
//			String path="D:\\dev\\servletWorkspace\\baemin\\src\\main\\webapp\\resources\\upload\\";
			
			// 조원끼리 사진저장하는 파일경로가 다르니까 이거 써주기 webapp 하위 resources부터는 맞춰주세요:)
            ServletContext context = getServletContext();
            String path = context.getRealPath("/resources/upload/");  // 웹 애플리케이션의 루트 경로를 동적으로 가져오기
            System.out.println("context: " + context);
            System.out.println("path:" + path);
            
			String random=UUID.randomUUID().toString();
			String ext=originFileName.substring(originFileName.lastIndexOf("."));
			changeName=System.currentTimeMillis()+"_"+random+ext;
			
			FileOutputStream fos=new FileOutputStream(path+changeName);
			
			// 1024글자 담아줄 수있는 사이즈 버퍼바구니
			byte[]buf=new byte[1024];
			int size=0;
			// 내가읽은데이터가 버퍼에 들어감
			// 바이트배열을 전달받으면 리턴값이 바이트 토탈 넘버(내가 몇글자읽었는지)를 준다
			while((size=is.read(buf))!=-1) {
				fos.write(buf,0,size);
			}
			is.close();
			fos.close();

		}
		
		
		StoreOwnerVo vo=new StoreOwnerVo();
		
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setPwd(pwdCheck);
		vo.setName(name);
		vo.setPhone(phone);
		vo.setCompanyResitrationNumber(companyResitrationNumber);
		vo.setProfile(changeName);
		System.out.println(changeName);
		//서비스 호출
		StoreOwnerService ss= new StoreOwnerService();
		int result=ss.join(vo);
		
		//결과처리
		if(result==1) {
			req.setAttribute("resultMsg", "환영해요! 회원가입 성공했습니다 입점신청도 서둘러주세요! ");
		}else {
			req.setAttribute("resultMsg", "회원가입실패!");
		}
		
	     // 현재 페이지로 포워드
        req.getRequestDispatcher("/WEB-INF/views/store/owner_join.jsp").forward(req, resp);
		
	}catch(Exception e) {
		e.printStackTrace();
		req.setAttribute("errMsg", e.getMessage());
		req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
	}
		
	}
	
}
