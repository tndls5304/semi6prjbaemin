package com.kh.baemin.member.service;
import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.member.dao.MemberDao;
import com.kh.baemin.member.vo.MemberVo;
import com.kh.baemin.member.vo.ReviewWriterVo;
import com.kh.baemin.member.vo.StoreOrderVo;
public class MemberService {
private MemberDao dao;
	
	public MemberService() {
		dao = new MemberDao();
	}

public int join(MemberVo vo) throws Exception {
    // 회원 가입 처리 메서드
   
   

    // 아이디 길이 검사 (4자 이상 10자 이하)
    if (vo.getId().length() < 4 || vo.getId().length() > 10) {
       System.out.println("1");
        throw new Exception("아이디는 4~10자여야 합니다. ");
       
    }

    // 비밀번호 길이 검사 (4자 이상 10자 이하)
    if (vo.getPwd().length() < 4 || vo.getPwd().length() > 10) {
       
        throw new Exception("비번은 4~10자여야 합니다. ");
    }
	//비밀번호 일치여부 검사
	if(!vo.getPwd().equals(vo.getPwd())) {
		throw new Exception("비밀번호가 일치하지 않습니다.");
	}
    
    // 이름 길이 검사 (1자 이상 10자 이하)
    if (vo.getName().length() <1|| vo.getName().length()>10) {
    System.out.println("name" + vo.getName());
        throw new Exception("이름은 1~10자여야 합니다.");
    }

    // 닉네임 길이 검사 (1자 이상 10자 이하)
    if (vo.getNick().length() < 1 || vo.getNick().length() > 10) {
        
        throw new Exception("닉네임은 1~10자여야 합니다.");
    }

   
    if (vo.getPhone().length() != 11) {
       
        throw new Exception("전화번호는 11자여야 합니다.");
    }


    if (vo.getAddress().length() < 10 || vo.getAddress().length() > 20) {
       
        throw new Exception("주소는 10~20자여야 합니다.");
    }

  
    if (vo.getAddressDetail().length() < 10 || vo.getAddressDetail().length() > 20) {
    
        throw new Exception("상세주소는 10~20자여야 합니다.");
    }

    // 세대 선택 유효성 검사
    if (vo.getGeneration() == null || vo.getGeneration().isEmpty()) {
      
        throw new Exception("세대를 선택해주세요.");
    }

    // 성별 선택 유효성 검사
    if (vo.getGender() == null || vo.getGender().isEmpty()) {
     
        throw new Exception("성별을 선택해주세요.");
    }

    // 유저 사진 업로드 유효성 검사
    if (vo.getMemberImg() == null || vo.getMemberImg().isEmpty()) {
      
        throw new Exception("유저 사진을 업로드해주세요.");
    }
//	- DAO호출
	SqlSession ss = getSqlSession();
	int result = dao.join(ss, vo);
	
	if(result == 1) {
		ss.commit();
		
	}else {
		ss.rollback();
	}
	
	
	return result;
}

public MemberVo login(MemberVo vo) {
    SqlSession sqlSession = null;
    MemberVo loginMemberVo = null;

    try {
        sqlSession = getSqlSession();
        MemberDao dao = new MemberDao();
        loginMemberVo = dao.login(sqlSession, vo);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
System.out.println("디비에서입력받아온 로그인멤버브이오는?"+loginMemberVo);
    return loginMemberVo;
}


public boolean checkIdDup(String id) throws Exception {
    // 비즈니스 로직

    SqlSession ss = getSqlSession();
    boolean isDuplicate = dao.checkIdDup(ss , id);

    ss.close();

    return !isDuplicate; // 중복되지 않았을 때 true를 반환하도록 논리를 반대로 처리합니다.
}


public int reviewStatus(ReviewWriterVo vo) throws Exception {
//	- DAO호출
	SqlSession ss = getSqlSession();
	int result = dao.reviewStatus(ss, vo);
	
	if(result == 1) {
		ss.commit();
		
	}else {
		ss.rollback();
	}
	
	
	return result;
}
public int reviewContent(ReviewWriterVo vo) throws Exception {
//	- DAO호출
	SqlSession ss = getSqlSession();
	int result = dao.reviewContent(ss, vo);
	
	if(result == 1) {
		ss.commit();
		
	}else {
		ss.rollback();
	}
	
	
	return result;
}


// 리뷰 리스트를 가져오는 메서드
public List<ReviewWriterVo> reviewList(ReviewWriterVo vo) throws Exception {
	
    SqlSession ss = getSqlSession();
    List<ReviewWriterVo> reviewList = dao.selectReviewList(ss);
    
    ss.close();
  
    return reviewList;

  
}

public MemberVo info(String no) throws IOException {
//	- DAO호출
	SqlSession ss = getSqlSession();
	MemberVo result = dao.MemberInfo(ss, no);
	ss.close();
	
	return result;
}


public List<StoreOrderVo> getOrderListByUser(String no)throws Exception {

    SqlSession ss = getSqlSession();
    List<StoreOrderVo> orderList =  dao.storeOrderList(ss , no);
    ss.close();
    System.out.println("회원정보 번호 :" +no);
    
    return orderList;
}



public int contentDeliveryProblem(ReviewWriterVo vo) throws Exception {
//	- DAO호출
	SqlSession ss = getSqlSession();
	int result = dao.contentDeliveryProblem(ss, vo);
	
	if(result == 1) {
		ss.commit();
		
	}else {
		ss.rollback();
	}
	
	
	return result;
}

public int updateAccount(MemberVo vo) throws Exception {
	System.out.println("디비 가기전 멤버 브이오"+vo);
//	- DAO호출
	SqlSession ss = getSqlSession();
	
	int result = dao.MemberAccount(ss, vo);
	
	if(result == 1) {
		ss.commit();
		
	}else {
		ss.rollback();
	} 
	return result;
}





	
}




