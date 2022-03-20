<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">

	<form>
	<input type="hidden"  id="id" value="${board.id}"/>
		<div class="form-group">
			<input value="${board.title}" type="text"  class="form-control"  id="title">
		</div>
		
<div class="form-group">
  <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
</div>
	</form>
	<button id="btn-update" class="btn btn-primary">글 수정 완료</button>
</div>

<script>
	$('.summernote').summernote({
		placeholder : '호오, 시버럴, ㅗ, ㅡㅡ,  ㅋㅎ , 하랑님 눈나 찾기 금지',
		tabsize : 2,
		height : 300
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>


