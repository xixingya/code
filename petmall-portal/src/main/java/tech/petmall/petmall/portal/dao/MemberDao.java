package tech.petmall.petmall.portal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tech.petmall.petmall.bean.Cart;
import tech.petmall.petmall.bean.FavGoods;
import tech.petmall.petmall.bean.Goods;
import tech.petmall.petmall.bean.GoodsInfo;
import tech.petmall.petmall.bean.GoodsTag;
import tech.petmall.petmall.bean.Member;
import tech.petmall.petmall.bean.Order;
import tech.petmall.petmall.bean.OrderItem;
import tech.petmall.petmall.bean.SellerInfo;

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
