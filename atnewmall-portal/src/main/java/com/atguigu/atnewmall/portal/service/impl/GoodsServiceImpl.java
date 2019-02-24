package com.atguigu.atnewmall.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atnewmall.bean.Goods;
import com.atguigu.atnewmall.bean.GoodsInfo;
import com.atguigu.atnewmall.portal.dao.GoodsDao;
import com.atguigu.atnewmall.portal.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	public List<Goods> queryAll() {
		return goodsDao.queryAll();
	}

	public GoodsInfo queryGoodsInfoById(Integer goodsid) {
		return goodsDao.queryGoodsInfoById(goodsid);
	}

	public Goods queryById(Integer goodsid) {
		return goodsDao.queryById(goodsid);
	}
}
