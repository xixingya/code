package tech.petmall.petmall.bean;

/**
 * 商家信息
 * @author 18801
 *
 */
public class SellerInfo {

	private Integer id         ;
	private Integer memberid   ;
	private String introduce  ;
	private String remark     ;
	private String tel        ;
	private String cstel      ;
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
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCstel() {
		return cstel;
	}
	public void setCstel(String cstel) {
		this.cstel = cstel;
	}
	
}
