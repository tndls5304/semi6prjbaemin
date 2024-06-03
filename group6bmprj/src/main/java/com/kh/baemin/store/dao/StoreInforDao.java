package com.kh.baemin.store.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.vo.ClosedDayVo;
import com.kh.baemin.store.vo.StoreCategoryVo;
import com.kh.baemin.store.vo.StoreInforVo;

public class StoreInforDao {
    public List<StoreInforVo> getTop10StoreList(SqlSession ss) {
        return ss.selectList("StoreInforMapper.getTop10StoreList");
    }

    public List<StoreInforVo> getStoreInforList(SqlSession ss, String searchText) {
        return ss.selectList("StoreInforMapper.getStoreInforList", searchText);
    }

    public String getDeliveryZoneNoByLocalName(SqlSession ss, String name) {
        return ss.selectOne("StoreInforMapper.getDeliveryZoneNoByLocalName", name);

    }

    public void insertStoreInfor(SqlSession ss, StoreInforVo storeInforVo) {
        ss.insert("StoreInforMapper.insertStoreInfor", storeInforVo);
    }

    public void insertStoreZone(SqlSession ss, String no, String deliveryZoneNo) {
        ss.insert("StoreInforMapper.insertStoreZone", Map.of("storeNo", no, "zoneNo", deliveryZoneNo));
    }

    public StoreInforVo getStoreInfor(SqlSession ss, String no) {
        return ss.selectOne("StoreInforMapper.getStoreInfor", no);
    }

    public void updateStoreOwnerPhone(SqlSession ss, String storeNo, String storeOwnerPhone) {
        ss.update("StoreInforMapper.updateStoreOwnerPhone", Map.of("storeNo", storeNo, "storeOwnerPhone", storeOwnerPhone));
    }

    public void updateStoreInfor(SqlSession ss, StoreInforVo storeInfor) {
        ss.update("StoreInforMapper.updateStoreInfor", storeInfor);
    }

    public void insertStoreCategory(SqlSession ss, StoreInforVo storeCategoryName) {
        ss.insert("StoreInforMapper.insertStoreCategory", storeCategoryName);
    }

    public void insertApprovalStatus(SqlSession ss, StoreInforVo approvalStatus) {
        ss.insert("StoreInforMapper.insertApprovalStatus", approvalStatus);
    }

    public List<StoreCategoryVo> getStoreCategoryList(SqlSession ss) {
        return ss.selectList("StoreInforMapper.getStoreCategoryList");
    }

    public void insertStoreClosedDays(SqlSession ss, String no, String closedDays) {
        ss.insert("StoreInforMapper.insertStoreClosedDays", Map.of("storeNo", no, "closedDays", closedDays));
    }

    public void deleteStoreClosedDays(SqlSession ss, String no) {
        ss.delete("StoreInforMapper.deleteStoreClosedDays", no);
    }

    public List<ClosedDayVo> getClosedDays(SqlSession ss, String no) {
        return ss.selectList("StoreInforMapper.getClosedDays", no);
    }
}
