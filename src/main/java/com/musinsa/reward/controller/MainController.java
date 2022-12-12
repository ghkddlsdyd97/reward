package com.musinsa.reward.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.musinsa.reward.model.MemberDTO;
import com.musinsa.reward.service.MainService;

@Controller
public class MainController {
	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainService mainService;
	
	// 메인페이지 리다이렉트
	@RequestMapping("/")
	public String main(Model model
					 , HttpServletRequest request
					 , HttpServletResponse response) throws Exception{
		return "redirect:main";
	}
	
	// 메인페이지
	@GetMapping("/main")
	public ModelAndView mainView(Model model
						, HttpServletRequest request
						, HttpServletResponse response
						, MemberDTO member) throws Exception {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView("mainView");
		
		mv.addObject("member", member);
		
		return mv;
	}
	
	// 로그인 페이지
	@GetMapping("/loginView")
	public ModelAndView loginView(Model model
						, HttpServletRequest request
						, HttpServletResponse response
						, MemberDTO member) throws Exception {
		ModelAndView mv = new ModelAndView("login");
		
		mv.addObject("member", member);
		
		return mv;
	}
	
	// 로그인
	@PostMapping("/login.do")
	public String login(Model model
					  , HttpServletRequest request
					  , HttpServletResponse response
					  , MemberDTO member
					  , BindingResult bindingResult) throws Exception{
		
		HttpSession session = request.getSession();

		if(member.getUserId().equals("")) {
			model.addAttribute("message", "아이디는 필수값 입니다.");
			return "login";
		}
		if(member.getUserPwd().equals("")) {
			model.addAttribute("message", "비밀번호는 필수값 입니다.");
			return "login";
		}
		
		// 로그인 계정 존재여부 확인
		int result = mainService.selectExistUser(member);
		
		if(result > 0) {
			// 유저 정보 가져오기
			MemberDTO userInfo = mainService.selectUserInfo(member);
			
			if(userInfo.getUseYn().equals("Y")) {	// 계정 사용여부 체크 (Y: 사용, N: 미사용)
				session.setAttribute("userId", userInfo.getUserId());
				session.setAttribute("userName", userInfo.getUserName());
				session.setAttribute("point", userInfo.getPoint());
				logger.info("로그인에 성공하였습니다.");
				
				System.out.println("=======" + userInfo.getUserName());

				return "redirect:main";
			}else {
				logger.info("사용중지 된 아이디입니다. 관리자에게 문의하여 주세요.\n" + member);
				model.addAttribute("message", "사용중지 된 아이디입니다. 관리자에게 문의하여 주세요.");
				return "login";
			}
		}else {
			logger.info("아이디 또는 비밀번호가 존재하지 않습니다.\n");
			model.addAttribute("message", "아이디 또는 비밀번호가 존재하지 않습니다.");
			return "login";
		}
		
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(Model model
			  , HttpServletRequest request
			  , HttpServletResponse response
			  , MemberDTO member) throws Exception{
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:main";
	}
}
