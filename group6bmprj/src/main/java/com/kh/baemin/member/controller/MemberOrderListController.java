package com.kh.baemin.member.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.MemberVo;
import com.kh.baemin.member.vo.StoreOrderVo;

@WebServlet("/member/orderList")
public class MemberOrderListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
            System.out.println(loginMemberVo);

            if (loginMemberVo == null) {
                System.out.println("로그인 필요");
                resp.sendRedirect("/baemin/member/login");
                return;
            }

            String storeOrderDate = req.getParameter("orderDate");
            String deliveryStatus = req.getParameter("deliveryStatus");
            String storeImg = req.getParameter("storeImg");
            String storeFood = req.getParameter("storeFood");
            String storeName = req.getParameter("storeName");
            String storeFoodPriceStr = req.getParameter("storeFoodPrice");

            int storeFoodPrice = 0;
            if (storeFoodPriceStr != null && !storeFoodPriceStr.isEmpty()) {
                try {
                    storeFoodPrice = Integer.parseInt(storeFoodPriceStr);
                } catch (NumberFormatException e) {
                    System.out.println("숫자 형식 오류: " + storeFoodPriceStr);
                    // 숫자 변환에 실패할 경우 기본 값으로 유지하거나 에러 페이지로 리다이렉트 가능
                    resp.sendRedirect("/baemin/error");
                    return;
                }
            }

            StoreOrderVo vo = new StoreOrderVo();
            vo.setStoreOrderDate(storeOrderDate);
            vo.setDeliveryStatus(deliveryStatus);
            vo.setStoreImg(storeImg);
            vo.setStoreName(storeName);
            vo.setStoreFood(storeFood);
            vo.setStoreFoodPrice(storeFoodPrice);

            MemberService ms = new MemberService();
            List<StoreOrderVo> orderList = ms.getOrderListByUser(vo);
            req.setAttribute("orderList", orderList);
            req.getRequestDispatcher("/WEB-INF/views/member/orderList.jsp").forward(req, resp);

        } catch (Exception e) {
            req.setAttribute("errMsg", e.getMessage());
            e.printStackTrace();
            System.out.println(e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
