package com.musinsa.reward.model;

public class RewardPayDTO {
	private String userId;			// 아이디
	private String userName;		// 이름
	private String rewardPayDt;		// 보상 지급 일자(YYYYMMDD)
	private String rewardPayTm;		// 보상 지금 시간(HH24MISS)
	private long rewardPointAmt;	// 보상 포인트 금액
	private int rewardConCnt;		// 연속 보상 횟수
	private long rewardConAmt;		// 연속 보상 포인트 금액
	private long rewardTotalAmt;	// 총 보상 포인트 금액 (보상 포인트 금액 + 연속 보상 포인트 금액)
	private String rewardContent;	// 보상내용
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRewardPayDt() {
		return rewardPayDt;
	}
	public void setRewardPayDt(String rewardPayDt) {
		this.rewardPayDt = rewardPayDt;
	}
	public String getRewardPayTm() {
		return rewardPayTm;
	}
	public void setRewardPayTm(String rewardPayTm) {
		this.rewardPayTm = rewardPayTm;
	}
	public long getRewardPointAmt() {
		return rewardPointAmt;
	}
	public void setRewardPointAmt(long rewardPointAmt) {
		this.rewardPointAmt = rewardPointAmt;
	}
	public int getRewardConCnt() {
		return rewardConCnt;
	}
	public void setRewardConCnt(int rewardConCnt) {
		this.rewardConCnt = rewardConCnt;
	}
	public long getRewardConAmt() {
		return rewardConAmt;
	}
	public void setRewardConAmt(long rewardConAmt) {
		this.rewardConAmt = rewardConAmt;
	}
	public long getRewardTotalAmt() {
		return rewardTotalAmt;
	}
	public void setRewardTotalAmt(long rewardTotalAmt) {
		this.rewardTotalAmt = rewardTotalAmt;
	}
	public String getRewardContent() {
		return rewardContent;
	}
	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
	}
	
	
	
}
