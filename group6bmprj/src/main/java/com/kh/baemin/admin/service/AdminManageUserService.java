package com.kh.baemin.admin.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.admin.dao.AdminManageUserDao;
import com.kh.baemin.member.vo.MemberVo;

public class AdminManageUserService {
	
	private final AdminManageUserDao dao;
	public AdminManageUserService() {
		this.dao=new AdminManageUserDao();
	}
	
	public MemberVo adminGetUserById(String userId) throws Exception {
		SqlSession ss=getSqlSession();
		MemberVo memberVo=dao.adminGetUserById(ss,userId);
		System.out.println("서비스vo는 ?"+memberVo);
		ss.close();
		
		return memberVo;
		
	}

	public MemberVo adminGetInactiveUserById(String userId) throws Exception {
		SqlSession ss=getSqlSession();
		MemberVo memberVo=dao.adminGetInactiveUserById(ss,userId);
		ss.close();
		return memberVo;
	}

	public int adminDeleteUser(String memberId) throws Exception {
		SqlSession ss=getSqlSession();
		int result=dao.adminDeleteUser(ss,memberId);
		if(result==1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

}
