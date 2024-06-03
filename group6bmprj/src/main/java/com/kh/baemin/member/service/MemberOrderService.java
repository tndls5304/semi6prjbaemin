package com.kh.baemin.member.service;

import com.kh.baemin.member.dao.MemberOrderDao;
import com.kh.baemin.member.vo.MemberOrderVo;
import com.kh.baemin.member.vo.MemberVo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

public class MemberOrderService {
    private final MemberOrderDao memberOrderDao = new MemberOrderDao();

    public Integer getTotalPrice(String memberNo) throws IOException {
        try(SqlSession ss = getSqlSession()) {
            return memberOrderDao.getTotalPrice(ss, memberNo);
        }

    }

    public MemberVo getMember(String no) {
        try(SqlSession ss = getSqlSession()) {
            return memberOrderDao.getMember(ss, no);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertOrder(MemberOrderVo memberOrderVo) throws IOException {
        try(SqlSession ss = getSqlSession()) {
            try {
                // 주문 상태
                memberOrderDao.insertStatus(ss, memberOrderVo);
                // 주문
                memberOrderDao.insertOrder(ss, memberOrderVo);
                // 주문 상세
                memberOrderDao.insertOrderDetail(ss, memberOrderVo);
                ss.commit();
            } catch (Exception e) {
                e.printStackTrace();
                ss.rollback();

            }
        }
    }
}
