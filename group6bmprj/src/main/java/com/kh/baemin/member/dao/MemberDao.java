package com.kh.baemin.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.vo.MemberVo;

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








	}
