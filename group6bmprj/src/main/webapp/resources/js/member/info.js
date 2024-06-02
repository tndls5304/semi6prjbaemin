
   
   // 배민페이 충전 함수
   function chargeBaeminPay() {
       var amount = parseInt(document.getElementById('amountInput').value);
       if (amount) {
           balance += amount;
           updateBalanceDisplay();
           alert(amount + "원이 성공적으로 충전되었습니다!");
           // 실제 충전 로직을 호출하는 코드를 여기에 추가
          
       } else {
           alert("충전 금액을 입력하세요.");
       }
   }
