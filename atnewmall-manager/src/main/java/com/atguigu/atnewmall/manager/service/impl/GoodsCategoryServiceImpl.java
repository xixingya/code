package com.atguigu.atnewmall.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atnewmall.bean.Datas;
import com.atguigu.atnewmall.bean.GoodsCategory;
import com.atguigu.atnewmall.manager.dao.GoodsCategoryDao;
import com.atguigu.atnewmall.manager.service.GoodsCategoryService;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

	@Autowired
	private GoodsCategoryDao goodsCategoryDao;

	public List<GoodsCategory> queryPageData(Map<String, Object> paramMap) {
		return goodsCategoryDao.queryPageData(paramMap);
	}

	public int queryPageCount(Map<String, Object> paramMap) {
		return goodsCategoryDao.queryPageCount(paramMap);
	}

	public void insertGoodsCategory(GoodsCategory gc) {
		goodsCategoryDao.insertGoodsCategory(gc);
	}

	public GoodsCategory queryById(Integer id) {
		return goodsCategoryDao.queryById(id);
	}

	public int updateGoodsCategory(GoodsCategory gc) {
		return goodsCategoryDao.updateGoodsCategory(gc);
	}

	public int deleteGoodsCategoryById(Integer id) {
		return goodsCategoryDao.deleteGoodsCategoryById(id);
	}

	public int deleteGoodsCategorys(Datas ds) {
		return goodsCategoryDao.deleteGoodsCategorys(ds);
	}

	public List<GoodsCategory> queryAll() {
		return goodsCategoryDao.queryAll();
	}
}
