package tech.petmall.petmall.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.petmall.petmall.bean.Goods;
import tech.petmall.petmall.common.BaseController;
import tech.petmall.petmall.portal.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {

	@Autowired
	private GoodsService goodsService;

	/**
	 * 跳转到商品的详细页面
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id")Integer goodsid, Model model) {
		
		// 查询商品相关信息
		Goods goods = goodsService.queryById(goodsid);
		model.addAttribute("goods", goods);
		
		return "goods/detail";
	}
}
