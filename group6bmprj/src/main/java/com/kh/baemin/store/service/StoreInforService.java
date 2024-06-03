package com.kh.baemin.store.service;

import static com.kh.baemin.db.SqlSessionTemplate.getSqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.dao.StoreInforDao;
import com.kh.baemin.store.vo.ClosedDayVo;
import com.kh.baemin.store.vo.StoreCategoryVo;
import com.kh.baemin.store.vo.StoreInforVo;

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

                String deliveryZoneNo = storeInforDao.getDeliveryZoneNoByLocalName(ss, storeInforVo.getLocalName());
                if (deliveryZoneNo == null) {
                    throw new RuntimeException("No delivery zone found for local name: " + storeInforVo.getLocalName());
                }

                // �����з� ����
                //storeInforDao.insertStoreCategory(ss, storeInforVo);

                // ���� ���λ��� ����
                //storeInforDao.insertApprovalStatus(ss, storeInforVo);

                // ���� ����
                storeInforDao.insertStoreInfor(ss, storeInforVo);

                // ��� ���� ����
                storeInforDao.insertStoreZone(ss, storeInforVo.getNo(), deliveryZoneNo);

                ss.commit();
            } catch (Exception e) {
                e.printStackTrace();
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
                }

                if( storeInfor.getOpenYn() != null && !storeInfor.getOpenYn().isEmpty()
                        ||  storeInfor.getPhone() != null && !storeInfor.getPhone().isEmpty()
                        ||  storeInfor.getIntroduce() != null && !storeInfor.getIntroduce().isEmpty()
                        ||  storeInfor.getOpenTime() != null && !storeInfor.getOpenTime().isEmpty()
                    || storeInfor.getEndTime() != null && !storeInfor.getEndTime().isEmpty()
                    || storeInfor.getBreakTimeStart() != null && !storeInfor.getBreakTimeStart().isEmpty()
                    || storeInfor.getBreakTimeEnd() != null && !storeInfor.getBreakTimeEnd().isEmpty()
                        || storeInfor.getMinimumOrderAmount() != null && !storeInfor.getMinimumOrderAmount().isEmpty()
                ) {

                    storeInforDao.updateStoreInfor(ss, storeInfor);
                }

                storeInforDao.deleteStoreClosedDays(ss, storeInfor.getNo());

                if( storeInfor.getClosedDays1() != null && !storeInfor.getClosedDays1().isEmpty()){
                    storeInforDao.insertStoreClosedDays(ss, storeInfor.getNo(), storeInfor.getClosedDays1());
                }

                if( storeInfor.getClosedDays2() != null && !storeInfor.getClosedDays2().isEmpty()){
                    storeInforDao.insertStoreClosedDays(ss, storeInfor.getNo(), storeInfor.getClosedDays2());
                }

                if( storeInfor.getClosedDays3() != null && !storeInfor.getClosedDays3().isEmpty()){
                    storeInforDao.insertStoreClosedDays(ss, storeInfor.getNo(), storeInfor.getClosedDays3());
                }

                if( storeInfor.getClosedDays4() != null && !storeInfor.getClosedDays4().isEmpty()){
                    storeInforDao.insertStoreClosedDays(ss, storeInfor.getNo(), storeInfor.getClosedDays4());
                }

                if( storeInfor.getClosedDays5() != null && !storeInfor.getClosedDays5().isEmpty()){
                    storeInforDao.insertStoreClosedDays(ss, storeInfor.getNo(), storeInfor.getClosedDays5());
                }


                ss.commit();
            } catch (Exception e) {
                e.printStackTrace();
                ss.rollback();
            }
        }


    }

    public List<StoreCategoryVo> getStoreCategoryList() throws IOException {
        try (SqlSession ss = getSqlSession()) {
            return storeInforDao.getStoreCategoryList(ss);
        }
    }

    public List<ClosedDayVo> getClosedDays(String no) throws IOException {
        try (SqlSession ss = getSqlSession()) {
            return storeInforDao.getClosedDays(ss, no);
        }

    }
}
