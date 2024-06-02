

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

