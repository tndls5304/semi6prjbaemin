package com.kh.baemin.member.dao;

import com.kh.baemin.member.vo.MemberOrderVo;
import com.kh.baemin.member.vo.MemberVo;
import org.apache.ibatis.session.SqlSession;

public class MemberOrderDao {
    public Integer getTotalPrice(SqlSession ss, String memberNo) {
        return ss.selectOne("MemberOrderMapper.getTotalPrice", memberNo);
    }

    public MemberVo getMember(SqlSession ss, String memberNo) {
        return ss.selectOne("MemberOrderMapper.getMember", memberNo);
    }

    public void insertStatus(SqlSession ss, MemberOrderVo memberOrderVo) {
        ss.insert("MemberOrderMapper.insertStatus", memberOrderVo);
    }

    public void insertOrder(SqlSession ss, MemberOrderVo memberOrderVo) {
        ss.insert("MemberOrderMapper.insertOrder", memberOrderVo);
    }

    public void insertOrderDetail(SqlSession ss, MemberOrderVo memberOrderVo) {
        ss.insert("MemberOrderMapper.insertOrderDetail", memberOrderVo);
    }

}
