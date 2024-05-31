package com.kh.baemin.store.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.dao.StoreAdmitDao;
import com.kh.baemin.store.vo.StoreAdmitVo;

public class StoreAdmitService {
	
	private final StoreAdmitDao dao;
	
	public StoreAdmitService() {
		dao = new StoreAdmitDao();
	}
	
		//허가 상태 조회
//		public List<StoreInforVo> selectStoreInForList() throws Exception {
			// 비즈니스 로직
			
			// DAO 호출
//			SqlSession ss = getSqlSession();
//			List<StoreInforVo> voList = dao.selectBoardList(ss , siv);
//			
//			ss.close();
//			
//			return voList;
//		}
		
		//허가 신청후 수정
		public int writeStoreInfor(StoreAdmitVo vo) throws Exception {
			
			// 비즈니스 로직
			
			// DAO 호출
			SqlSession ss = getSqlSession();
			int result = dao.updateStoreInfor(ss,  vo);
			int result2 = dao.insertStoreInfor(ss, vo);
			
			
			if(result == 1 && result2 == 1) {
				ss.commit();
			}else {
				ss.rollback();
			}
			ss.close();
			
			return result;
		}



}
