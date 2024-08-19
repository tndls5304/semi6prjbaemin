package com.kh.baemin.store.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.dao.StoreOwnerDao;
import com.kh.baemin.store.vo.StoreOwnerVo;;
public class StoreOwnerService {

	private StoreOwnerDao dao;
	
	public StoreOwnerService() {
		this.dao=new StoreOwnerDao();
	}
	
	public int join(StoreOwnerVo vo) throws Exception {
		// --------------비지니스 로직 유효성검사
		if(vo.getId().length()<4) {
			throw new Exception("아이디가 너무 짧습니다 4글자이상으로 써주세요");
		}
		if(vo.getId().length()>10) {
			throw new Exception("아이디가 너무 길어요 10글자이하로 써주세요");
		}

		if(vo.getPwd().length()<4) {
			throw new Exception("비밀번호가 너무 짧습니다 4글자이상으로 써주세요");
		}
		if(vo.getPwd().length()>10) {
			throw new Exception("비밀번호가 너무 길어요 10글자이하로 써주세요");
		}
		if(vo.getPwd().equals(vo.getPwdCheck())) {
			throw new Exception("비밀번호와 비밀번호 확인 데이터가 일치하지 않습니다");	
		}
		
		  if (vo.getName() == null || vo.getName().trim().isEmpty()) {
		        throw new Exception("이름은 스페이스바 제외 1글자 이상으로 써주세요 .");
		    }
		if(vo.getName().length()>10) {
			throw new Exception("이름은 10글자이하로 써주세요");
		}
		if(vo.getPhone().length()!=11) {
			throw new Exception("휴대폰번호는 숫자만 11자 써주세요 ");
		}
		if(vo.getPhone().length()!=11) {
			throw new Exception("사업자 등록증은 숫자로만 11글자 써주세요 ");
		}
		if(vo.getProfile()==null) {
			throw new Exception("가게의 특성이 돋보이는 프로필 사진을 업로드 해주세요");
		}
		
		SqlSession ss=getSqlSession();
		int result=dao.join(ss,vo);
		
		if(result==1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		
		return result;
}

	public boolean checkIdDup(String id) throws IOException {
	
		SqlSession ss=getSqlSession();
		int result=dao.checkIdDup(ss,id);
		
		ss.close();
	
		return result==0;
	}

	public StoreOwnerVo login(StoreOwnerVo vo) throws Exception {
		
		SqlSession ss=getSqlSession();
		StoreOwnerVo loginStoreOwnerVo=dao.login(ss,vo);
		ss.close();
		return  loginStoreOwnerVo;
	}


}
