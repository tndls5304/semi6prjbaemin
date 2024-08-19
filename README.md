# BaeMin

## 🧱 프로젝트 설계

### ERD :첫과제라 디비 모델링은 파트를 나누지 않고 다 같이 하였다

![image](https://github.com/user-attachments/assets/711f6907-6aaf-4aae-823e-2f2633f7f30d)

## 이수인 : 담당 기능

### 사장님의 음식 등록,편집 : 음식 카테고리 등촉,추가,수정,삭제 / 카테고리 하위의 음식정보 추가

### 일반회원 : 주소설정, 음식카테고리별로 홈화면 보기, 카테고리 별로 가게 조회 , 가게 상세조회, 음식 장바구니 추가

### 사장님, 일반회원 회원가입, 로그인

### 관리자 :일반회원 계정 검색, 상세보기, 계정 삭제

---

### 🔸회원화면 일식 버튼 눌렀을때 일식 가게들의 정보
![image](https://github.com/user-attachments/assets/4787b3f2-6e55-413b-b9f3-9874fd0f2ff7)

### 🔸위 화면에서 각 가게마다 음식사진을 4개만 설정하기 위해서 고민을 해봤다
![image](https://github.com/user-attachments/assets/de9ce2c0-6086-4c1e-8066-7de0e715f66e)
![image](https://github.com/user-attachments/assets/4ee319f6-b491-4832-980b-3ebb2585498d)
![image](https://github.com/user-attachments/assets/d970ae2f-629e-4aaa-b030-c2953ba15adb)


단순히 사용자와 가게의 영업 주소가 일치하는 가게를 조회 해오는데 그치지 않고 여러 필터링을 통해 (운영 중인 식당만 조회, 현재 시간이 휴식 시간 외에 있는 식당,식당의 휴무일이 없거나, 오늘이 휴무일이 아닌 식당 등 )
<br>
서브쿼리를 이용해 조회하는 쿼리문을 작성하였다.

---

### 🔸사장님의 파는 음식 등록 :편집 페이지
![image](https://github.com/user-attachments/assets/e72cb512-4bcb-4d08-a635-2c300c883267)


카테고리 등록,추가,삭제,수정 가능
<br>
카테고리 하위에 음식 메뉴 추가 가능

---

### 🔸회원화면 (주소 재 설정, 음식 카테고리 선택)

![image](https://github.com/user-attachments/assets/f2d3f416-da7c-4506-a05d-11849ab82fc1)

---

### 🔸회원화면 (가게 하나를 클릭했을때 보이는 화면) :장바구니 추가 가능

![image](https://github.com/user-attachments/assets/f4148ef5-f746-4a8c-b6b4-2d4a08e1a917)


### 🔸관리자 화면 회원 검색, 상세보기, 계정삭제하기 (모두ajax로)

https://github.com/user-attachments/assets/1491a6b3-f11b-4aa7-8b7c-534a8591cdf9

---

# 배민으로 전통적인 서블릿 처리 방식 (Eclipse에서 실행)으로 작업해보고 추후에 스프링부트로 작업 한 뒤 차이점에 대해 정리

## 전통적인 서블릿 방식

컨트롤러: 요청을 처리하는 서블릿 클래스는 HttpServlet을 상속받아 doGet, doPost 메서드를 구현해야 한다. 요청에 대한 처리는 서블릿 클래스 내부에서 직접 구현해야 했다.
<br>
각 서블릿 클래스는 별도의 인스턴스로 생성되며, 요청 URL에 따라 서블릿이 직접 처리한다.
<br>
라이브러리 관리: 각종 라이브러리를 수동으로 관리해야 하며, 의존성 관리가 번거롭다.
<br>
서블릿 인스턴스가 여러 개일 수 있으며, URL 패턴에 따라 서블릿을 직접 설정하고 요청을 처리한다.
<br>
서블릿 설정은 web.xml 파일에서 이루어진다.서블릿 매핑, 초기화 파라미터, 리스너, 필터 등을 설정할 수 있는데. web.xml이 커지면 관리가 복잡해질 수 있다

## 스프링은

https://github.com/user-attachments/assets/d5404042-f6b1-495b-b663-cfaa538a95f0

컨트롤러: 스프링 부트에서는 @Controller 또는 @RestController 어노테이션을 사용하여 컨트롤러를 정의한다.
<br>
메서드에 @RequestMapping, @GetMapping, @PostMapping 등의 어노테이션을 사용하여 요청을 매핑한다.이로 인해 요청 처리가 간결하고 명확해짐.
<br>
스프링부트로 작업하면 모든 HTTP 요청은 DispatcherServlet을 통해 중앙에서 처리한다.
<br>
서블릿 초기화: 서블릿 초기화는 init 메서드에서 이루어진다. 서블릿이 처음 로드될 때 한 번만 호출된다

---

# 📚 기술 스택 📚

✨ 플랫폼 & 언어 ✨

https://github.com/user-attachments/assets/21e67bd2-b816-4b16-86bb-0cb5b83d1997

🛠 사용 툴 🛠

https://github.com/user-attachments/assets/2601a8c3-fe2e-42d6-bb59-bd1f366c410a

# 프로젝트 소개 : 배달 어플

https://github.com/user-attachments/assets/c0645535-5975-4114-ac52-8df3c3d0294c

---

# 📅 프로젝트 기간

2024-04-29 ~ 2024-06-03

---
