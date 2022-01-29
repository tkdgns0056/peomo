package com.hoon.peomo.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@RequestMapping("/main")
	public String main() {
		
		log.info("메인페이지 진입");
		
		return "main";
	}
}
