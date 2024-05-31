package com.kh.baemin.store.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.vo.StoreAdmitVo;

public class StoreAdmitDao {
	
	public int updateStoreInfor(SqlSession ss, StoreAdmitVo vo) throws Exception {
		return ss.update("StoreAdmitMapper.update" , vo);
	}//method

	public int insertStoreInfor(SqlSession ss, StoreAdmitVo vo) {
		return ss.insert("StoreAdmitMapper.insert, vo");
	}
	
	

	
	
}
