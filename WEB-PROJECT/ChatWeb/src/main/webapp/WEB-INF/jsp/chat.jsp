<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:url value="css/style.css" var="jstlCss" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chat Room</title>

<link rel="stylesheet" href="${contextPath}/css/chat.css">
<link rel="stylesheet" href="${contextPath}/css/admin_dashboard.css">

</head>
<body>
	<div class="navigation">
		<ul>
			<li><a href="${contextPath}/home"> <span class="icon"><ion-icon
							name="person-circle-outline"></ion-icon></span> <%--              <span class="title" id="name">${username}</span> --%>
					<span class="title" id="name">${account.username}</span> <span
					class="title" id="idAccount">${account.id}</span>
			</a></li>
			<li><a href="${contextPath}/home"> <span class="icon"><ion-icon
							name="home-outline"></ion-icon></span> <span class="title">Trang
						Chủ</span>
			</a></li>
			<li><a href="${contextPath}/chat"> <span class="icon"><ion-icon
							name="chatbubbles-outline"></ion-icon></span> <span class="title">Tin
						Nhắn</span>
			</a></li>
			<li><a href="${contextPath}/info"> <span class="icon"><ion-icon
							name="person-outline"></ion-icon></span> <span class="title">Cá
						Nhân</span>
			</a></li>
			<li><a href="${contextPath}/logout"> <span class="icon"><ion-icon
							name="log-out-outline"></ion-icon></span> <span class="title">Đăng
						Xuất</span>
			</a></li>
		</ul>
		<c:if test="${not empty roomId}">
			<p style="position: absolute; bottom: 0; left: 0;">
				RoomId: <span id="room-id">${roomId}</span>
			</p>

		</c:if>
		<c:if test="${empty roomId}">
			<p style="position: absolute; bottom: 0; left: 0;">
				RoomId: <span id="room-id">0</span>
			</p>

		</c:if>


	</div>

	<div class="main">
		<div class="topbar">
			<div class="toggle">
				<ion-icon name="menu-outline" class="open"></ion-icon>
			</div>
		</div>
		<div class="box">
			<div class="left">
				<div class="topp">
					<h2>APPCHAT</h2>
					<!-- <h2 id="room-id-display">1</h2> -->
				</div>
				
				<div class="search_box">
					<form>
					<input class="in" type="text" placeholder="Tìm kiếm..." id="searchKey">
					<div class="ico" id="searchButton">
						<span><ion-icon class="icon1" name="search-outline"></ion-icon></span>
					</div>
					</form>
				</div>
				
				<ul id="FriendArea">
					<c:forEach items="${listContact}" var="item">
						<c:if test="${item.accept == true}">
							<a href="${contextPath}/dual/withFriend/${item.friend.id}"> 
							<%-- <input name="roomId" type="hidden" value="${entry.value}"> --%>
								<li class="connect_btn">
									<div class="friend">
										<div class="img_name"></div>
										<img src="${contextPath}/image/none-avatar.png" class="ava"
											alt="">
										<div>
											<h3>${item.friend.username}</h3>
											<p>
												Chào: <span>${item.friend.username}</span>
											</p>
										</div>
										<div class="time">
											<p class="p">Today</p>
										</div>
									</div>
								</li>
							</a>
						</c:if>
						<c:if test="${item.accept == false}">
							
							<div>
                                <h3>${item.friend.username}</h3>
                                <p><span>Lời mời kết bạn</span><a href="${contextPath}/accept/${item.friend.id}"><button>Chấp nhận</button> </a><button>Từ chối</button></p>
                            </div>
                            
						</c:if>
					</c:forEach>

				</ul>
			</div>
			<div class="right">
				<div class="right_top">
					<div class="img_name">
						<img src="${contextPath}/image/none-avatar.png" class="ava" alt="">
						<div>
							<h3 id="friend-name">${friendName}</h3>
							<p id="hoat-dong">Active 30 seconds ago...</p>
						</div>
					</div>
					<span><ion-icon class="icon2"
							name="ellipsis-horizontal-outline"></ion-icon></span>
				</div>
				<div class="mid">
					<ul id="messageArea">
						<!-- This is message area -->
						<c:if test="${not empty listMessage}">
							<c:forEach items="${listMessage}" var="item">
								<c:if test="${item.from.id == account.id}">
									<li class="me">
										<p>${item.content}</p>
									</li>
								</c:if>
								<c:if test="${item.from.id != account.id}">
									<li class="u">
										<p>${item.content}</p>
									</li>
								</c:if>
							</c:forEach>
						</c:if>
					</ul>
				</div>

				<div class="btm">
					<form>
						<div>+</div>
						<input type="text" name="" placeholder="Bạn đang nghĩ gì?"
							class="in2" id="message">
						<div class="ico3">

							<span><ion-icon type='submit' class="send_svg"
									name="send-outline" id="messageForm"></ion-icon></span>

							<!-- <button id="messageForm" name="messageForm">Send</button> -->
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>





	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	<script>
    	//var messageForm = document.querySelector('#messageForm');
        //Menu Toggle
        let menuToggle = document.querySelector('.toggle');
        let navigation = document.querySelector('.navigation');
        let main = document.querySelector('.main');
        
       
        menuToggle.onclick = function(){
            //menuToggle.classList.toggle('active')
            navigation.classList.toggle('active');
            main.classList.toggle('active');
        }

        // add hovered class in selected list item
        let list = document.querySelectorAll('.navigation li');
        function activeLink(){
            list.forEach((item) =>
            item.classList.remove('hovered'));
            this.classList.add('hovered');
        }
        list.forEach((item) => 
        item.addEventListener('mouseover',activeLink))
    </script>


	<script src="${contextPath}/js/sockjs.min.js" type="text/javascript"></script>
	<script src="${contextPath}/js/stomp.min.js" type="text/javascript"></script>
	<script src="${contextPath}/js/main.js" type="text/javascript"></script>

</body>
</html>