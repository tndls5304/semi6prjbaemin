package com.kh.baemin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.vo.MemberVo;
import com.kh.baemin.member.vo.ReviewWriterVo;
import com.kh.baemin.member.vo.StoreOrderVo;

public class MemberDao {

	public int join(SqlSession ss, MemberVo vo) throws Exception {

		return ss.insert("MemberMapper.join", vo);
	}

	public MemberVo login(SqlSession ss, MemberVo vo) {
		return ss.selectOne("MemberMapper.login", vo);
	}

	public boolean checkIdDup(SqlSession sqlSession, String id) {
		Integer count = sqlSession.selectOne("MemberMapper.idCheck", id);
		return count != null && count > 0;
	}

	public int reviewStatus(SqlSession ss, ReviewWriterVo vo) {
		return ss.insert("MemberMapper.reviewStatus", vo);
	}

	public int reviewContent(SqlSession ss, ReviewWriterVo vo) {
		return ss.insert("MemberMapper.reviewContent", vo);
	}

	public List<ReviewWriterVo> selectReviewList(SqlSession ss) {
		return ss.selectList("MemberMapper.selectReviewList");
	}

	public int insertReview(SqlSession ss, ReviewWriterVo vo) {
		return ss.insert("MemberMapper.insertReview", vo);

	}



	public int MemberInfo(SqlSession ss, MemberVo vo) {
		return ss.selectOne("MemberMapper.info", vo);
	}

	 public List<StoreOrderVo> storeOrderList(SqlSession ss, StoreOrderVo vo) {
	        return ss.selectList("MemberMapper.storeOrderList", vo);
	    }

	
	
}
