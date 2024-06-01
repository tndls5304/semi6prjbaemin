function trychangeAddress() {
	var changeAddressBlock = document.querySelector("#changeAddress-block");
	if (changeAddressBlock.style.display === "none" || changeAddressBlock.style.display === "") {
		changeAddressBlock.style.display = "block";
	}
}

//주소적는란에 띄어쓰기 아예불가능을 만듬
var inputAddress = document.querySelector("#input-address");
inputAddress.addEventListener("input", function() { inputAddress.value = inputAddress.value.replace(/\s+/g, '') });




//상세주소는 서블릿에 요청보내기전에 트림적용
var inputAddressDetail = document.querySelector("#input-addressDetail");
inputAddressDetail.addEventListener("keyup", function() {
	inputAddressDetail.value = inputAddressDetail.value.trim();

})



//주소바꾸기 취소버튼
function cancelAddressChange() {
	console.log("yes")
	var changeAddressBlock = document.querySelector("#changeAddress-block");
	changeAddressBlock.style.display = "";
}

//가게종목 이미지 클릭하면 번호 전해주기 
function sendStoreCategoryNo(storeCategoryNo,storeCategoryName) {
	// 서블릿으로 GET 요청을 보내는 URL 구성
	var url = '/baemin/member/search_store_by_basic?storeCategoryNo=' + storeCategoryNo+'&storeCategoryName='+storeCategoryName;
	// 현재 페이지를 해당 URL로 리디렉션
	window.location.href = url;
}
