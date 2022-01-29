package com.hoon.peomo.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hoon.peomo.model.Member;
import com.hoon.peomo.service.MemberService;


/* mvc2 흐름
 * Controller -> Service -> DAO -> DB
 * 
 * 컨트롤러의 중요한 역할중 하나는 HTTP 요청이 정상인지 검증하는 것이다.
 * 
 * 참고: 클라이언트 검증, 서버 검증
   클라이언트 검증은 조작할 수 있으므로 보안에 취약하다.
   서버만으로 검증하면, 즉각적인 고객 사용성이 부족해진다.
   둘을 적절히 섞어서 사용하되, 최종적으로 서버 검증은 필수
   API 방식을 사용하면 API 스펙을 잘 정의해서 검증 오류를 API 응답 결과에 잘 남겨주어야 함
 */


@Controller
@RequestMapping("/login")
public class LoginController {
	
//	@Autowired
//	private MemberService memberService;
//	
//	@RequestMapping("/memberLoginForm")
//	public String memberLoginForm() {
//		return "login/loginForm";
//	}


}
