
package com.kh.baemin.store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.store.service.StoreOwnerService;
import com.kh.baemin.store.vo.StoreOwnerVo;
/**
 * 스토어 사장님 로그인
 * @author 이수인
 */
@WebServlet("/store/login")
public class StoreOwnerLoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/store/owner_login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");

			StoreOwnerVo vo = new StoreOwnerVo();
			vo.setId(id);
			vo.setPwd(pwd);
			StoreOwnerService ss = new StoreOwnerService();
			StoreOwnerVo loginStoreOwnerVo = ss.login(vo);

			HttpSession session = req.getSession();

			if (loginStoreOwnerVo == null) {
				session.setAttribute("resultMsg", "로그인실패 ㅠ ㅠ");
				req.getRequestDispatcher("/WEB-INF/views/store/owner_login.jsp").forward(req, resp); // 로그인 실패 시 로그인
																										// 페이지로 포워딩
			}
			session.setAttribute("loginStoreOwnerVo", loginStoreOwnerVo);
			session.setAttribute("resultMsg", "로그인성공 ! 입점신청을 서둘러 진행 해주세요!");
			resp.sendRedirect("/baemin/store/admit");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
}
