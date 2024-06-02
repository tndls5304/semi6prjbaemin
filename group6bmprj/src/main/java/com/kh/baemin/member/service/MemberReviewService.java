package com.kh.baemin.member.service;

import com.kh.baemin.member.dao.MemberOrderDao;
import com.kh.baemin.member.dao.MemberReviewDao;
import com.kh.baemin.member.vo.MemberReviewVo;
import org.apache.ibatis.session.SqlSession;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import java.io.IOException;
import java.util.List;

public class MemberReviewService {

    private final MemberReviewDao memberReviewDao = new MemberReviewDao();
    private final MemberOrderDao memberOrderDao = new MemberOrderDao();

    public List<MemberReviewVo> getMyReviewList(String memberNo) throws IOException {
        try (SqlSession ss = getSqlSession()) {
            return memberReviewDao.getMyReviewList(ss, memberNo);
        }
    }

}




