package com.kh.baemin.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.vo.MemberVo;

public class AdminManageUserDao {

	public MemberVo adminGetUserById(SqlSession ss, String userId) {
		System.out.println("Dao:"+userId);
		return ss.selectOne("adminManageUserMapper.adminGetUserById",userId);
	}

	public MemberVo adminGetInactiveUserById(SqlSession ss, String userId) {
	
		return  ss.selectOne("adminManageUserMapper.adminGetInactiveUserById",userId);
	}

	public int adminDeleteUser(SqlSession ss, String memberId) {
		
		return ss.update("adminManageUserMapper.adminDeleteUser", memberId);
	}

}
