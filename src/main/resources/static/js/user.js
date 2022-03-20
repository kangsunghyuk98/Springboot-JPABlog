let index = {
	init: function(){
		$("#btn-save").on("click", ()=>{ // function을 쓰지 않은 이유는 
			this.save(); // this를 바인딩 하기 위해서
		});
	},
	
	save: function() {
		let data ={
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		
		//ajax호출 시 default가 비동기 호출임 
		//ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청
		//ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환해줌
		$.ajax({
			// 회원가입 수행 요청
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), //http body data
			contentType: "application/json; charset=utf-8", //body data가 어떤 타입인지(MIME)
			dataType: "json" // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) javascript오브젝트로 변경해줌
 			// datatype 생략해도 자바 오브젝트로 변환해서 잘 해줌			
		}).done(function(resp){
			//성공
		alert("회원가입이 완료되었습니다.");
		console.log(resp);
		location.href="/";
		}).fail(function(error){
			// 실패
			alert(JSON.stringify(error));
			
		}); 
		
		},
	}

index.init();







