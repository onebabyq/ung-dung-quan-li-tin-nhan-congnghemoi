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
<link rel="stylesheet" href="${contextPath}/css/fileUpload.css">
<link rel="stylesheet" href="${contextPath}/css/button.css">
<link rel="stylesheet" href="${contextPath}/css/chat.css">
<link rel="stylesheet" href="${contextPath}/css/admin_dashboard.css">
<style>
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="navigation">
		<ul>
			<li><a href="${contextPath}/home"> <span class="icon"><ion-icon
							name="person-circle-outline"></ion-icon></span> <%--              <span class="title" id="name">${username}</span> --%>
					<span class="title" id="name">${account.username}</span> <span
					class="title" id="idAccount" style="color:var(--blue);">${account.id}</span>
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
					<form class="form-css" action="${contextPath}/findSDT" method="POST">
						<input class="in" type="text" placeholder="Tìm kiếm..."
							name="soDienThoai">
						<div class="ico" >
							<button class="button buttonsearch" type="submit" ><span><ion-icon class="icon1" name="search-outline"></ion-icon></span></button>
						</div>
					</form>
				</div>

				<ul id="FriendArea">
					<c:if test="${not empty userFinded}">
						<li class="kb_area">
	                        <form class="formNone" action="${contextPath}/chat" method="GET">
	                            <div class="friend">
	                                <div>
	                                	<input  type="hidden" id="PhoneNeedInvite" value="${userFinded.soDienThoai}">
	                                    <h3>${userFinded.account.username} (Phone: ${userFinded.soDienThoai})</h3>
	                                    <p>Gửi kết bạn <button id="btnSendInvite" class="button button2">Kết bạn</button> </p>
	                                </div>
	                            </div>
	                         </form>
	                    </li>
					</c:if>
					<c:forEach items="${listContact}" var="item">
						<c:if test="${item.accept == true}">
							<a href="${contextPath}/dual/withFriend/${item.friend.id}"> <%-- <input name="roomId" type="hidden" value="${entry.value}"> --%>
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
								<p>
									<span>Lời mời kết bạn</span><a
										href="${contextPath}/accept/${item.friend.id}"><button class="button button1">Chấp
											nhận</button> </a>
									<button class="button button3">Từ chối</button>
								</p>
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
					<form class="img_up" id="form-file-id" method="POST"
						action="${contextPath}/upload/${friendId}"
						enctype="multipart/form-data">
						<input type="file" name="file" class="custom-file-input"  id="file-id"
							onChange="changeImage();">
					</form>

					<span><ion-icon class="icon2"
							name="ellipsis-horizontal-outline"></ion-icon></span>
				</div>
				<div class="mid">
					<ul id="messageArea">
						<!-- This is message area -->
						<c:if test="${not empty listMessage}">
							<c:forEach items="${listMessage}" var="item">
								<c:if test="${item.from.id == account.id}">
									<li class="me"><c:if test="${item.contentType=='TEXT'}">
											<p>${item.content}</p>
											<span>10:20</span>
										</c:if> <c:if test="${item.contentType=='IMAGE'}">
											<img src="${item.content}" width="200" height="200">
										</c:if> <c:if test="${item.contentType=='FILE'}">
											<img src="${contextPath}/image/file-image.jpg" width="200"
												height="200">
											<br>
											<a href="${item.content}">${item.fileName}</a>
										</c:if> <c:if test="${item.contentType=='VIDEO'}">
											<video width="320" height="240" controls>
												<source src="${item.content}" type="video/mp4">
											</video>
											<br>
											<a href="${item.content}">${item.fileName}</a>
										</c:if></li>
								</c:if>
								<c:if test="${item.from.id != account.id}">
									<li class="u"><c:if test="${item.contentType=='TEXT'}">
											<p>${item.content}</p>
											<span>10:20</span>
										</c:if> <c:if test="${item.contentType=='IMAGE'}">
											<img src="${item.content}" width="200" height="200">
										</c:if> <c:if test="${item.contentType=='FILE'}">
											<img src="${contextPath}/image/file-image.jpg" width="200"
												height="200">
											<br>
											<a href="${item.content}">${item.fileName}</a>
										</c:if> <c:if test="${item.contentType=='VIDEO'}">
											<video width="320" height="240" controls>
												<source src="${item.content}" type="video/mp4">
											</video>
											<br>
											<a href="${item.content}">${item.fileName}</a>
										</c:if></li>
								</c:if>
							</c:forEach>
						</c:if>
					</ul>
				</div>

				<div class="btm">
					<form class="form-css">
						<div>+</div>
						<input type="text" name="" placeholder="Bạn đang nghĩ gì?"
							class="in2" id="message">
						<div class="ico3">

							<button id="messageForm" class="button buttonsearch" type="submit"><span><ion-icon type='submit' class="send_svg"
									name="send-outline" ></ion-icon></span></button>

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