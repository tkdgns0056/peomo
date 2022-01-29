package com.hoon.peomo.service;

import com.hoon.peomo.model.Member;

public interface MemberService {

	public Member memberLogin(Member member);
	
	public void memberJoin(Member member);


}
