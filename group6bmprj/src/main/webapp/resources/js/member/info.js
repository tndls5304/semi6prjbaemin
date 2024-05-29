   // 초기 잔액 설정
   let balance = 0;

   // 잔액을 업데이트하고 화면에 표시하는 함수
   function updateBalanceDisplay() {
       document.getElementById('balanceAmount').innerText = balance;
   }
   
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
   
   // 페이지 로드 시 초기 잔액 표시
   updateBalanceDisplay(); // 초기 잔액을 화면에 표시합니다.