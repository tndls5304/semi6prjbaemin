<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 글씨체 -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: rgb(247, 237, 244);
            display: flex;
            justify-content: center;
            align-items: flex-start; 
            font-family: "Jua", sans-serif;
            font-weight: 500;
            font-style: normal;
        }

        .content {
            width: 715px;
            height: 100vh;
            background-color: rgb(252, 246, 247);
            display: grid;
            grid-template-rows: 1fr 10fr 1fr;
        }

        aside {
            background-color: white;
            width: 200px;
            padding: 20px;
            position: fixed;
            left: 0;
            top: 0;
            bottom: 0;
        }

        aside nav ul {
            list-style: none;
            padding: 0;
        }

        aside nav ul li a {
            display: block;
            padding: 10px;
            color: black;
            text-decoration: none;
        }

        main {
            flex-grow: 1;
            padding: 20px;
            margin-left: 240px;
            width: 100%; 
        }

        .tab-container {
            width: 100%;
            max-width: 600px; 
            margin: 0 auto;
            padding: 20px;
            border-radius: 8px;

        }

        .container-box{
            background-color: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            padding: 25px;
        }


        .tabs {
            display: flex;
            justify-content: center; /* 중앙 정렬 */
            gap: 100px; /* 버튼 사이의 거리 설정 */
            margin-bottom: 20px;
        }

        .tabs button {
            position: relative; /* ::after 가상 요소를 사용하기 위해 필요 */
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
            font-family: "Jua", sans-serif;
            font-weight: 500;
            font-style: normal;
            font-size: 16px;
            background-color: rgb(247, 237, 244);
            color: black;
        }

        .tabs button::after {
            content: "";
            position: absolute;
            bottom: -2px; /* 텍스트 바로 아래에 밑줄 위치 */
            left: 50%;
            transform: translateX(-50%);
            width: 0;
            height: 2.5px;
            background-color: black;
            transition: width 0.3s;
        }

        .tabs button.active::after {
            width: 100%; /* 활성화된 버튼에 밑줄 추가 */
        }

        .tabs button.active {
            background-color: rgb(247, 237, 244);
        }

        .tab-content {
            display: none;
        }

        .tab-content.active {
            display: block;
        }

        .info-block {
            margin-bottom: 20px;
        }

        .info-block div {
            margin-bottom: 10px;
        }

        .info-block div label {
            font-weight: bold;
            display: block;
        }

        .edit-btn {
            display: inline-block;
            margin-left: 10px;
            cursor: pointer;
            color: blue;
        }

        .edit-input {
            display: none;
            margin-top: 10px;
        }

        .save-btn {
            margin-left: 10px;
            cursor: pointer;
            color: green;
        }
    </style>
