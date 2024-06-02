package com.kh.baemin.member.service;

import com.kh.baemin.member.dao.MemberOrderDao;
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
}
