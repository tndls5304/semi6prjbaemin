package com.kh.baemin.store.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.dao.StoreAdmitDao;
import com.kh.baemin.store.vo.StoreInforVo;

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
		public int insert(StoreInforVo vo, List<StoreInforVoList> storeInforVoList) throws Exception {
			
			// 비즈니스 로직
			
			// DAO 호출
			SqlSession ss = getSqlSession();
			int result = dao.insert(ss,  vo);

			int attResult = 1;
			if(attVoList.size() > 0) {
				attResult = dao.insertBoardAttachment(ss , attVoList);
			}
			
			if(result * attResult >= 1) {
				ss.commit();
			}else {
				ss.rollback();
			}
			ss.close();
			
			return result * attResult;
		}

}
