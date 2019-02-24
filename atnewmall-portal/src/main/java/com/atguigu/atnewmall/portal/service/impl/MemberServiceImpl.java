package com.atguigu.atnewmall.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.atnewmall.bean.Cart;
import com.atguigu.atnewmall.bean.FavGoods;
import com.atguigu.atnewmall.bean.Goods;
import com.atguigu.atnewmall.bean.GoodsInfo;
import com.atguigu.atnewmall.bean.GoodsTag;
import com.atguigu.atnewmall.bean.Member;
import com.atguigu.atnewmall.bean.Order;
import com.atguigu.atnewmall.bean.OrderItem;
import com.atguigu.atnewmall.bean.SellerInfo;
import com.atguigu.atnewmall.portal.dao.MemberDao;
import com.atguigu.atnewmall.portal.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	public Member queryMemberByLoginacct(String loginacct) {
		return memberDao.queryMemberByLoginacct(loginacct);
	}

	public void insertGoods(Goods goods, SellerInfo si, int[] tags) {
		// 增加商品
		memberDao.insertGoods(goods);
		
		// 增加卖家信息
		memberDao.insertSellerInfo(si);
		
		// 增加标签信息
		List<GoodsTag> goodsTags = new ArrayList<GoodsTag>();
		for (int tagid : tags) {
			GoodsTag t = new GoodsTag();
			t.setGoodsid(goods.getId());
			t.setTagid(tagid);
			goodsTags.add(t);
		}
		memberDao.insertGoodsTags(goodsTags);
		
		// 增加商品详情
		GoodsInfo info = new GoodsInfo();
		info.setGoodsid(goods.getId());
		memberDao.insertGoodsInfo(info);
	}

	public List<Goods> queryMemberGoods(Member loginMember) {
		return memberDao.queryMemberGoods(loginMember);
	}

	public void insertFavGoods(FavGoods fg, GoodsInfo info) {
		memberDao.insertFavGoods(fg);
		memberDao.updateGoodsInfoFavcnt(info);
	}

	public Cart queryCart(Cart c) {
		return memberDao.queryCart(c);
	}

	public void insertCart(Cart c) {
		memberDao.insertCart(c);
	}

	public void updateCart(Cart cart) {
		memberDao.updateCart(cart);
	}

	public List<Cart> queryCartsByMemberid(Integer id) {
		return memberDao.queryCartsByMemberid(id);
	}

	public void insertOrder(Order order, List<OrderItem> items) {
		memberDao.insertOrder(order);
		
		for ( OrderItem item : items ) {
			item.setOrderid(order.getId());
		}
		memberDao.insertOrderItems(items);
		
		memberDao.deleteCarts(order);
	}
}
