package tech.petmall.petmall.bean;

public class Order {

	private Integer id          ;
	private Integer memberid    ;
	private String ordernum    ;
	private String status      ;
	private String createtime  ;
	private Integer price       ;
	private String paytype     ;
	private Integer payprice    ;
	private String ispay       ;
	private String paytime     ;
	private String issend      ;
	private String sendtime    ;
	private String isreceipt   ;
	private String receipttime ;
	private Integer addressid   ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMemberid() {
		return memberid;
	}
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public Integer getPayprice() {
		return payprice;
	}
	public void setPayprice(Integer payprice) {
		this.payprice = payprice;
	}
	public String getIspay() {
		return ispay;
	}
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	public String getPaytime() {
		return paytime;
	}
	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	public String getIssend() {
		return issend;
	}
	public void setIssend(String issend) {
		this.issend = issend;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getIsreceipt() {
		return isreceipt;
	}
	public void setIsreceipt(String isreceipt) {
		this.isreceipt = isreceipt;
	}
	public String getReceipttime() {
		return receipttime;
	}
	public void setReceipttime(String receipttime) {
		this.receipttime = receipttime;
	}
	public Integer getAddressid() {
		return addressid;
	}
	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}
	
}
