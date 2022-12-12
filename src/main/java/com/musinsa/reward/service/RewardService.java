package com.musinsa.reward.service;

import java.util.List;

import com.musinsa.reward.model.RewardDTO;
import com.musinsa.reward.model.RewardPayDTO;

public interface RewardService {

	RewardDTO selectExistReward() throws Exception;

	int selectExistRewardPay(RewardPayDTO payInfo) throws Exception;

	int selectRewardPayEnd() throws Exception;

	RewardPayDTO insertRewardPay(RewardPayDTO pyaInfo) throws Exception;

	List<RewardDTO> selectRewardList() throws Exception;

	List<RewardPayDTO> selectRewardPayList(String searchDt, String searchUserId, String searchOrder) throws Exception;
}
