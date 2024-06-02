package com.kh.baemin.member.dao;

import com.kh.baemin.member.vo.MemberReviewVo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;



public class MemberReviewDao {

    public List<MemberReviewVo> getMyReviewList(SqlSession ss, String memberNo) {
        return ss.selectList("MemberReviewMapper.getMyReviewList", memberNo);
    }
}
