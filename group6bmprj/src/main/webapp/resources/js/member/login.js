function validateLogin() {

    document.getElementById('id').addEventListener('keydown', function() {
    hideErrorMessage('id-error');
});
document.getElementById('password').addEventListener('keydown', function() {
    hideErrorMessage('password-error');
});
      clearErrors();
      var id = document.getElementById('id').value;
      var password = document.getElementById('password').value;
      var isValid = true;

      if (id.length < 4 || id.length > 10) {
          document.getElementById('id-error').innerText = '아이디는 4~10자여야 합니다.';
          isValid = false;
      }
      if (password.length < 4 || password.length > 10) {
          document.getElementById('password-error').innerText = '비밀번호는 4~10자여야 합니다.';
          isValid = false;
      }

      if (isValid) {
          alert('로그인 성공');
          document.getElementById('loginForm').submit();
      
      } else {
        alert('로그인 실패');
    }
  }
  function hideErrorMessage(id) {
document.getElementById(id).innerText = '';
}

  function clearErrors() {
      document.getElementById('id-error').innerText = '';
      document.getElementById('password-error').innerText = '';
  }