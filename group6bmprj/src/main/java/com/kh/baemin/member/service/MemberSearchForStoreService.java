package com.kh.baemin.member.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.dao.MemberSearchForStoreDao;
import com.kh.baemin.member.vo.SearchForStoreVo;
import com.kh.baemin.store.vo.StoreInforVo;

public class MemberSearchForStoreService {

	private final MemberSearchForStoreDao dao;
	
	public MemberSearchForStoreService() {
		this.dao=new MemberSearchForStoreDao();
	}
	
	public List<StoreInforVo> searchForStoreByBasic(SearchForStoreVo searchForStoreVo) throws Exception {
		
		SqlSession ss=getSqlSession();
		List <StoreInforVo> storeInforVo=dao.searchForStoreByBasic(ss,searchForStoreVo);
		
		if(storeInforVo!=null) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return storeInforVo;
	}

}
