let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ // function을 쓰지 않은 이유는 
			this.save(); // this를 바인딩 하기 위해서
		});
		$("#btn-delete").on("click", ()=>{ // function을 쓰지 않은 이유는 
			this.deleteById(); // this를 바인딩 하기 위해서
		});
		$("#btn-update").on("click", ()=>{ // function을 쓰지 않은 이유는 
			this.update(); // this를 바인딩 하기 위해서
		});
	},
	
	save: function() {
		let data ={
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
			dataType: "json" 		
		}).done(function(resp){
			//성공
		alert("글쓰기가 완료되었습니다. 풀떼기 바보입니다.");
		console.log(resp);
		location.href="/";
		}).fail(function(error){
			// 실패
			alert(JSON.stringify(error));
			
		}); 
		
		},
		
		deleteById: function() {
			let id = $("#id").text();
			
		$.ajax({
			type: "DELETE",
			url: "/api/board/"+id,
			dataType: "json" 		
		}).done(function(resp){
		    alert("글이 삭제되었습니다. 풀떼기 탈모입니다.");
	        console.log(resp);
		    location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
		},
		
		update: function() {
		let id = $("#id").val();	
			
			
		let data ={
			title: $("#title").val(),
			content: $("#content").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/api/board/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
			dataType: "json" 		
		}).done(function(resp){
			//성공
		alert("글수정이 완료되었습니다. 풀떼기 화이팅입니다.");
		console.log(resp);
		location.href="/";
		}).fail(function(error){
			// 실패
			alert(JSON.stringify(error));
			
		}); 
		
		}
		
		
	}

index.init();







