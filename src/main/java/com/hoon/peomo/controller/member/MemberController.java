package com.hoon.peomo.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoon.peomo.model.Member;
import com.hoon.peomo.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping(value ="/member")
@Slf4j
public class MemberController {
	
	@Autowired
    private MemberService memberService;
	
	//회원가입 페이지 이동
	@RequestMapping(value="join", method = RequestMethod.GET)
	public void joinGET() {
		
		log.info("회원가입 페이지 진입");
	}
	
	//회원가입
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String joinPOST(Member member) {
		log.info("join 진입");
		
		//회원가입 서비스 실행
		memberService.memberJoin(member);
		
		return "redirect:/main";
	}
	
	//로그인 페이지 이동
	@RequestMapping(value="login", method = RequestMethod.GET)
	public void loginGet() {
		
		log.info("로그인 페이지 진입");
	}
	
	

}
