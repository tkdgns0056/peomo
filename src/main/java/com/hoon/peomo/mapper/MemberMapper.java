package com.hoon.peomo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.hoon.peomo.model.Member;

@Mapper
public interface MemberMapper {
	
	//회원 가입
	public void memberJoin(Member member);
	
	//로그인
	public Member memberLogin(Member member);
}
