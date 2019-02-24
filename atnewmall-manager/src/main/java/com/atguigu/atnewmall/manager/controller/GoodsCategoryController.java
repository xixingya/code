package com.atguigu.atnewmall.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atnewmall.bean.AJAXResult;
import com.atguigu.atnewmall.bean.Datas;
import com.atguigu.atnewmall.bean.GoodsCategory;
import com.atguigu.atnewmall.bean.Page;
import com.atguigu.atnewmall.common.BaseController;
import com.atguigu.atnewmall.common.util.StringUtil;
import com.atguigu.atnewmall.manager.service.GoodsCategoryService;

/**
 * 商品分类控制器
 * @author 18801
 *
 */
@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryController extends BaseController {

	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	/**
	 * 批量删除商品分类信息
	 * 将表单中的多条相同类型数据封装到后台的对象集合中
	 * 1） 增加数据包装类，用于获取对象集合
	 * 2) 包装类中增加对象集合属性:ids，并增加对应set/get方法
	 * 3) 表单中传递数据采用特殊方式
	 *    ids[0]=1&ids[1]=2&ids[2]=3
	 * 4) 在方法中增加参数
	 * 5) 不支持泛型
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deletes")
	public Object deletes( Datas ds ) {
		AJAXResult result = new AJAXResult();
		
		try {
			// 删除集合中不满足条件的数据(迭代器)
//			for ( GoodsCategory gc : ds.getGcs() ) {
//				if ( gc.getId() == null ) {
//					ds.getGcs().remove(gc);
//				}
//			}
//			Iterator<GoodsCategory> iter = ds.getGcs().iterator();
//			while ( iter.hasNext() ) {
//				GoodsCategory gc = iter.next();
//				if ( gc.getId() == null ) {
//					iter.remove();
//				}
//			}
			int cnt = goodsCategoryService.deleteGoodsCategorys(ds);
			result.setSuccess(cnt == ds.getGcs().size());
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 删除商品分类信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Object delete(Integer id) {
		
		start();

		try {
			
			int cnt = 
				goodsCategoryService.deleteGoodsCategoryById(id);
			success(cnt == 1);
		} catch ( Exception e ) {
			e.printStackTrace();
			fail();
		}
		
		return end();
	}
	
	/**
	 * 修改商品分类信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update( GoodsCategory gc ) {
		AJAXResult result = new AJAXResult();
		
		try {
			int cnt = goodsCategoryService.updateGoodsCategory(gc);
			result.setSuccess(cnt == 1);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit( Integer id, Model model ) {
		
		GoodsCategory gc = goodsCategoryService.queryById(id);
		model.addAttribute("gc", gc);
		
		return "goodsCategory/edit";
	}
	
	/**
	 * 新增商品分类信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public Object insert( GoodsCategory gc ) {
		AJAXResult result = new AJAXResult();
		
		try {
			SimpleDateFormat sdf =
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			gc.setCreatetime(sdf.format(new Date()));
			goodsCategoryService.insertGoodsCategory(gc);
			
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 分页查询商品分类信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery( String queryText, Integer pageno, Integer pagesize ) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			// xxxxx@xx.com
			// aaaaaaaaaa
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("start", (pageno-1)*pagesize);
			paramMap.put("size", pagesize);
			if ( !StringUtil.isEmpty(queryText) ) {
				if ( queryText.indexOf("\\") != -1 ) {
					queryText = queryText.replaceAll("\\\\", "\\\\\\\\");
				}
				if ( queryText.indexOf("_") != -1 ) {
					queryText = queryText.replaceAll("_", "\\\\_");
				}
				if ( queryText.indexOf("%") != -1 ) {
					queryText = queryText.replaceAll("%", "\\\\%");
				}
			}
			paramMap.put("queryText", queryText);

			List<GoodsCategory> goodsCategorys = goodsCategoryService.queryPageData(paramMap);

			int totalsize = goodsCategoryService.queryPageCount(paramMap);
			int totalno = 0;
			if ( totalsize % pagesize == 0 ) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
			
			Page<GoodsCategory> pcPage = new Page<GoodsCategory>();
			pcPage.setDatas(goodsCategorys);
			pcPage.setTotalsize(totalsize);
			pcPage.setTotalno(totalno);
			pcPage.setPageno(pageno);
			pcPage.setPagesize(pagesize);
			
			result.setData(pcPage);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
	}
	
	/**
	 * 跳转新增页面
	 * @return
	 */
	@RequestMapping("/add")
	public String add() {
		return "goodsCategory/add";
	}
	
	/**
	 * 跳转主页面
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "goodsCategory/index";
	}
	
	/**
	 * 跳转到商品分类的首页（分页查询页面）
	 * @return
	 */
	@RequestMapping("/index1")
	public String index1( @RequestParam(required=false, defaultValue="1")Integer pageno, @RequestParam(required=false,defaultValue="2")Integer pagesize, Model model ) {
		
		// 分页查询商品分类数据
		// limit start, size
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", (pageno-1)*pagesize);
		paramMap.put("size", pagesize);
		
		// 分页查询数据
		// 返回查询结果
		List<GoodsCategory> goodsCategorys = goodsCategoryService.queryPageData(paramMap);

		// 总的数据条数
		int totalsize = goodsCategoryService.queryPageCount(paramMap);
		// 计算最后页码(总页码)
		int totalno = 0;
		if ( totalsize % pagesize == 0 ) {
			totalno = totalsize / pagesize;
		} else {
			totalno = totalsize / pagesize + 1;
		}
		
		// 保存查询结果
		model.addAttribute("gcs", goodsCategorys);
		model.addAttribute("pageno", pageno);
		model.addAttribute("totalno", totalno);
		
		return "goodsCategory/index";
	}
}
