package com.kh.baemin.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.vo.MemberVo;

public class MemberGetInforDao {

	public int changeAddress(SqlSession ss, MemberVo vo) {
	
		return ss.update("MemberMapper.changeAddress",vo);
	}

}
