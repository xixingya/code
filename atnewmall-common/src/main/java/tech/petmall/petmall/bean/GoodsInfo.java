package tech.petmall.petmall.bean;

/**
 * 商品详情
 * @author 18801
 *
 */
public class GoodsInfo {
	private Integer id        ;
	private Integer goodsid   ;
	private Integer buycnt    ;
	private Integer goodcnt   ;
	private Integer favcnt    ;
	private Integer sellcnt   ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public Integer getBuycnt() {
		return buycnt;
	}
	public void setBuycnt(Integer buycnt) {
		this.buycnt = buycnt;
	}
	public Integer getGoodcnt() {
		return goodcnt;
	}
	public void setGoodcnt(Integer goodcnt) {
		this.goodcnt = goodcnt;
	}
	public Integer getFavcnt() {
		return favcnt;
	}
	public void setFavcnt(Integer favcnt) {
		this.favcnt = favcnt;
	}
	public Integer getSellcnt() {
		return sellcnt;
	}
	public void setSellcnt(Integer sellcnt) {
		this.sellcnt = sellcnt;
	}
	
}
