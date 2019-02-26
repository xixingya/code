package tech.petmall.petmall.portal.service;

import java.util.List;

import tech.petmall.petmall.bean.Cart;
import tech.petmall.petmall.bean.FavGoods;
import tech.petmall.petmall.bean.Goods;
import tech.petmall.petmall.bean.GoodsInfo;
import tech.petmall.petmall.bean.Member;
import tech.petmall.petmall.bean.Order;
import tech.petmall.petmall.bean.OrderItem;
import tech.petmall.petmall.bean.SellerInfo;

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
