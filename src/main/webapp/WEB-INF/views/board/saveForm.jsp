<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">

	<form>
		<div class="form-group">
			<input type="text"  class="form-control"  id="title">
		</div>
		
<div class="form-group">
  <textarea class="form-control summernote" rows="5" id="content"></textarea>
</div>
	</form>
	<button id="btn-save" class="btn btn-primary">글 등록</button>
</div>

<script>
	$('.summernote').summernote({
		placeholder : '호오, 시버럴, ㅗ, ㅡㅡ,  ㅋㅎ 금지',
		tabsize : 2,
		height : 300
	});
</script>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>


