package com.kh.baemin.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.baemin.member.service.MemberService;
import com.kh.baemin.member.vo.ReviewWriterVo;

@WebServlet("/member/reviewList")
public class MemberReviewListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/member/reviewList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {   // Retrieve parameters from the request
        String memberNickName = req.getParameter("memberNickName");
        String memberImg = req.getParameter("memberImg");
        String rating = req.getParameter("rating");                
        String memberContent = req.getParameter("memberContent");                
        String reviewImg = req.getParameter("reviewImg");                
        String foodName = req.getParameter("foodName");                    
        String deliveryProblem = req.getParameter("deliveryProblem");                        
        String ceoImg = req.getParameter("ceoImg");                
        String ceoContent = req.getParameter("ceoContent");            

    
        ReviewWriterVo vo = new ReviewWriterVo();
        vo.setMemberNickName(memberNickName);
        vo.setMemberImg(memberImg);
        vo.setRating(rating);
        vo.setMemberContent(memberContent);
        vo.setReviewImg(reviewImg);
        vo.setFoodName(foodName);
        vo.setDeliveryProblem(deliveryProblem);
        vo.setCeoImg(ceoImg);
        vo.setCeoContent(ceoContent);

        // SERVICE
        MemberService ms = new MemberService();
        List<ReviewWriterVo> reviewVoList = ms.reviewList(vo);

    	// 결과
		System.out.println("voList : " + reviewVoList);
		req.setAttribute("voList", reviewVoList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
        
        } catch (Exception e) {
            e.printStackTrace();
        	req.setAttribute("errMsg", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
	}
	
        }

      