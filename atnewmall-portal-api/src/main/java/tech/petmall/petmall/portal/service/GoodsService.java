package tech.petmall.petmall.portal.service;

import java.util.List;

import tech.petmall.petmall.bean.Goods;
import tech.petmall.petmall.bean.GoodsInfo;

public interface GoodsService {

	List<Goods> queryAll();

	GoodsInfo queryGoodsInfoById(Integer goodsid);

	Goods queryById(Integer goodsid);

}
