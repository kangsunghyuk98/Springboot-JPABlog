<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">�̸�: </label> 
			<input type="text" name="username" class="form-control" placeholder="�̸��� �Է��ϼ���" id="username">
		</div>
		<div class="form-group">
			<label for="password">��й�ȣ:</label>
			 <input type="password" name="password" class="form-control" placeholder="��й�ȣ�� �Է��ϼ���" id="password">
		</div>
				<button id="btn-login" class="btn btn-primary">�α���</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>