</head>
<body>
    <aside>
        <nav>
            <ul>
                
                <li><a href=""><h1>사장님 페이지</h1></a></li>
                <li><a href="">스토어 허가 신청</a></li>
                <li><a href="">주문관리🕗</a></li>
                <li><a href="">스토어 관리</a></li>
                <li><a href="">회원관리</a></li>
                <li><a href="">음식메뉴편집</a></li>
                <li><a href="">매출관리</a></li>
                <li><a href="">리뷰관리</a></li>
                <li><a href="">
                 <button>로그아웃</button></a></li>

            </ul>
        </nav>
    </aside>

    <main>
        <div class="header">
            <h2>가게 관리</h2>
        </div>
        <div class="tab-container">
            <div class="tabs">
                <button class="tab-button active" onclick="showTab('basic-info')">기본 정보</button>
                <button class="tab-button" onclick="showTab('operational-info')">운영 정보</button>
            </div>
            <div id="basic-info" class="tab-content active">
                <div class="info-block">
                    <div class="container-box">
                        <label>가게 번호:</label>
                        <p>${storeInfor.no}</p>
                    </div><br>
                    <div class="container-box">
                        <label>가게 이름:</label>
                        <p>${storeInfor.name}</p>
                    </div>
                    <br>
                    <div class="container-box">
                        <label>가게 카테고리:</label>
                        <p>${storeInfor.storeCategoryName}</p>
                    </div>
                    <br>
                    <div class="container-box">
                        <label>가게 주소:</label>
                        <p>${storeInfor.address}</p>
                    </div>
                    <br>
                    <div class="container-box">
                        <!--브레이크 상태 혹은 휴무일에는 Closed로 표시-->
                        <label>가게 상태:</label>
                        <p id="store-status">
                        <p id="open-yn" >${storeInfor.openYn == 'Y' ? '오픈' : '미오픈'}
                        <span class="edit-btn" onclick="editInfo('open-yn')">변경</span></p>
                        <div class="edit-input" id="edit-open-yn">
                        <input type="text" id="new-open-yn" value="${storeInfor.openYn}">
                        <span class="save-btn" onclick="saveInfo('openYn', 'open-yn')">저장</span>
                        </div>
                    </div>
                    <br>
                    <div class="container-box">
                    <label>사장 전화번호:</label>
                    <p id="owner-phone">
                        ${storeInfor.storeOwnerPhone}
                    <span class="edit-btn" onclick="editInfo('owner-phone')">변경</span></p>
                    <div class="edit-input" id="edit-owner-phone">
                    <input type="text" id="new-owner-phone" value="${storeInfor.storeOwnerPhone}">
                    <span class="save-btn" onclick="saveInfo('storeOwnerPhone', 'owner-phone')">저장</span>
                    </div>
                    </div>
                    <br>
                    <div class="container-box">
                        <label>가게 전화번호:</label>
                        <p id="store-phone">
                            ${storeInfor.phone}
                        <span class="edit-btn" onclick="editInfo('store-phone')">변경</span></p>
                        <div class="edit-input" id="edit-store-phone">
                            <input type="text" id="new-store-phone" value="${storeInfor.phone}">
                            <span class="save-btn" onclick="saveInfo('phone', 'store-phone')">저장</span>
                        </div>
                    </div>
                    <br>
                    <div class="container-box">
                        <label>가게 소개:</label>
                        <p id="store-description">${storeInfor.introduce} <span class="edit-btn" onclick="editInfo('store-description')">변경</span></p>
                        <div class="edit-input" id="edit-store-description">
                            <input type="text" id="new-store-description" value="${storeInfor.introduce}">
                            <span class="save-btn" onclick="saveInfo('introduce' ,'store-description')">저장</span>
                        </div>
                    </div>
                    <br>
<%--                    <div class="container-box">--%>
<%--                        <label>비밀번호:</label>--%>
<%--                        <p id="password">*** <span class="edit-btn" onclick="editInfo('password')">변경</span></p>--%>
<%--                        <div class="edit-input" id="edit-password">--%>
<%--                            <input type="password" id="new-password" value="">--%>
<%--                            <span class="save-btn" onclick="saveInfo('password')">저장</span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
            <div id="operational-info" class="tab-content">
                <div class="info-block">
                    <div class="container-box">
                        <label>영업 시간:</label>
                        <p id="operating-hours">${storeInfor.openTime} - ${storeInfor.endTime} <span class="edit-btn" onclick="editInfo('operating-hours')">변경</span></p>
                        <div class="edit-input" id="edit-operating-hours">
                            <input type="text" id="new-operating-hours-start" value="${storeInfor.openTime}" > - <input type="text" id="new-operating-hours-end" value="${storeInfor.endTime}">
                            <span class="save-btn" onclick="saveInfo('operating-hours','operating-hours')">저장</span>
                        </div>
                    </div>
                    <br>
                    <div class="container-box">
                        <label>휴게 시간:</label>
                        <p id="break-time">${storeInfor.breakTimeStart} - ${storeInfor.breakTimeEnd} <span class="edit-btn" onclick="editInfo('break-time')">변경</span></p>
                        <div class="edit-input" id="edit-break-time">
                            <input type="text" id="new-break-time-start" value="${storeInfor.breakTimeStart}"> - <input type="text" id="new-break-time-end" value="${storeInfor.breakTimeEnd}">
                            <span class="save-btn" onclick="saveInfo('break-time','break-time')">저장</span>
                        </div>
                    </div>
                    <br>
                    <div class="container-box">
                        <label>휴무일:</label>
                        <p id="closed-days">
                            <%-- fmt yyyy-mm-dd --%>


                            <c:forEach items="${closedDays}" var="closedDay" varStatus="status">
                                <span> 휴무일 ${status.count}: ${closedDay.day}</span>
                                <br>
                            </c:forEach>
                        <span class="edit-btn" onclick="editInfo('closed-days')">변경</span></p>
                        <div class="edit-input" id="edit-closed-days">

                            <div id="new-closed-days">
                                <c:forEach var="i" begin="1" end="5">
                                    <br>
                                    휴무일 ${i}
                                    <input type="text" id="new-closed-days-${i}" value="<c:out value='${closedDays[i-1].day}' default=''/>" />
                                    <br>
                                </c:forEach>

                            </div>
