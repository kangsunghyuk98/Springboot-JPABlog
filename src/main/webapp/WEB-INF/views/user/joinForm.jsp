<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="username">�̸�: </label> <input type="text" class="form-control" placeholder="�̸��� �Է��ϼ���(��: ���غ�)" id="username">
		</div>
		<div class="form-group">
			<label for="password">��й�ȣ:</label> <input type="password" class="form-control" placeholder="��й�ȣ�� �Է��ϼ���(��: ���غ�123)" id="password">
		</div>
		<div class="form-group">
			<label for="email">�̸���:</label> <input type="email" class="form-control" placeholder="�̸����� �Է��ϼ���(��: ���غ�@nexon.com)" id="email">
		</div>

	</form>
	<button id="btn-save" class="btn btn-primary">���� ����</button>
</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>


