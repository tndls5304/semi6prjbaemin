package com.kh.baemin.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.vo.MemberVo;

public class AdminManageUserDao {

	public List<MemberVo> getUserListById(SqlSession ss, String userId) {
		
		return select("admin");
	}

}
