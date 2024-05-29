package com.kh.baemin.admin.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.admin.dao.AdminManageUserDao;
import com.kh.baemin.member.vo.MemberVo;

public class AdminManageUserService {
	
	private final AdminManageUserDao dao;
	public AdminManageUserService() {
		this.dao=new AdminManageUserDao();
	}
	
	public List<MemberVo> getUserListById(String userId) {
		SqlSession ss=getSqlSession();
		List<MemberVo>voList=dao.getUserListById(ss,userId);
		ss.close();
		
		return voList;
		
	}

}
