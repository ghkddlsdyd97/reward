package com.musinsa.reward.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.musinsa.reward.model.MemberDTO;
import com.musinsa.reward.model.RewardDTO;
import com.musinsa.reward.model.RewardPayDTO;
import com.musinsa.reward.service.MainService;
import com.musinsa.reward.service.RewardService;

@Controller
public class RewardController {
	private static Logger logger = LoggerFactory.getLogger(RewardController.class);
	
	@Autowired
	private RewardService rewardService;
	
	@Autowired
	private MainService mainService;
	
	// 보상 지급
	@PostMapping("/rewardPay.do")
	public ResponseEntity rewardPay(Model model
						  , HttpServletRequest request
						  , HttpServletResponse response
						  , String userId) throws Exception{
		HttpSession session = request.getSession();
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		String msg = "";
		
		int result = 0;
		
		// 보상데이터 유무 확인
		RewardDTO rewardInfo = rewardService.selectExistReward();
		logger.info("***** 보상 데이터 *****\n" + rewardInfo);
		
		if(rewardInfo != null) {
			RewardPayDTO payInfo = new RewardPayDTO();
			payInfo.setUserId(userId);
			
			// 보상 중복확인
			result = rewardService.selectExistRewardPay(payInfo);
			
			if(result == 0) {
				// 선착순 확인
				result = rewardService.selectRewardPayEnd();
				
				if(result < rewardInfo.getRewardUserCnt()) {
					payInfo.setRewardPointAmt(rewardInfo.getRewardPointAmt());
					payInfo.setRewardPayDt(rewardInfo.getRewardDt());
					
					// 보상 지급
					RewardPayDTO resultInfo = rewardService.insertRewardPay(payInfo);
					logger.info("***** 보상 지급 데이터 *****\n" + resultInfo);
					
					MemberDTO userInfo = mainService.selectUserInfo(member);
					session.setAttribute("point", userInfo.getPoint());
					
					if(resultInfo.getRewardConCnt() == 3 || resultInfo.getRewardConCnt() == 5 || resultInfo.getRewardConCnt() == 10) {
						msg = "보상받기가 완료되었습니다.\n" + resultInfo.getRewardConCnt() + "회 연속보상으로 " + resultInfo.getRewardConAmt() + 
								"포인트가 추가 지급됩니다.";
					}else {
						msg = "보상받기가 완료 되었습니다.";
					}
				}else {
					msg = "오늘 선착순 보상은 마감되었습니다.";
				}
			}else {
				msg = "이미 오늘 보상을 받으셨습니다.";
			}
		}else {
			msg = "오늘은 보상이 없습니다.";
		}
		logger.info(msg);
		return new ResponseEntity(msg, HttpStatus.OK);
	}
	
	// 보상리스트 조회
	@GetMapping("/rewardList.do")
	public ModelAndView rewardList(Model model
						, HttpServletRequest request
						, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("rewardView");

		List<RewardDTO> rewardList = rewardService.selectRewardList();
		mv.addObject("rewardList", rewardList);
		logger.info("***** 보상리스트 조회 *****\n" + rewardList);	
		
		return mv;
	}
	
	// 보상리스트 화면 호출
	@GetMapping("/rewardPayView")
	public String rewardPayView(Model model
						, HttpServletRequest request
						, HttpServletResponse response) throws Exception {
		
		return "rewardPayView";
	}
	
	// 보상리스트 조회
	@PostMapping("/rewardPayList.do")
	public String rewardPayList(Model model
							  , HttpServletRequest request
							  , HttpServletResponse response
							  , @RequestParam String searchDt
							  , @RequestParam String searchUserId
							  , @RequestParam String searchOrder) throws Exception {

		model.addAttribute("searchDt", searchDt);
		model.addAttribute("searchUserId", searchUserId);
		model.addAttribute("searchOrder", searchOrder);
		searchDt = searchDt.replaceAll("-", "");
		
		List<RewardPayDTO> rewardPayList = rewardService.selectRewardPayList(searchDt, searchUserId, searchOrder);
		
		model.addAttribute("rewardPayList", rewardPayList);
		
		logger.info("***** 보상지급 내역 리스트 호출 *****\n" + rewardPayList.toString());
		
		return "rewardPayView :: #listTable";
	}
}
