package com.kh.baemin.member.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.dao.MemberGetInforDao;
import com.kh.baemin.member.vo.MemberVo;

public class MemberGetInforService {

	private final MemberGetInforDao dao;

	public MemberGetInforService() {
		this.dao = new MemberGetInforDao();
	}

	public int changeAddress(MemberVo vo) throws Exception {
		//비지니스로직
		
		if(vo.getAddress()==null|| vo.getAddress().isEmpty()) {
		throw new Exception("주소가입력되지 않았습니다!");
		}
		
		if(vo.getAddressDetail()==null||vo.getAddressDetail().isEmpty()) {
		throw new Exception("상세주소가입력되지 않았습니다!");
		}
		
		
		SqlSession ss = getSqlSession();
		int result=dao.changeAddress(ss,vo);
		
		if(result==1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}

}