<%--                            <select id="new-closed-days" multiple>--%>
<%--                                <option value="Sunday">Sunday</option>--%>
<%--                                <option value="Monday">Monday</option>--%>
<%--                                <option value="Tuesday">Tuesday</option>--%>
<%--                                <option value="Wednesday">Wednesday</option>--%>
<%--                                <option value="Thursday">Thursday</option>--%>
<%--                                <option value="Friday">Friday</option>--%>
<%--                                <option value="Saturday">Saturday</option>--%>
<%--                            </select>--%>
                            <span class="save-btn" onclick="saveInfo('closed-days', 'closed-days')">저장</span>
                        </div>
                    </div>
                    <br>
<%--                    <div class="container-box">--%>
<%--                        <label>배달 팁:</label>--%>
<%--                        <p id="delivery-tip">Loading... <span class="edit-btn" onclick="editInfo('delivery-tip')">변경</span></p>--%>
<%--                        <div class="edit-input" id="edit-delivery-tip">--%>
<%--                            <input type="text" id="new-delivery-tip" value="">--%>
<%--                            <span class="save-btn" onclick="saveInfo('delivery-tip')">저장</span>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <br>--%>
                    <div class="container-box">
                        <label>최소 주문 금액:</label>
                        <p id="minimum-order-amount">${storeInfor.minimumOrderAmount} <span class="edit-btn" onclick="editInfo('minimum-order-amount')">변경</span></p>
                        <div class="edit-input" id="edit-minimum-order-amount">
                            <input type="text" id="new-minimum-order-amount" value="${storeInfor.minimumOrderAmount}">
                            <span class="save-btn" onclick="saveInfo('minimumOrderAmount', 'minimum-order-amount')">저장</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            fetch('store_info.php') // 서버에서 데이터를 가져오는 PHP 파일
                .then(response => response.json())
                .then(data => {
                    updateStoreInfo(data);
                });
    
            function updateStoreInfo(data) {
                // 데이터에서 필요한 정보 추출
                const operatingHours = data.operating_hours; // "09:00-21:00" 형식
                const breakTime = data.break_time; // "14:00-15:00" 형식
                const closedDays = data.closed_days.split(','); // "Sunday" 등의 형식
                const deliveryTip = data.delivery_tip;
                const minimumOrderAmount = data.minimum_order_amount;
    
                // HTML 요소 업데이트
                document.getElementById('operating-hours').textContent = operatingHours;
                document.getElementById('break-time').textContent = breakTime;
                document.getElementById('closed-days').textContent = closedDays.join(', ');
                document.getElementById('delivery-tip').textContent = deliveryTip;
                document.getElementById('minimum-order-amount').textContent = minimumOrderAmount;
    
                // 현재 시간 및 요일 계산
                const now = new Date();
                const currentDay = now.toLocaleDateString('en-US', { weekday: 'long' });
                const currentTime = now.toTimeString().slice(0, 5);
    
                // 가게 상태 판단 로직
                let isOpen = true;
    
                if (closedDays.includes(currentDay)) {
                    isOpen = false;
                } else {
                    const [openTime, closeTime] = operatingHours.split('-');
                    const [breakStartTime, breakEndTime] = breakTime.split('-');
    
                    if (currentTime < openTime || currentTime > closeTime) {
                        isOpen = false;
                    } else if (currentTime >= breakStartTime && currentTime <= breakEndTime) {
                        isOpen = false;
                    }
                }
    
                // 가게 상태 업데이트
                document.getElementById('store-status').textContent = isOpen ? 'Open' : 'Closed';
            }
        });
    
        function editInfo(id) {
            document.getElementById(id).style.display = 'none';
            document.getElementById('edit-' + id).style.display = 'block';
        }
    
        function saveInfo(name, key, value) {
            //
            const param = {}

            if (key === 'operating-hours' || key === 'break-time') {
                param['openTime'] =  document.getElementById('new-' + key + '-start').value;
                param['endTime'] = document.getElementById('new-' + key + '-end').value;
            } else if(key === 'break-time'){
                param['breakTimeStart'] =  document.getElementById('new-' + key + '-start').value;
                param['breakTimeEnd'] = document.getElementById('new-' + key + '-end').value;
            } else if(key === 'closed-days'){
                param['closedDays1'] =  document.getElementById('new-' + key + '-1').value;
                param['closedDays2'] =  document.getElementById('new-' + key + '-2').value;
                param['closedDays3'] =  document.getElementById('new-' + key + '-3').value;
                param['closedDays4'] =  document.getElementById('new-' + key + '-4').value;
                param['closedDays5'] =  document.getElementById('new-' + key + '-5').value;
            }
            else{
                param[name] = $('#new-' + key).val();
            }

            param['no'] = '${storeInfor.no}'

            //
            // const formData = new FormData();
            // formData.append(name, value);

            $.ajax({
                url: "/baemin/store/manage",
                type: "POST",
                data: param,
                success: function(response) {
                    alert("저장되었습니다.");
                    location.reload()
                },
                error: function(xhr, status, error) {
                    console.error(xhr);
                    alert("저장에 실패하였습니다.");
                }
            });

            // let newValue;

            // } else if (id === 'closed-days') {
            //     const selectedOptions = document.getElementById('new-closed-days').selectedOptions;
            //     newValue = Array.from(selectedOptions).map(option => option.value).join(',');
            // } else {
            //     newValue = document.getElementById('new-' + id).value;
            // }
    
            // fetch('update_store_info.php', {
            //     method: 'POST',
            //     headers: {
            //         'Content-Type': 'application/json'
            //     },
            //     body: JSON.stringify({
            //         field: id,
            //         value: newValue
            //     })
            // })
            // .then(response => response.json())
            // .then(data => {
            //     if (data.success) {
            //         document.getElementById(id).textContent = newValue + ' ';
            //         document.getElementById(id).appendChild(createEditButton(id));
            //         document.getElementById(id).style.display = 'block';
            //         document.getElementById('edit-' + id).style.display = 'none';
            //         // 저장이 완료되면 창을 닫음
            //         closeEditWindow(id);
            //     } else {
            //         alert('Failed to update the information.');
            //     }
            // });
        }
    
        function createEditButton(id) {
            const span = document.createElement('span');
            span.classList.add('edit-btn');
            span.textContent = '변경';
            span.setAttribute('onclick', 'editInfo("' + id + '")');
            return span;
        }
    
        function closeEditWindow(id) {
            document.getElementById('edit-' + id).style.display = 'none';
        }
    
        function showTab(tabId) {
            var tabs = document.querySelectorAll('.tab-content');
            var buttons = document.querySelectorAll('.tab-button');
    
            tabs.forEach(function(tab) {
                tab.classList.remove('active');
            });
    
            buttons.forEach(function(button) {
                button.classList.remove('active');
            });
    
            document.getElementById(tabId).classList.add('active');
            document.querySelector('button[onclick="showTab(\'' + tabId + '\')"]').classList.add('active');
        }
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</body>
</html>
