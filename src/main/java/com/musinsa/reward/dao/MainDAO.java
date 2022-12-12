package com.musinsa.reward.dao;

import org.apache.ibatis.annotations.Mapper;

import com.musinsa.reward.model.MemberDTO;
import com.musinsa.reward.model.RewardPayDTO;

@Mapper
public interface MainDAO {

	int selectExistUser(MemberDTO member) throws Exception;

	MemberDTO selectUserInfo(MemberDTO member) throws Exception;

	int updateUserPoint(RewardPayDTO payInfo) throws Exception;

}
