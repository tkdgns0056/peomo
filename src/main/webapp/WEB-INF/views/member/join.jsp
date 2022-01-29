<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous">
</script>
</head>
<body>

<div class="wrapper">
	<form id="join_form" method="post">
	<div class="wrap">	
		<div class="subject">
			<span>회원가입</span>
		</div>
		<div class="id_wrap">
			<div class="id_name">아이디</div>
			<div class="id_input_box">
				<input class="id_input" name="memberId">
			</div>
		</div>
		
		<div class="pw_wrap">
				<div class="pw_name">비밀번호</div>
				<div class="pw_input_box">
					<input class="pw_input" name="memberPw">
				</div>
		</div>
		
		<div class="join_button_wrap">
			<input type="button" class="join_button" value="가입하기">
		</div>
		
		</div>
	</form>
</div>

<script>
	
	$(document).ready(function(){
		//회원가입 버튼(회원가입 기능 작동)
		$(".join_button").click(function(){
			$("#join_form").attr("action", "/member/join");
			$("#join_form").submit();
		
		});
	});
	
</script>

</body>
</html>