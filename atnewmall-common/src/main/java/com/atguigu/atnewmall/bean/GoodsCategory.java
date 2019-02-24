package com.atguigu.atnewmall.bean;

import java.util.ArrayList;
import java.util.List;

public class GoodsCategory {

	private Integer id;
	private String name;
	private String remark;
	private Integer orderid;
	private String createtime;
	private List<Goods> goodsDatas = new ArrayList<Goods>();
	
	public List<Goods> getGoodsDatas() {
		return goodsDatas;
	}
	public void setGoodsDatas(List<Goods> goodsDatas) {
		this.goodsDatas = goodsDatas;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	
}
