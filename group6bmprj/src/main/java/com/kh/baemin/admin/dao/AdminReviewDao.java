package com.kh.baemin.admin.dao;

import com.kh.baemin.admin.vo.AdminReviewVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AdminReviewDao {
    public List<AdminReviewVO> getReviewList(SqlSession ss, AdminReviewVO adminReviewVO) {
        return ss.selectList("AdminReviewMapper.getReviewList", adminReviewVO);
    }

    public void deleteReview(SqlSession ss, String reviewNo) {
        ss.delete("AdminReviewMapper.deleteReview", reviewNo);
    }

    public AdminReviewVO getReviewDetail(SqlSession ss, String reviewNo) {
        return ss.selectOne("AdminReviewMapper.getReviewDetail", reviewNo);
    }
}
