package tech.petmall.petmall.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.petmall.petmall.bean.Goods;
import tech.petmall.petmall.bean.GoodsInfo;
import tech.petmall.petmall.portal.dao.GoodsDao;
import tech.petmall.petmall.portal.service.GoodsService;

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
