package tech.petmall.petmall.portal.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import tech.petmall.petmall.bean.Cart;
import tech.petmall.petmall.bean.FavGoods;
import tech.petmall.petmall.bean.Goods;
import tech.petmall.petmall.bean.GoodsCategory;
import tech.petmall.petmall.bean.GoodsInfo;
import tech.petmall.petmall.bean.Member;
import tech.petmall.petmall.bean.Order;
import tech.petmall.petmall.bean.OrderItem;
import tech.petmall.petmall.bean.SellerInfo;
import tech.petmall.petmall.bean.Tag;
import tech.petmall.petmall.common.BaseController;
import tech.petmall.petmall.common.util.MD5Util;
import tech.petmall.petmall.manager.service.GoodsCategoryService;
import tech.petmall.petmall.manager.service.TagService;
import tech.petmall.petmall.portal.service.GoodsService;
import tech.petmall.petmall.portal.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	@Autowired
	private TagService tagService;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/myorder")
	public String myorder() {
		return "member/myorder";
	}
	
	/**
	 * 下订单
	 * @return
	 */
	@RequestMapping("/doOrder")
	public String doOrder( HttpSession session ) {
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		List<Cart> carts = memberService.queryCartsByMemberid(loginMember.getId());
		int totalprice = 0;
		List<OrderItem> items = new ArrayList<OrderItem>();
		for ( Cart cart : carts ) {
			totalprice += cart.getNum() * cart.getPrice();
			OrderItem item = new OrderItem();
			item.setNum(cart.getNum());
			item.setPrice(cart.getPrice());
			item.setGoodsid(cart.getGoodsid());
			items.add(item);
		}
		
		Order order = new Order();
		order.setMemberid(loginMember.getId());
		order.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		order.setStatus("00");
		order.setPrice(totalprice);
		
		memberService.insertOrder(order, items);
		
		return "redirect:/member/myorder";
	}
	
	@RequestMapping("/checkOrder")
	public String checkOrder() {
		return "member/checkOrder";
	}
	
	@ResponseBody
	@RequestMapping("/carts")
	public Object carts( HttpSession session ) {
		start();
		
		try {
			Member loginMember = (Member)session.getAttribute("loginMember");
			List<Cart> carts = memberService.queryCartsByMemberid(loginMember.getId());
			data(carts);
			success();
		} catch ( Exception e ) {
			e.printStackTrace();
			fail();
		}
		
		return end();
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "member/cart";
	}
	
	/**
	 * 将商品加入购物车
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addGoodsIntoCart")
	public Object addGoodsIntoCart(HttpSession session, Integer price, Integer goodsid, Integer cnt) {
		start();
		
		try {
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			
			// 查询是否曾经买过商品
			Cart c = new Cart();
			c.setMemberid(loginMember.getId());
			c.setGoodsid(goodsid);
			Cart cart = memberService.queryCart(c);
			
			if ( cart == null ) {
				// 没买
				c.setNum(cnt);
				c.setPrice(price);
				c.setJointime(date);
				
				memberService.insertCart(c);
			} else {
				// 买过
				cart.setNum(cart.getNum() + cnt);
				memberService.updateCart(cart);
				
			}

			success();
		} catch ( Exception e ) {
			e.printStackTrace();
			fail();
		}
		
		return end();
	}
	
	@ResponseBody
	@RequestMapping("/addFav")
	public Object addFav( Integer goodsid, HttpSession session ) {
		start();
		
		try {
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			// 增加
			FavGoods fg = new FavGoods();
			fg.setGoodsid(goodsid);
			fg.setMemberid(loginMember.getId());
			
			GoodsInfo info = goodsService.queryGoodsInfoById(goodsid);
			if ( info.getFavcnt() == null ) {
				info.setFavcnt(1);
			} else {
				info.setFavcnt(info.getFavcnt() + 1);
			}
			
			memberService.insertFavGoods(fg, info);
			
			success();
		} catch ( Exception e ) {
			e.printStackTrace();
			fail();
		}
		
		return end();
	}
	
	/**
	 * 查询我的商品
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryMemberGoods")
	public Object queryMemberGoods( HttpSession session ) {
		
		start();
		
		try {
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			List<Goods> goodsDatas = memberService.queryMemberGoods(loginMember);
			data(goodsDatas);
			success();
		} catch ( Exception e ) {
			e.printStackTrace();
			fail();
		}
		
		return end();
	}
	
	/**
	 * 发布商品
	 * @return
	 */
	@RequestMapping("/insertGoods")
	public String insertGoods( HttpSession session, Goods goods, SellerInfo si, int[] tags ) throws Exception {
		
		// 登陆会员信息（卖家）
		Member loginMember = (Member)session.getAttribute("loginMember");
		goods.setMemberid(loginMember.getId());
		si.setMemberid(loginMember.getId());
		
		si.setRemark(goods.getSiremark());
		si.setIntroduce(goods.getIntroduce());
		si.setTel(goods.getTel());
		si.setCstel(goods.getCstel());
		
		// 保存上传的图片
		MultipartFile goodsHeadImgFile = goods.getGoodsHeadImg();
		MultipartFile goodsDetailImgFile = goods.getGoodsDetailImg();
		
		ServletContext application = session.getServletContext();
		String imgSavePath = application.getRealPath("img/goods");
		
		String headImgFileName = goodsHeadImgFile.getOriginalFilename();
		String detailImgFileName = goodsDetailImgFile.getOriginalFilename();
		
		String uuid = UUID.randomUUID().toString();
		String suffix = headImgFileName.substring(headImgFileName.lastIndexOf("."));
		String targetFileName = uuid + suffix;
		File targetFile = new File(imgSavePath + "/" + targetFileName);
		// 保存宣传图片
		goodsHeadImgFile.transferTo(targetFile);
		goods.setIconpath(targetFileName);
		
		uuid = UUID.randomUUID().toString();
		suffix = detailImgFileName.substring(detailImgFileName.lastIndexOf("."));
		targetFileName = uuid + suffix;
		targetFile = new File(imgSavePath + "/" + targetFileName);
		// 保存详细图片
		goodsDetailImgFile.transferTo(targetFile);
		goods.setIconpath1(targetFileName);
		
		memberService.insertGoods(goods, si, tags);
		
		return "redirect:/member/myshop";
	}
	
	@RequestMapping("/insertGoods1")
	public String insertGood1( HttpServletRequest req ) throws Exception {
		
		MultipartHttpServletRequest request = 
			(MultipartHttpServletRequest)req;
		
		MultipartFile goodsHeadImgFile = request.getFile("goodsHeadImg");
		
		// 表单文件域名称
		//String name = goodsHeadImgFile.getName();
		// 原始文件名称（真实文件名称）:p.i.c.jpg
		String filename = goodsHeadImgFile.getOriginalFilename();
		
		// 获取当前web应用的文件目录路径
		ServletContext application = req.getSession().getServletContext();
		String imgSavePath = application.getRealPath("img/goods");
		
		// UUID.png
		String uuid = UUID.randomUUID().toString();
		String suffix = filename.substring(filename.lastIndexOf("."));
		String targetFileName = uuid + suffix;
		File targetFile = new File(imgSavePath + "/" + targetFileName);
		
		// 保存文件
		// 装饰者设计模式
		// 代理模式
		//new BufferedInputStream(new FileInputStream());
		// FileOutputSteam
		goodsHeadImgFile.transferTo(targetFile);
		
		return "redirect:/member";
	}
	
	@RequestMapping("/addGoods")
	public String addGoods( Model model ) {
		
		List<GoodsCategory> gcs = goodsCategoryService.queryAll();
		model.addAttribute("gcs", gcs);
		
		Tag rootTag = null;
		List<Tag> allTags = tagService.queryAll();
		Map<Integer, Tag> tagMap = new HashMap<Integer, Tag>();
		for ( Tag tag : allTags ) {
			tagMap.put(tag.getId(), tag);
		}
		for ( Tag tag : allTags ) {
			// 子标签
			Tag child = tag;
			if ( child.getPid() == 0 ) {
				rootTag = tag;
			} else {
				// 父标签
				Tag parent = tagMap.get(child.getPid());
				// 组合父子标签的关系
				parent.getChildren().add(child);
			}
		}
		model.addAttribute("rootTag", rootTag);
		return "member/addGoods";
	}
	
	@RequestMapping("/myshop")
	public String myshop() {
		return "member/myshop";
	}
	
	@RequestMapping("/logout")
	public String logout( HttpSession session ) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@ResponseBody
	@RequestMapping("/doAJAXLogin")
	public Object doAJAXLogin( String loginacct, String userpswd, HttpSession session ) {
		start();
		
		try {
			
			// 根据账号查询会员信息
			// 错误码
			// 101 = 账号
			// 102 = 密码
			// 103 = 权限
			Member dbMember =
				memberService.queryMemberByLoginacct(loginacct);
			if ( dbMember == null ) {
				data(101);
				fail();
			} else {
				if ( dbMember.getMemberpswd().equals(MD5Util.digest(userpswd)) ) {
					// 登陆成功
					session.setAttribute("loginMember", dbMember);
					success();
				} else {
					data(102);
					fail();
				}
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			data(103);
			fail();
		}
		
		return end();
	}
}
