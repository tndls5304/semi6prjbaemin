package com.kh.baemin.store.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.vo.StoreInforVo;

public class StoreAdmitDao {
	
	public int insert(SqlSession ss, StoreInforVo vo) throws Exception {
		return ss.insert("StoreAdmitMapper.insert" , vo);
	}//method

}
