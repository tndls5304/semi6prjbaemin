<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- css -->
    <link rel="stylesheet" href="./review2.css">
    <title>리뷰 작성 페이지</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="content">
        <h1><a href="/home" class="custom-link">x</a></h1>
        <!-- 뒤로가기링크 -->
        
        <!-- 가게이름 -->
        <div class="tiltename"><h1>가게이름</h1></div>
        
        <!-- 별점 -->
        <div class="starlating">별점</div>
        
        <!-- 리뷰 폼 시작 -->
        <form action="/examples/media/action_target.php" method="post" enctype="multipart/form-data">
            <label for="opinion"><h2>리뷰내용을 입력해주세요:</h2></label>
            <div class="area">
                <textarea name="opinion" id="opinion" cols="70" rows="7" oninput="updateCharCount(this)"></textarea>
                <div class="char-count">0 / 16</div>
            </div>
            
            <!-- 리뷰사진 업로드 -->
            <label for="file-upload" class="custom-file-upload">
                <label for="company-pic"><h3>리뷰사진 선택</h3></label>
            </label>
            <input id="file-upload" type="file" name="review_image" multiple/>
            <div>&nbsp</div>
            <!-- 선택된 메뉴 -->
            <div class="chucheon"><h2>당신이 드신 음식🍖</h2></div>
            <div class="menuselect"><h3>선택된 메뉴</h3></div>
            
            <!-- 완료 버튼 -->
            <button type="submit" class="next-button">완료</button>
        </form>
    </div>

    <script>
        // 문자 수 세는 함수
        function updateCharCount(textarea) {
            var charCount = textarea.value.length;
            var charCountElement = textarea.nextElementSibling;
            charCountElement.textContent = charCount + " / 16";

            if (charCount > 16) {
                charCountElement.classList.add("error");
                textarea.value = textarea.value.slice(0, 16); // 
            } else {
                charCountElement.classList.remove("error");
            }
        }
    </script>
</body>
</html>
