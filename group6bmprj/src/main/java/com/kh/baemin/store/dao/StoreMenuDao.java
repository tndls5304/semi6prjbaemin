package com.kh.baemin.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.baemin.store.vo.CategoryVo;
import com.kh.baemin.store.vo.FoodInforVo;

/**
 * 스토어 사장님 파는 음식 메뉴 관리
 * 
 * @author 이수인
 */
public class StoreMenuDao {

	public int categoryAdd(SqlSession ss, CategoryVo vo) {

		return ss.insert("storeMapper.insertStoreMenuCategory", vo);
	}

	public List<CategoryVo> selectCategoryList(SqlSession ss, String storeNo) {

		return ss.selectList("storeMapper.getCategoryList", storeNo);
	}

	public int categoryEdit(SqlSession ss, CategoryVo vo) {

		return ss.update("storeMapper.categoryEdit", vo);
	}

	public int categoryDelete(SqlSession ss, CategoryVo vo) {

		return ss.update("storeMapper.categoryDelete", vo);
	}

	public int menuAdd(SqlSession ss, FoodInforVo vo) {

		return ss.insert("storeMapper.menuAdd", vo);
	}

	public List<FoodInforVo> selectMenuList(SqlSession ss, String storeNo) {

		return ss.selectList("storeMapper.selectMenuList", storeNo);
	}

}
