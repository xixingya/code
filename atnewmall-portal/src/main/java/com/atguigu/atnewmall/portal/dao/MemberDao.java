package com.atguigu.atnewmall.portal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.atnewmall.bean.Cart;
import com.atguigu.atnewmall.bean.FavGoods;
import com.atguigu.atnewmall.bean.Goods;
import com.atguigu.atnewmall.bean.GoodsInfo;
import com.atguigu.atnewmall.bean.GoodsTag;
import com.atguigu.atnewmall.bean.Member;
import com.atguigu.atnewmall.bean.Order;
import com.atguigu.atnewmall.bean.OrderItem;
import com.atguigu.atnewmall.bean.SellerInfo;

public interface MemberDao {

	Member queryMemberByLoginacct(String loginacct);

	void insertGoods(Goods goods);

	void insertSellerInfo(SellerInfo si);

	void insertGoodsTags(@Param("gts")List<GoodsTag> goodsTags);

	void insertGoodsInfo(GoodsInfo info);

	List<Goods> queryMemberGoods(Member loginMember);

	void insertFavGoods(FavGoods fg);

	void updateGoodsInfoFavcnt(GoodsInfo info);

	Cart queryCart(Cart c);

	void insertCart(Cart c);

	void updateCart(Cart cart);

	List<Cart> queryCartsByMemberid(Integer id);

	void insertOrder(Order order);

	void insertOrderItems(@Param("items")List<OrderItem> items);

	void deleteCarts(Order order);

}
