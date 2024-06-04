package com.kh.baemin.store.controller;

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

import com.kh.baemin.store.service.StoreMenuService;
import com.kh.baemin.store.vo.FoodInforVo;

@MultipartConfig(maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100, fileSizeThreshold = 1024 * 1024
		* 10)

@WebServlet("/store/menu_add")
public class StoreMenuAddController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();

			// 세션에서 가게넘버 빼자
			String storeNo = (String) session.getAttribute("storeNo");
			
			

			// TODO ui구현

			String categyryNo = req.getParameter("categyryNo");
			String name = req.getParameter("name");
			String price = req.getParameter("price");
			Part foodImg = req.getPart("foodImg");

			String viewYn = req.getParameter("view_yn");

			String changeName = "";

			if (foodImg.getSize() > 0) {
				// 파일을 서버에 저장하기
				String originFileName = foodImg.getSubmittedFileName();
				InputStream is = foodImg.getInputStream();

				// 조원끼리 사진저장하는 파일경로가 다르니까 이거 써주기 webapp 하위 resources부터는 맞춰주세요:)
				ServletContext context = getServletContext();
				String path = context.getRealPath("/resources/upload/"); // 웹 애플리케이션의 루트 경로를 동적으로 가져오기
				System.out.println("context: " + context);
				System.out.println("path:" + path);

				String random = UUID.randomUUID().toString();
				String ext = originFileName.substring(originFileName.lastIndexOf("."));
				changeName = System.currentTimeMillis() + "_" + random + ext;

				FileOutputStream fos = new FileOutputStream(path + changeName);

				// 1024글자 담아줄 수있는 사이즈 버퍼바구니
				byte[] buf = new byte[1024];
				int size = 0;
				// 내가읽은데이터가 버퍼에 들어감
				// 바이트배열을 전달받으면 리턴값이 바이트 토탈 넘버(내가 몇글자읽었는지)를 준다
				while ((size = is.read(buf)) != -1) {
					fos.write(buf, 0, size);
				}
				is.close();
				fos.close();
			}
			System.out.println("뭉치는거까지 왔다");
			FoodInforVo vo = new FoodInforVo();
			vo.setStoreNo(storeNo);
			vo.setName(name);
			vo.setPrice(price);
			vo.setFoodImg(changeName);
			vo.setViewYn(viewYn);
			vo.setFoodMenuCategoryNo(categyryNo);

			StoreMenuService service = new StoreMenuService();
			int result = service.menuAdd(vo);

			if (result != 1) {
				throw new Exception("메뉴 추가 실패!");
			}

			resp.sendRedirect("/baemin/store/category_list");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}

	}
}
