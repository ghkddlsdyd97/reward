package com.musinsa.reward.model;

public class MemberDTO {
	private String userId;		// 아이디
	private String userPwd;		// 패스워드
	private String userName;	// 이름
	private String phoneNum;	// 휴대폰번호
	private String useYn;		// 사용여부 (Y:사용, N:미사용)
	private long point;			// 보유 포인트
	private String instDate;	// 생성일자
	private String updtDate;	// 수정일자
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public long getPoint() {
		return point;
	}
	public void setPoint(long point) {
		this.point = point;
	}
	public String getInstDate() {
		return instDate;
	}
	public void setInstDate(String instDate) {
		this.instDate = instDate;
	}
	public String getUpdtDate() {
		return updtDate;
	}
	public void setUpdtDate(String updtDate) {
		this.updtDate = updtDate;
	}
	
	
}
