package com.musinsa.reward.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.reward.dao.MainDAO;
import com.musinsa.reward.dao.RewardDAO;
import com.musinsa.reward.model.RewardDTO;
import com.musinsa.reward.model.RewardPayDTO;
import com.musinsa.reward.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService{

	@Autowired
	private RewardDAO rewardDao;
	
	@Autowired
	private MainDAO mainDao;

	public RewardDTO selectExistReward() throws Exception {
		return rewardDao.selectExistReward();
	}

	public int selectExistRewardPay(RewardPayDTO payInfo) throws Exception {
		return rewardDao.selectExistRewardPay(payInfo);
	}

	public int selectRewardPayEnd() throws Exception {
		return rewardDao.selectRewardPayEnd();
	}

	@Transactional(rollbackFor = Exception.class)
	public RewardPayDTO insertRewardPay(RewardPayDTO payInfo) throws Exception {
		int result = 0;
		
		// 연속 보상 가져오기
		RewardPayDTO conInfo = rewardDao.selectRewardConInfo(payInfo);

		int rewardConCnt = 1;
		if(conInfo != null) {
			// 연속보상 10일 이후 1회 초기화
			rewardConCnt = conInfo.getRewardConCnt() == 10 ? 1 : conInfo.getRewardConCnt() + 1;
		}
		
		
		// 연속 보상 포인트
		long rewardConAmt = 0;
		if(rewardConCnt == 3) rewardConAmt = 300;
		if(rewardConCnt == 5) rewardConAmt = 500;
		if(rewardConCnt == 10) rewardConAmt = 1000;
		
		// 총 보상 포인트
		long rewardTotalAmt = payInfo.getRewardPointAmt() + rewardConAmt;
		
		payInfo.setRewardConCnt(rewardConCnt);
		payInfo.setRewardConAmt(rewardConAmt);
		payInfo.setRewardTotalAmt(rewardTotalAmt);
		
		// 보상지급 테이블 insert
		result = rewardDao.insertRewardPay(payInfo);
		
		// 회원테이블 포인트 update
		result = mainDao.updateUserPoint(payInfo);
		
		return payInfo;
	}

	public List<RewardDTO> selectRewardList() throws Exception {
		return rewardDao.selectRewardList();
	}

	@Override
	public List<RewardPayDTO> selectRewardPayList(String searchDt, String searchUserId, String searchOrder)
			throws Exception {
		return rewardDao.selectRewardPayList(searchDt, searchUserId, searchOrder);
	}
}
