function changeOrderStatus(button, newStatus) {
    var row = button.closest('tr');
    var statusCell = row.querySelector('.order-status');
    statusCell.textContent = newStatus;
}

function filterOrders() {
    var inputDate = document.getElementById('order-date').value;
    var inputStatus = document.getElementById('generation').value;
    var rows = document.querySelectorAll('table tr');

    rows.forEach(function(row, index) {
        if (index === 0) return; // Skip header row
        var date = row.getAttribute('data-date');
        var status = row.querySelector('.order-status').textContent;
        
        var dateMatch = !inputDate || date === inputDate;
        var statusMatch = !inputStatus || status === inputStatus;
        
        if (dateMatch && statusMatch) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}

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
        deleteItem();
    }
});

function deleteItem() {
    alert("삭제되었습니다.");
}

function detailDelete() {
    var detailBlock = document.getElementById("detailBlock");
    detailBlock.style.display = "none";
}