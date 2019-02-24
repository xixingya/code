package com.atguigu.atnewmall.manager.dao;

import java.util.List;
import java.util.Map;

import com.atguigu.atnewmall.bean.Datas;
import com.atguigu.atnewmall.bean.GoodsCategory;

public interface GoodsCategoryDao {

	List<GoodsCategory> queryPageData(Map<String, Object> paramMap);

	int queryPageCount(Map<String, Object> paramMap);

	void insertGoodsCategory(GoodsCategory gc);

	GoodsCategory queryById(Integer id);

	int updateGoodsCategory(GoodsCategory gc);

	int deleteGoodsCategoryById(Integer id);

	int deleteGoodsCategorys(Datas ds);

	List<GoodsCategory> queryAll();

}
