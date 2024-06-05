

const  storeInfoTab=document.getElementById("storeInfoTab");
const reviewTab= document.getElementById("reviewTab");
const menuTab=document.getElementById("menuTab");


var menuTabContent = document.getElementById("menuTab-content");
var reviewTabContent = document.getElementById("reviewTab-content");
var storeInfoTabContent = document.getElementById("storeInfoTab-content");


menuTab.addEventListener("click", function() {
  if (menuTabContent.style.display =="none") {
    menuTabContent.style.display = "block";
      storeInfoTabContent.style.display = "none";
      reviewTabContent.style.display = "none";
    }
});




  storeInfoTab.addEventListener("click", function() {


    storeInfoTabContent.style.display = "block"
    menuTabContent.style.display = "none"
      reviewTabContent.style.display = "none";

});


 
  reviewTab.addEventListener("click", function() {

    menuTabContent.style.display = "none"
    storeInfoTabContent.style.display = "none"
    reviewTabContent.style.display = "block";

});


//장바구니에 담기
function addCart(foodNo){
 console.log("장바구니버튼 누름? ");;
	var countInputPlace=document.querySelector("#countInputPlace");
	var foodCount=countInputPlace.value;
	
	$.ajax({
		
		url: '/baemin/member/addcart',
        type: 'POST',
        data: {foodNo:foodNo,foodCount:foodCount},
        
        success: function(result) {
		
            alert('장바구니 담기 성공!');
        },
        error: function(error) {
			alert("장바구니 추가중 통신실패")

        }

	})
}

