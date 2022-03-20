<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">

		<button class="btn btn-secondary" onclick="history.back()">���ư���</button>
	<c:if test="${ board.user.id == principal.user.id}">
		<a href="/board/${board.id }/updateForm" class="btn btn-dark">����</a>
		<button id="btn-delete" class="btn btn-dark">����</button>
	</c:if>

	<br/><br/>
		<div>
			�� ��ȣ : <span id= "id"><i>${board.id}</i> </span>
			�ۼ��� : <span><i>${board.user.username} </i></span>
		</div>
		<br/>
	<div class="form-group">
		<hr />
		<h3>${board.title}</h3>
	</div>
	<div class="form-group">
		<hr />
		<div>${board.content}</div>
	</div>
	<hr />
</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>


