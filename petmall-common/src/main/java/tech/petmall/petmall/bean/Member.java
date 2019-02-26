package tech.petmall.petmall.bean;

public class Member {

	private Integer id             ;
	private String loginacct      ;
	private String memberpswd     ;
	private String nickname       ;
	private String avatar         ;
	private String loginstatus    ;
	private String authstatus     ;
	private String sellerstatus   ;
	private String lockstatus     ;
	private String regtime        ;
	private String lastvisittime  ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginacct() {
		return loginacct;
	}
	public void setLoginacct(String loginacct) {
		this.loginacct = loginacct;
	}
	public String getMemberpswd() {
		return memberpswd;
	}
	public void setMemberpswd(String memberpswd) {
		this.memberpswd = memberpswd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getLoginstatus() {
		return loginstatus;
	}
	public void setLoginstatus(String loginstatus) {
		this.loginstatus = loginstatus;
	}
	public String getAuthstatus() {
		return authstatus;
	}
	public void setAuthstatus(String authstatus) {
		this.authstatus = authstatus;
	}
	public String getSellerstatus() {
		return sellerstatus;
	}
	public void setSellerstatus(String sellerstatus) {
		this.sellerstatus = sellerstatus;
	}
	public String getLockstatus() {
		return lockstatus;
	}
	public void setLockstatus(String lockstatus) {
		this.lockstatus = lockstatus;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getLastvisittime() {
		return lastvisittime;
	}
	public void setLastvisittime(String lastvisittime) {
		this.lastvisittime = lastvisittime;
	}
	
}
