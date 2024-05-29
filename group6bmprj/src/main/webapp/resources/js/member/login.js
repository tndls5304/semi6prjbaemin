document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('id').addEventListener('keydown', function() {
        hideErrorMessage('id-error');
    });
    document.getElementById('password').addEventListener('keydown', function() {
        hideErrorMessage('password-error');
    });
});

function validateLogin() {
    // Clear previous error messages
    clearErrors();

    var id = document.getElementById('id').value;
    var password = document.getElementById('password').value;

   

    if (id.length < 4 || id.length > 10) {
        document.getElementById('id-error').innerText = '아이디는 4~10자여야 합니다.';
        document.getElementById('id-error').style.display = 'block';
        
    }
    if (password.length < 4 || password.length > 10) {
        document.getElementById('password-error').innerText = '비밀번호는 4~10자여야 합니다.';
        document.getElementById('password-error').style.display = 'block';
        
    }

}

function hideErrorMessage(id) {
    var element = document.getElementById(id);
    element.innerText = '';
    element.style.display = 'none';
}

function clearErrors() {
    var errorMessages = document.getElementsByClassName('error-message');
    for (var i = 0; i < errorMessages.length; i++) {
        errorMessages[i].innerText = '';
        errorMessages[i].style.display = 'none';
    }
}