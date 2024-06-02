package com.kh.baemin.admin.service;

import com.kh.baemin.admin.dao.AdminReviewDao;
import com.kh.baemin.admin.vo.AdminReviewVO;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

public class AdminReviewService {
    private final AdminReviewDao adminReviewDao = new AdminReviewDao();

    public List<AdminReviewVO> getReviewList(AdminReviewVO adminReviewVO) throws IOException {
        try(SqlSession ss = getSqlSession()) {
            return adminReviewDao.getReviewList(ss, adminReviewVO);
        }
    }

    public void deleteReview(String reviewNo) throws IOException {
        try(SqlSession ss = getSqlSession()) {
            try {
                adminReviewDao.deleteReview(ss, reviewNo);
                ss.commit();
            } catch (Exception e) {
                ss.rollback();
            }
        }
    }

    public AdminReviewVO getReviewDetail(String reviewNo) throws IOException {
        try(SqlSession ss = getSqlSession()) {
            return adminReviewDao.getReviewDetail(ss, reviewNo);
        }
    }
}
