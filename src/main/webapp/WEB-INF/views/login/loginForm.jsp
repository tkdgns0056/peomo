<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberLogin" method="post">
	<div class="wrap">
		<div class="login">
			<h2>로그인</h2>
		</div>
		
		<div class="login_id">
			<h4>이메일</h4>
			<input type="email" name="memberEmail" id="email" placeholder="Email">
		</div>
		
		<div class="login_pw">
			<h4>비밀번호</h4>
			<input type="password" name="memberPw" id="password" placeholder="Password">
		</div>
		
		<div class="submit">
			<input type="submit" value="submit">
		</div>
	</div>
	</form>
	
</body>
</html>