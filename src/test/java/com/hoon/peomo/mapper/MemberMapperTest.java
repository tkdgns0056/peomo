package com.hoon.peomo.mapper;




import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hoon.peomo.model.Member;

@SpringBootTest
public class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;  //MemberMapper.java 인터페이스 의존성 주입
		
	//회원가입 쿼리 테스트 메서드
	@Test
	public void memberJoin() {
		Member member = new Member();
		
		member.setMemberId("test"); //회원 아이디
		member.setMemberPw("test"); //회원 비밀번호
		
		memberMapper.memberJoin(member); //쿼리 메서드 실행
	   //System.out.println("memberId :" + member.getMemberId() + "memberPw : " + member.getMemberPw());
	}
}


