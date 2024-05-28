function showDetails() {
    var detailBlock = document.getElementById("detailBlock");
    if (detailBlock.style.display === "none" || detailBlock.style.display === "") {
        detailBlock.style.display = "block";
    } else {
        detailBlock.style.display = "none";
    }
}

document.getElementById("deleteButton").addEventListener("click", function() {
    if (confirm("정말로 삭제하시겠습니까?")) {
        // 사용자가 확인을 선택한 경우
        // 삭제 작업 실행
        deleteItem();
    } else {
        // 사용자가 취소를 선택한 경우
        // 아무런 작업도 하지 않음
    }
});

function deleteItem() {
    // 삭제 작업을 여기에 추가하세요
    alert("삭제요청중입니다.");
}


function detailDelete(){
    detailBlock.style.display="none";
}