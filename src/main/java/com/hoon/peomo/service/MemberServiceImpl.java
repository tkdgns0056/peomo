package com.hoon.peomo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hoon.peomo.mapper.MemberMapper;
import com.hoon.peomo.model.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public Member memberLogin(Member member) {
		
		return memberMapper.memberLogin(member);
	}

	@Override
	public void memberJoin(Member member) {
		
	}
	
	
	

}
