function showDetails() {
	//로컬스토리지에서 빼내서 제이슨형태의 객체로 만들어주기
	const str = localStorage.getItem("localMemberVoStr");
	const memberVo = JSON.parse(str);
	var detailBlock = document.getElementById("detailBlock");
	if (detailBlock.style.display === "none" || detailBlock.style.display === "") {
		detailBlock.style.display = "block";
		
		const detailContent=document.querySelector(".detail-content")
		let str = "";
				str += "<p>회원 아이디:"+memberVo.id+"</p>";
				str += "<p>회원주소:" + memberVo.address +"</p>";
				str += "<p>상세주소:" + memberVo.addressdDetail+"</p>";
				str += "<p>연락처:" +memberVo.phone+ "</p>";
				str += "<p>배민페이잔액:" +memberVo.accountBalance+ "</p>";
				str += "<p>연령대:" +memberVo.generation+ "</p>";
				str += "<p>성별:" +memberVo.gender+ "</p>";
	
			detailContent.innerHTML=str;
	} else {
		detailBlock.style.display = "none";
	}
}



function deleteButton(){
	if (confirm("정말로 삭제하시겠습니까?")) {
		// 사용자가 확인을 선택한 경우
		// 삭제 작업 실행
		deleteItem();
	} else {
		// 사용자가 취소를 선택한 경우
		// 아무런 작업도 하지 않음
	}
	
}

function deleteItem() {
	// 삭제 작업을 여기에 추가
	const str = localStorage.getItem("localMemberVoStr");
	const memberVo = JSON.parse(str);
	var memberId=memberVo.id
	
		
	$.ajax({
		
		url: "/baemin/admin/delete_user"
		, method: "POST"
		, data: {"memberId":memberId}
		, success: function(response) {
			console.log("통신성공!");
			if(response==="success"){
				alert("삭제완료!");
				var memberTbody=document.querySelector("#memberTbody").value;
				memberTbody="";		
			}else{
				alert("삭제실패!");
			}
			
			
		
		},
		fail: function(error) {
			console.log(error);
				alert("삭제실패 통신실패...관리자에게 문의해주세요!");
		}
		
	});
	
}


function detailDelete() {
	detailBlock.style.display = "none";
}

//회원 전체조회 ( 아이디로 조회)------------------------------

function adminSearchMember() {
	memberTbody.innerHTML = "";

	// 검색어 입력란의 값을 가져옴
	const searchUserIdValue = document.querySelector('#searchUserIdValue').value;

	// 탈퇴 여부 선택값을 가져옴
	const delYn = document.querySelector('select[name="del_yn"]').value;

	// AJAX 요청을 보낼 데이터객체 만들기
	const requestData = {
		searchUserIdValue: searchUserIdValue,
		delYn: delYn
	}

	$.ajax({

		url: "/baemin/admin/get_user/byid"
		, method: "GET"
		, data: requestData
		, success: function(memberVo) {
			console.log("memberVo : " , memberVo);
			
			//응답받은건 문자열이다!! 객체로 변환해주는 JSON.parse(response)
			//const memberVo = JSON.parse(response);
			
		console.log(memberVo);
		console.log(memberVo.id);
		console.log(memberVo.name);
		console.log(memberVo.nick);
		
		localStorage.setItem("localMemberVoStr" , JSON.stringify(memberVo));
	
			const memberTbody = document.querySelector("#memberTbody");
			
			const memberVoStr = JSON.stringify(memberVo);
			console.log("memberVoStr : " , memberVoStr);
			
			let str = "";
				str += "<tr>";
				str += "<td>" + memberVo.id + "</td>";
				str += "<td>" + memberVo.name + "</td>";
				str += "<td>" + memberVo.nick+ "</td>";
				str += '<td><button onclick="showDetails()";>계정상세조회</button></td>';
				str += '<td><button onclick="deleteButton()"class="delete-Button">계정삭제하기</button></td>';
				str += "</tr>";
	
			memberTbody.innerHTML=str;
		
		},
		fail: function(error) {
			console.log(error);
		}
	});
}