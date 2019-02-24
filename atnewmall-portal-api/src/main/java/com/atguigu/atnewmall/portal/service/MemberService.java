package com.atguigu.atnewmall.portal.service;

import java.util.List;

import com.atguigu.atnewmall.bean.Cart;
import com.atguigu.atnewmall.bean.FavGoods;
import com.atguigu.atnewmall.bean.Goods;
import com.atguigu.atnewmall.bean.GoodsInfo;
import com.atguigu.atnewmall.bean.Member;
import com.atguigu.atnewmall.bean.Order;
import com.atguigu.atnewmall.bean.OrderItem;
import com.atguigu.atnewmall.bean.SellerInfo;

public interface MemberService {

	Member queryMemberByLoginacct(String loginacct);

	void insertGoods(Goods goods, SellerInfo si, int[] tags);

	List<Goods> queryMemberGoods(Member loginMember);

	void insertFavGoods(FavGoods fg, GoodsInfo info);

	Cart queryCart(Cart c);

	void insertCart(Cart c);

	void updateCart(Cart cart);

	List<Cart> queryCartsByMemberid(Integer id);

	void insertOrder(Order order, List<OrderItem> items);

}
