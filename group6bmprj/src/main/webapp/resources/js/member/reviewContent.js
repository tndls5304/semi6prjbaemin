     // 모든 이모지 버튼 요소를 선택
     const emojiButtons = document.querySelectorAll('.emoji-button');

     // 각 이모지 버튼에 클릭 이벤트 리스너 추가
     emojiButtons.forEach(button => {
         button.addEventListener('click', () => {
             // 모든 버튼에서 'active' 클래스를 제거
             emojiButtons.forEach(btn => btn.classList.remove('active'));
             // 클릭한 버튼에 'active' 클래스 추가
             button.classList.add('active');
         });
     });
     
     // 모든 옵션 버튼 요소를 선택
     const optionButtons = document.querySelectorAll('.option');
     // 선택된 옵션을 저장할 변수 선언
     let selectedOption = null;
     
     // 각 옵션 버튼에 클릭 이벤트 리스너 추가
     optionButtons.forEach(button => {
         button.addEventListener('click', () => {
             // 클릭한 옵션 버튼의 텍스트를 변수에 저장
             selectedOption = button.textContent;
             // 선택된 옵션을 로컬 스토리지에 저장
             localStorage.setItem('selectedOption', selectedOption);
         });
     });
     
     // '다음' 버튼에 클릭 이벤트 리스너 추가
     document.getElementById("nextButton").addEventListener("click", function() {
         // 'next_page.html'로 페이지 이동
         window.location.href = 'next_page.html';
     });
     