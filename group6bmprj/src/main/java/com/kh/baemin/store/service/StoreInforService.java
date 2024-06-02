package com.kh.baemin.store.service;

import com.kh.baemin.store.dao.StoreInforDao;
import com.kh.baemin.store.vo.StoreInforVo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

public class StoreInforService {

    private final StoreInforDao storeInforDao = new StoreInforDao();

    public List<StoreInforVo> getTop10StoreList() throws IOException {
        try (SqlSession ss = getSqlSession()) {
            return storeInforDao.getTop10StoreList(ss);
        }
    }

    public List<StoreInforVo> getStoreInforList(String searchText) throws IOException {
        try (SqlSession ss = getSqlSession()) {
            return storeInforDao.getStoreInforList(ss, searchText);
        }
    }

    public void insertStoreInfor(StoreInforVo storeInforVo) throws IOException {
        try (SqlSession ss = getSqlSession()) {
            try {

                storeInforDao.insertStoreInfor(ss, storeInforVo);

                String deliveryZoneNo = storeInforDao.getDeliveryZoneNoByLocalName(ss, storeInforVo.getName());

                if (deliveryZoneNo == null) {
                    throw new RuntimeException("No delivery zone found for local name: " + storeInforVo.getName());
                }

                storeInforDao.insertStoreZone(ss, storeInforVo.getNo(), deliveryZoneNo);

                ss.commit();
            } catch (Exception e) {
                ss.rollback();
            }
        }
    }

    public StoreInforVo getStoreInfor(String no) throws IOException {
        try (SqlSession ss = getSqlSession()) {
            return storeInforDao.getStoreInfor(ss, no);
        }
    }

    public void updateStoreInfor(StoreInforVo storeInfor) throws IOException {
        try (SqlSession ss = getSqlSession()) {
            try {
                if( storeInfor.getStoreOwnerPhone() != null && !storeInfor.getStoreOwnerPhone().isEmpty() ) {
                    storeInforDao.updateStoreOwnerPhone(ss, storeInfor.getNo(), storeInfor.getStoreOwnerPhone());
                    storeInforDao.updateStoreInfor(ss, storeInfor);
                }
                ss.commit();
            } catch (Exception e) {
                ss.rollback();
            }
        }


    }
}
