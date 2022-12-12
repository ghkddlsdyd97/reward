package com.musinsa.reward.service;

import com.musinsa.reward.model.MemberDTO;

public interface MainService {

	int selectExistUser(MemberDTO member) throws Exception;

	MemberDTO selectUserInfo(MemberDTO member) throws Exception;

}
