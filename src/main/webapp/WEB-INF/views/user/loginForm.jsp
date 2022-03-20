<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">이름: </label> 
			<input type="text" name="username" class="form-control" placeholder="이름을 입력하세요" id="username">
		</div>
		<div class="form-group">
			<label for="password">비밀번호:</label>
			 <input type="password" name="password" class="form-control" placeholder="비밀번호를 입력하세요" id="password">
		</div>
				<button id="btn-login" class="btn btn-primary">로그인</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>


