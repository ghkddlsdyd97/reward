package com.musinsa.reward.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.musinsa.reward.model.RewardDTO;
import com.musinsa.reward.model.RewardPayDTO;

@Mapper
public interface RewardDAO {

	RewardDTO selectExistReward() throws Exception;

	int selectExistRewardPay(RewardPayDTO payInfo) throws Exception;

	int selectRewardPayEnd() throws Exception;

	RewardPayDTO selectRewardConInfo(RewardPayDTO payInfo) throws Exception;

	int insertRewardPay(RewardPayDTO payInfo) throws Exception;

	List<RewardDTO> selectRewardList() throws Exception;

	List<RewardPayDTO> selectRewardPayList(String searchDt, String searchUserId, String searchOrder) throws Exception;

}
