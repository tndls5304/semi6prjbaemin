function checkDup(){
  const id = document.querySelector("input[name=id]").value;
  const obj = {
    url : "/baemin/member/id-dup" ,
    type : "get" ,
    data : {"id" : id} ,
    success : function(x){ 
      console.log( x );

      if( x === "good"){
        alert("사용 가능한 아이디 입니다 !!! ");
      }else{
        alert("중복된 아이디 입니다 ... ㅠㅠ");
      }
      
    } ,
    error : function( x ){ console.log("통신 실패 ..."); } ,
  };

  $.ajax( obj );
}
  // 폼 유효성 검사 함수
  
  
  function validateForm() {
    // 입력 필드에서 키를 누를 때 에러 메시지 숨기기
    document.getElementById('id').addEventListener('keydown', function() {
        hideErrorMessage('id-error');
    });
    document.getElementById('password').addEventListener('keydown', function() {
        hideErrorMessage('password-error');
    });
    document.getElementById('password2').addEventListener('keydown', function() {
        hideErrorMessage('password2-error');
    });
    document.getElementById('name').addEventListener('keydown', function() {
        hideErrorMessage('name-error');
    });
    document.getElementById('nickname').addEventListener('keydown', function() {
        hideErrorMessage('nickname-error');
    });
    document.getElementById('phone').addEventListener('keydown', function() {
        hideErrorMessage('phone-error');
    });
    document.getElementById('adress').addEventListener('keydown', function() {
        hideErrorMessage('address-error');
    });
    document.getElementById('detailadress').addEventListener('keydown', function() {
        hideErrorMessage('detail-address-error');
    });

    // 세대 선택 이벤트 리스너 추가
    document.getElementById('generation').addEventListener('change', function() {
        hideErrorMessage('gene-error');
    });

    // 파일 업로드 이벤트 리스너 추가
    document.getElementById('file-upload').addEventListener('change', function() {
        hideErrorMessage('file-error');
    });

    // 성별 라디오 버튼 선택 시 에러 메시지 숨기기
    document.querySelectorAll('input[name="gender"]').forEach(function(radio) {
        radio.addEventListener('change', function() {
            hideErrorMessage('gender-error');
        });
    });

    // 입력 값 가져오기
    var generation = document.getElementById('generation').value;
    var id = document.getElementById('id').value;
    var password = document.getElementById('password').value;
    var password2 = document.getElementById('password2').value;
    var name = document.getElementById('name').value;
    var nickname = document.getElementById('nickname').value;
    var phone = document.getElementById('phone').value;
    var address = document.getElementById('adress').value;
    var detailAddress = document.getElementById('detailadress').value;
    var gender = document.querySelector('input[name="gender"]:checked'); // 선택된 성별
    var fileUpload = document.getElementById('file-upload').value;
    var isValid = true;

// 비밀번호 확인 함수
function checkPassword() {
    var password1 = document.getElementById('password').value;
    var password2 = document.getElementById('password2').value;
    var passwordError = document.getElementById('password2-error');

    if (password1 !== password2) {
        passwordError.innerText = '비밀번호가 일치하지 않습니다.';
        return false; // 비밀번호가 일치하지 않으므로 false 반환
    } else {
        passwordError.innerText = ''; // 에러 메시지 숨기기
        return true; // 비밀번호가 일치하므로 true 반환
    }
}
   // 비밀번호 일치 여부 확인
   if (!checkPassword()) {
        isValid = false;
    }

    // 유효성 검사
    if (id.length < 4 || id.length > 10) {
        document.getElementById('id-error').innerText = '아이디는 4~10자여야 합니다.';
        isValid = false;
    }
    if (password.length < 4 || password.length > 10) {
        document.getElementById('password-error').innerText = '비밀번호는 4~10자여야 합니다.';
        isValid = false;
    }
    if (password2.length < 4 || password2.length > 10) {
        document.getElementById('password2-error').innerText = ' 비밀번호는 4~10자여야 합니다.';
        isValid = false;
    }
    if (name.length < 1 || name.length > 10) {
        document.getElementById('name-error').innerText = '이름은 1~10자여야 합니다.';
        isValid = false;
    }
    if (nickname.length < 1 || nickname.length > 10) {
        document.getElementById('nickname-error').innerText = '닉네임은 1~10자여야 합니다.';
        isValid = false;
    }
    if (phone.length != 11) {
        document.getElementById('phone-error').innerText = '전화번호는 11자여야 합니다.';
        isValid = false;
    }
    if (address.length < 10 || address.length > 20) {
        document.getElementById('address-error').innerText = '주소는 10~20자여야 합니다.';
        isValid = false;
    }
    if (detailAddress.length < 10 || detailAddress.length > 20) {
        document.getElementById('detail-address-error').innerText = '상세주소는 10~20자여야 합니다.';
        isValid = false;
    }
    if (!generation) {
        document.getElementById('gene-error').innerText = '세대를 선택해주세요.';
        isValid = false;
    }
    // 성별 선택 유효성 검사
    if (!gender) {
        document.getElementById('gender-error').innerText = '성별을 선택해주세요.';
        isValid = false;
    }
    if (!fileUpload) {
        document.getElementById('file-error').innerText = '유저 사진을 업로드해주세요.';
        isValid = false;
    }

    // 유효성 검사를 모두 통과하면 폼 제출
    if (isValid) {
       
        document.getElementById('signupForm').submit();
        
    }
}

// 에러 메시지 숨기기 함수
function hideErrorMessage(id) {
    document.getElementById(id).innerText = '';
}

// 파일 업로드 이미지 미리보기 함수
function previewImage(event) {
    var reader = new FileReader();
    reader.onload = function() {
        var output = document.createElement('img');
        output.src = reader.result;
        output.style.maxWidth = '200px'; // 이미지 미리보기의 최대 너비 설정
        var previewImageElement = document.getElementById('reviewPreviewImage');
        previewImageElement.innerHTML = ''; // 이전 미리보기 내용 삭제
        previewImageElement.appendChild(output); // 새로운 미리보기 이미지 추가
    };
    reader.readAsDataURL(event.target.files[0]);
}

var inputAddress=document.querySelector("#adress");
inputAddress.addEventListener("input", function()
{inputAddress.value = inputAddress.value.replace(/\s+/g,'')} );
