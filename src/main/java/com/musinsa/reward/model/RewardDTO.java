package com.musinsa.reward.model;

public class RewardDTO {
	private String rewardDt;		// 보상일자(YYYYMMDD)
	private String rewardContent;	// 보상내용
	private long rewardPointAmt;	// 보상 포인트 금액
	private int rewardUserCnt;		// 선착순 횟수
	private String instDate;		// 생성일자
	private String updtDate;		// 수정일자
	
	public String getRewardDt() {
		return rewardDt;
	}
	public void setRewardDt(String rewardDt) {
		this.rewardDt = rewardDt;
	}
	public String getRewardContent() {
		return rewardContent;
	}
	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
	}
	public long getRewardPointAmt() {
		return rewardPointAmt;
	}
	public void setRewardPointAmt(long rewardPointAmt) {
		this.rewardPointAmt = rewardPointAmt;
	}
	public int getRewardUserCnt() {
		return rewardUserCnt;
	}
	public void setRewardUserCnt(int rewardUserCnt) {
		this.rewardUserCnt = rewardUserCnt;
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
