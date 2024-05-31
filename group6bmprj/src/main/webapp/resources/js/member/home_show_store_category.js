 function trychangeAddress(){
  var changeAddressBlock=document.querySelector("#changeAddress-block");
   if (changeAddressBlock.style.display === "none" || changeAddressBlock.style.display === "") {
    changeAddressBlock.style.display = "block";
  }
}

//주소적는란에 띄어쓰기 아예불가능을 만듬
var inputAddress=document.querySelector("#input-address");
inputAddress.addEventListener("input", function()
{inputAddress.value = inputAddress.value.replace(/\s+/g,'')} );




	//상세주소는 서블릿에 요청보내기전에 트림적용
	var inputAddressDetail=document.querySelector("#input-addressDetail");
	inputAddressDetail.addEventListener("keyup",function(){
		inputAddressDetail.value=inputAddressDetail.value.trim();	
	
	})



//주소바꾸기 취소버튼
function cancelAddressChange(){
	console.log("yes")
	var changeAddressBlock=document.querySelector("#changeAddress-block");
changeAddressBlock.style.display = "";
}

