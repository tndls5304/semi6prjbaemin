package com.kh.baemin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.vo.SearchForStoreVo;
import com.kh.baemin.store.vo.StoreInforVo;

public class MemberSearchForStoreDao {

	public List<StoreInforVo> searchForStoreByBasic(SqlSession ss, SearchForStoreVo searchForStoreVo) {
		
		return ss.selectList("memberSearchForStoreMapper.searchForStoreByBasic",searchForStoreVo);
	}

}
