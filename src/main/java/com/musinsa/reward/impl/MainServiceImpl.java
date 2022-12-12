package com.musinsa.reward.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.reward.dao.MainDAO;
import com.musinsa.reward.model.MemberDTO;
import com.musinsa.reward.service.MainService;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	private MainDAO mainDao;

	public int selectExistUser(MemberDTO member) throws Exception {
		return mainDao.selectExistUser(member);
	}

	public MemberDTO selectUserInfo(MemberDTO member) throws Exception {
		return mainDao.selectUserInfo(member);
	}
}
