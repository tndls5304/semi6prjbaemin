package com.kh.baemin.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.vo.CartVo;

public class MemberAddCartDao {

	public int addCart(SqlSession ss,CartVo cartVo) {
		
		return ss.insert("cartMapper.addCart", cartVo);
	}

}
