package com.atguigu.atnewmall.portal.dao;

import java.util.List;

import com.atguigu.atnewmall.bean.Goods;
import com.atguigu.atnewmall.bean.GoodsInfo;

public interface GoodsDao {

	List<Goods> queryAll();

	GoodsInfo queryGoodsInfoById(Integer goodsid);

	Goods queryById(Integer goodsid);

}
