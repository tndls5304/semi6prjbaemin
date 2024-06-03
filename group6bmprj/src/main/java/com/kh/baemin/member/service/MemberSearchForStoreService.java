package com.kh.baemin.member.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.dao.MemberSearchForStoreDao;
import com.kh.baemin.member.vo.MemberViewStoreInforVo;
import com.kh.baemin.member.vo.OneStoreReviewVo;
import com.kh.baemin.member.vo.SearchForStoreVo;
import com.kh.baemin.member.vo.StoreOfFoodCategoryVo;
import com.kh.baemin.store.vo.StoreInforVo;

public class MemberSearchForStoreService {

	private final MemberSearchForStoreDao dao;
	
	public MemberSearchForStoreService() {
		this.dao=new MemberSearchForStoreDao();
	}
	
	public List<StoreInforVo> searchForStoreByBasic(SearchForStoreVo searchForStoreVo) throws Exception {
		
		SqlSession ss=getSqlSession();
		List <StoreInforVo> storeInforVoList=dao.searchForStoreByBasic(ss,searchForStoreVo);
		
		if(storeInforVoList!=null) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return storeInforVoList;
	}

	public MemberViewStoreInforVo memberViewStoreInfor(String storeNo) throws Exception {
		SqlSession ss=getSqlSession();
		MemberViewStoreInforVo memberViewStoreInforVo=dao.memberViewStoreInfor(ss,storeNo);
		
		if(memberViewStoreInforVo!=null) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		System.out.println("유저가 가게를 클릭해서 가게 정보를 디비에서 받아왔을까? 여긴 시비스클래스임"+memberViewStoreInforVo);
		return memberViewStoreInforVo;
	}

	public List<StoreOfFoodCategoryVo> memberViewStoreFoodMenu(String storeNo) throws Exception {
		SqlSession ss=getSqlSession();
	
		List <StoreOfFoodCategoryVo>storeOfFoodCategoryVoList=dao.memberViewStoreFoodMenu(ss,storeNo);
		
		
		if(storeOfFoodCategoryVoList!=null) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return storeOfFoodCategoryVoList;
		
	
	}

	public List<OneStoreReviewVo> memberViewReview(String storeNo) throws Exception {
		SqlSession ss=getSqlSession();
		
		 List<OneStoreReviewVo> oneStoreReviewVoList=dao.memberViewReview(ss,storeNo);
		return oneStoreReviewVoList;
	}

	

}
