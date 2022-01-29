package com.hoon.peomo.model;

import lombok.Getter;
import lombok.Setter;

/*
 * 롬복을 이용해 @Data 어노테이션을 쓸 경우
 * 다른 클래스에서 Member의 getter가 안된다.
*/

@Getter
@Setter
public class Member {
	
	private String memberEmail;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAddr;
	private String memberPhone;
	private String loginType;
	private int adminCk;
	

}
