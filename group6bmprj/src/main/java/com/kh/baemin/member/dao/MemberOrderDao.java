package com.kh.baemin.member.dao;

import org.apache.ibatis.session.SqlSession;

public class MemberOrderDao {
    public Integer getTotalPrice(SqlSession ss, String memberNo) {
        return ss.selectOne("MemberOrderMapper.getTotalPrice", memberNo);
    }
}
