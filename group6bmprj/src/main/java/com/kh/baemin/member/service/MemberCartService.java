package com.kh.baemin.member.service;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.db.SqlSessionTemplate;
import com.kh.baemin.member.dao.MemberAddCartDao;
import com.kh.baemin.member.vo.CartVo;

public class MemberCartService {

	private final MemberAddCartDao dao;

	public MemberCartService() {
		this.dao = new MemberAddCartDao();
	}

	public int addCart(CartVo cartVo) throws Exception {
		SqlSession ss=SqlSessionTemplate.getSqlSession();
		
		int result=dao.addCart(ss,cartVo);
		
		if(result==1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}

}
