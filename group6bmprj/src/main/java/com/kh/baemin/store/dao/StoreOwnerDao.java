package com.kh.baemin.store.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.vo.StoreOwnerVo;

public class StoreOwnerDao {

	public int join(SqlSession ss, StoreOwnerVo vo) {
	
		return ss.insert("storeMapper.joinStoreOwner",vo);
	}

	public int checkIdDup(SqlSession ss, String id) {
	return ss.selectOne("storeMapper.joinStoreOwnerCheckIdDup",id);
		 
	}

	public StoreOwnerVo login(SqlSession ss, StoreOwnerVo vo) {
	
		return ss.selectOne("storeMapper.loginStoreOwner",vo);
	}

}
