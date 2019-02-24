package com.atguigu.atnewmall.portal.service;

import java.util.List;

import com.atguigu.atnewmall.bean.Goods;
import com.atguigu.atnewmall.bean.GoodsInfo;

public interface GoodsService {

	List<Goods> queryAll();

	GoodsInfo queryGoodsInfoById(Integer goodsid);

	Goods queryById(Integer goodsid);

}
