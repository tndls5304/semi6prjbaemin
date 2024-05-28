package com.kh.baemin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.vo.MemberVo;
import com.kh.baemin.member.vo.ReviewWriterVo;

public class MemberDao {

	
	public int join(SqlSession ss, MemberVo vo) throws Exception {
		
		return ss.insert("MemberMapper.join" , vo);
	}

	
	


	public MemberVo login(SqlSession ss, MemberVo vo) {
		  return ss.selectOne("MemberMapper.login", vo);
	}



	public boolean checkIdDup(SqlSession sqlSession, String id) {
	    Integer count = sqlSession.selectOne("MemberMapper.idCheck", id);
	    return count != null && count > 0;
	}





	public int reviewStatus(SqlSession ss, ReviewWriterVo vo) {
		return ss.insert("memberMapper.reviewStatus" , vo);
	}

	public int reviewContent(SqlSession ss, ReviewWriterVo vo) {
		return ss.insert("memberMapper.reviewContent" , vo);
	}





	 public List<ReviewWriterVo> selectReviewList(SqlSession ss) {
	        return ss.selectList("memberMapper.selectReviewList");
	 }

	        public int insertReview(SqlSession ss, ReviewWriterVo vo) {
	            return ss.insert("memberMapper.insertReview", vo);
	        

	       
	    }



	
	}







	}
