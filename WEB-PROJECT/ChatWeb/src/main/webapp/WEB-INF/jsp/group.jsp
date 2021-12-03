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
<link rel="stylesheet" href="${contextPath}/css/group.css">
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
					class="title" id="idAccount" style="color: var(- -blue);">${account.id}</span>
			</a></li>
			<li><a href="${contextPath}/home"> <span class="icon"><ion-icon
							name="home-outline"></ion-icon></span> <span class="title">Trang
						Chủ</span>
			</a></li>
			<li><a href="${contextPath}/chat"> <span class="icon"><ion-icon
							name="chatbubbles-outline"></ion-icon></span> <span class="title">Tin
						Nhắn</span>
			</a></li>
			<li><a href="${contextPath}/group"> <span class="icon"><ion-icon
							name="chatbubbles-outline"></ion-icon></span> <span class="title">Nhóm
						chat</span>
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
					<h2>GROUP CHAT</h2>
					<!-- <h2 id="room-id-display">1</h2> -->
				</div>

				<div class="search_box">
					<form class="form-css" action="${contextPath}/createRoom"
						method="POST">
						<input class="in" type="text" placeholder="Nhập tên Group..."
							name="roomName" style="height:30px">
						<div class="ico" style="height:30px;width:30px">
							<button class="button button2" type="submit" >
								Tạo Group
							</button>
						</div>
					</form>
				</div>

				<ul id="FriendArea">
					<%-- <c:if test="${not empty userFinded}">
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
					</c:if> --%>
					<c:forEach items="${listGroup}" var="item">
						<%-- <c:if test="${item.accept == true}"> --%>
						<a href="${contextPath}/group/${item.id}"> <%-- <input name="roomId" type="hidden" value="${entry.value}"> --%>
							<li class="connect_btn">
								<div class="friend">
									<div class="img_name"></div>
									<img src="${contextPath}/image/none-avatar.png" class="ava"
										alt="">
									<div>
										<h3>${item.name}</h3>
										<p>
											Members: <span>10</span>
										</p>
									</div>
									<div class="time">
										<p class="p">Today</p>
									</div>
								</div>
						</li>
						</a>
						<%-- </c:if> --%>
						<%-- 	<c:if test="${item.accept == false}">

							<div>
								<h3>${item.friend.username}</h3>
								<p>
									<span>Lời mời kết bạn</span><a
										href="${contextPath}/accept/${item.friend.id}"><button class="button button1">Chấp
											nhận</button> </a>
									<button class="button button3">Từ chối</button>
								</p>
							</div>

						</c:if> --%>
					</c:forEach>

				</ul>
			</div>
			<c:if test="${not empty roomId}">
			<div class="right">
				<div class="right_top">
					<div class="img_name">
						<img src="${contextPath}/image/none-avatar.png" class="ava" alt="">
						<div>
							<h3 id="friend-name">${roomName}</h3>
							<p id="hoat-dong">Active 30 seconds ago...</p>
						</div>
					</div>
					<button class="button button2 btnup" id="myBtn" onclick="showModal();">
						THÊM THÀNH VIÊN</button>
					<!-- The Modal -->
					<script>
                       function showModal() {
                          //alert("abc");
                          var modal = document.getElementById("myModal");
                          modal.style.display = "block";
                          ShowAllReservation(${account.id}) ;
                       }
                       function ShowAllReservation(id) {
                       	        var xhttp = new XMLHttpRequest();
                       	        xhttp.open("GET", "http://localhost:8080/api/users/byContactOfAccountId/"+id, true);
                       	        xhttp.send();

                       	        xhttp.onreadystatechange = function () {
                       	            var div = document.getElementById("contactArea");
                       	            div.innerHTML = "";
                       	            if (this.status == 200) {
                       	                JSON.parse(this.responseText).forEach(function (data, index) {
                       	                    div.innerHTML += "<div><input name='ckb_friends' class='checkbox-custom' type='checkbox' value='"+data.account.id+"'>" + data.account.username +" (Phone: "+data.soDienThoai+")"+"</div>";
                       	                });
                       	            }
                       	        };
                       	    }
                    </script>
					<div id="myModal" class="modal">

						<!-- Modal content -->
						<div class="modal-content">
							<div class="modal-header">
								<span class="close">&times;</span>
								<script>
								        var span2 = document.getElementsByClassName("close")[0];
								        span2.onclick = function() {
								              var modal = document.getElementById("myModal");
                                              modal.style.display = "none";
                                        }
								</script>
								<h2>Thêm thành viên vào group</h2>
							</div>
							<div class="modal-body">
								<form class="formNone" style="margin: 20px 20px">
									<h3 style="color: blue;">Tìm kiếm bạn bè</h3>
									<input class="in" type="text"
										placeholder="Nhập tên hoặc số điện thoại..." id="mySearchFKey">
									<div class="ico" id="btnFKey"  onclick="searchFKey()"
										style="width: 40px; float: left; padding: 0; margin: 0;">
										<!--  <button><ion-icon class="icon1" name="search-outline"></ion-icon></button> -->
										<button id = "btnFKey" class="button buttonsearch" style="width: 40px">
											<ion-icon class="icon1" name="search-outline"></ion-icon>
										</button>
										<script>
										    function searchFKey(){
										        event.preventDefault();
										        var key = document.getElementById("mySearchFKey").value;
										        //alert("search key: "+key);
										        tesSearchKey(key);
										    }
										    function tesSearchKey(key) {
                                                var xhttp = new XMLHttpRequest();
                                                var url = "http://localhost:8080/api/users/"+${account.id}+"/byKey/"+key;
                                                xhttp.open("GET", url, true);
                                                xhttp.send();

                                                xhttp.onreadystatechange = function () {
                                                    var div = document.getElementById("contactArea");
                                                    div.innerHTML = "";
                                                    if (this.status == 200) {
                                                        JSON.parse(this.responseText).forEach(function (data, index) {
                                                            div.innerHTML += "<div><input name='ckb_friends' class='checkbox-custom' type='checkbox' value='"+data.account.id+"'>" + data.account.username +" (Phone: "+data.soDienThoai+")"+"</div>";
                                                        });
                                                    }
                                                };
                                            }

										</script>
									</div>
									</form>
									<br> <br> <br>
                                    <form method="POST" action="${contextPath}/addMembers/${roomId}" class="formNone">

                                        <h3 style="color: blue;">Danh sách bạn bè</h3>
                                        <div style="margin: 20px 10px;" id="contactArea">

                                            <div>
                                                <input class="checkbox-custom" type="checkbox" name="fruit"
                                                    value="Apple"> Sơn (Phone: 0968900475)
                                            </div>
                                            <div>
                                                <input class="checkbox-custom" type="checkbox" name="fruit"
                                                    value="Apple"> Hải (Phone: 01232577913)
                                            </div>
                                            <div>
                                                <input class="checkbox-custom" type="checkbox" name="fruit"
                                                    value="Apple"> Tiên (Phone: 0929315825)
                                            </div>
                                        </div>


                                        <button class="button button1" type="submit"
                                            style="border-radius: 0; font-size: 16px; padding: 5px 15px;">Thêm
                                            vào nhóm</button>

								</form>

							</div>
							<div class="modal-footer" style="height: 20px;">
								<!-- <h3>Modal Footer</h3> -->
							</div>
						</div>
					</div>
					<form class="img_up" id="form-file-id" method="POST"
						action="${contextPath}/upload/1" enctype="multipart/form-data">
						<input type="file" name="file" class="custom-file-input"
							id="file-id" onChange="changeImage();">
					</form>

					<span id="three-dots"><ion-icon class="icon2" name="ellipsis-horizontal-outline"></ion-icon></span>
                    <script>
                        var accountAdmin = null;
                        var span3d = document.getElementById("three-dots");
                        span3d.onclick = function(){
                            setAdminAccount();
                            var modal = document.getElementById("modalMember");
                            if(accountAdmin!=null){
                                modal.style.display = "block";
                                showListMembers(${roomId});
                                checkAdminButton();
                            }

                        }
                        function setAdminAccount(){
                             //GET ADMIN IN ROOM
                            var xhttp1 = new XMLHttpRequest();
                            xhttp1.open("GET", "http://localhost:8080/api/accounts/rooms/"+roomId+"/getAdmin", true);
                            xhttp1.send();
                            xhttp1.onreadystatechange = function () {
                                if (this.status == 200) {
                                     accountAdmin = JSON.parse(this.responseText);
                                }
                            };
                        }
                        function showListMembers(roomId) {
                            //GET LIST MEMBER IN ROOM
                            var xhttp = new XMLHttpRequest();
                            xhttp.open("GET", "http://localhost:8080/api/accounts/rooms/"+roomId, true);
                            xhttp.send();

                            xhttp.onreadystatechange = function () {
                                var div = document.getElementById("memberArea");
                                div.innerHTML = "";
                                if (this.status == 200) {
                                    JSON.parse(this.responseText).forEach(function (data, index) {
                                        //DISABLED ADMIN CHECKBOX
                                        if(data.id==accountAdmin.id)
                                            div.innerHTML += "<div><input name='ckb_friends' class='checkbox-custom' type='checkbox' value='"+data.id+"' disabled>" + data.username +" (Chức vụ: "+"Quản trị viên"+")"+"</div>";
                                        //ONLY ADMIN HAVE PERMISSION TO REMOVE MEMBER
                                        else if(${account.id}==accountAdmin.id)
                                            div.innerHTML += "<div><input name='ckb_friends' class='checkbox-custom' type='checkbox' value='"+data.id+"'>" + data.username +" (Chức vụ: "+"Thành viên"+")"+"</div>";
                                        else
                                            div.innerHTML += "<div><input name='ckb_friends' class='checkbox-custom' type='checkbox' value='"+data.id+"' disabled>" + data.username +" (Chức vụ: "+"Thành viên"+")"+"</div>";
                                    });
                                }
                            };
                        }
                    </script>
                    <div id="modalMember" class="modal">
                        <div class="modal-content">
                            <div class="modal-header" style="background-color:blue;">
                                <span class="close">&times;</span>
                                <script>
                                     var span4 = document.getElementsByClassName("close")[1];
                                     span4.onclick = function() {
                                           var modal = document.getElementById("modalMember");
                                           modal.style.display = "none";
                                     }
                                </script>
                                <h2>Nhóm chat: ${roomName}</h2>
                            </div>
                            <div class="modal-body">
                                <form class="formNone" style="margin: 20px 20px" method="POST" action="${contextPath}/updateRoomName/${roomId}">
                                    <h3 style="color:blue;">Đổi tên nhóm:</h3>
                                    <input name="roomName" type="text" class="in" placeholder="Nhập tên nhóm mới...">
                                    <button class="button button2" style="border-radius: 0">Cập nhật</button>
                                </form>
                                <form class="formNone" style="margin: 20px 20px" method="POST" action="${contextPath}/removeMembers/${roomId}">
                                    <h3 style="color:blue;">Thành viên trong nhóm:</h3>
                                    <div style="margin: 20px 10px;" id="memberArea">
                                        <div>
                                            <input class="checkbox-custom" type="checkbox" name="fruit" value="Apple" disabled> Sơn
                                            (Chức vụ: Quản trị viên)
                                        </div>
                                        <div>
                                            <input class="checkbox-custom" type="checkbox" name="fruit" value="Apple"> Hải
                                            (Chức vụ: Thành viên)
                                        </div>
                                        <div>
                                            <input class="checkbox-custom" type="checkbox" name="fruit" value="Apple"> Tiên
                                            (Chức vụ: Thành viên)
                                        </div>
                                    </div>


                                    <div id="divActive">
                                        <div id="divActive1">

                                        </div>
                                        </form>
                                        <form method='POST' action='${contextPath}/deleteRoom' class='formNone'>
                                            <div id="divActive2">
                                            </div>
                                        </form>
                                        <form method='POST' action='${contextPath}/leaveRoom' class='formNone'>
                                            <div id="divActive3">
                                            </div>
                                        </form>
                                    </div>
                                    <script>
                                        function checkAdminButton(){
                                             var divActive1 = document.getElementById("divActive1");
                                             var divActive2 = document.getElementById("divActive2");
                                             var divActive3 = document.getElementById("divActive3");
                                             divActive1.innerHTML = "";
                                             divActive2.innerHTML = "";
                                             divActive3.innerHTML = "";

                                             if(accountAdmin.id==${account.id}){
                                                 divActive1.innerHTML += "<button type='submit' class='button button1' style='border-radius: 0'>Mời khỏi nhóm</button></form>";

                                                 divActive2.innerHTML += "<input type='hidden' name='roomId' value='${roomId}'>"
                                                 divActive2.innerHTML += "<button class='button button3' style='border-radius: 0'>Xóa nhóm</button>";
                                             }
                                             else{
                                                 divActive3.innerHTML += "<input type='hidden' name='roomId' value='${roomId}'>"
                                                 divActive3.innerHTML += "<input type='hidden' name='accountId' value='${account.id}'>"
                                                 divActive3.innerHTML += "<button class='button button3' style='border-radius: 0'>Rời nhóm</button>";
                                             }

                                        }

                                    </script>
                            </div>

                            <div class="modal-footer" style="height: 20px;background-color:blue;">
                                <!-- <h3>Modal Footer</h3> -->
                            </div>
                        </div>
                    </div>
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

							<button id="messageForm" class="button buttonsearch"
								type="submit">
								<span><ion-icon type='submit' class="send_svg"
										name="send-outline"></ion-icon></span>
							</button>

							<!-- <button id="messageForm" name="messageForm">Send</button> -->
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

    </c:if>



	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

	<script type="javascript/text">
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
        item.addEventListener('mouseover',activeLink));
        
        /*  Modal*/
         /*Modal*/
        // Get the modal
        var modal = document.getElementById("myModal");

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");


        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];
		
        var btnFKey document.getElementById("btnFKey");
        // When the user clicks on the button, open the modal
        btnFKey.onclick = function() {
            searchFriendByKey(key);
        }
        
        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
          modal.style.display = "none";
        }

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
          if (event.target == modal) {
            modal.style.display = "none";
          }
        }
        

        function searchFriendByKey(key) {
            alert("searching...");
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/api/users/byKey", true);
            xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xmlhttp.send(JSON.stringify({ "key": key }));
            xmlhttp.send();
            xhttp.onreadystatechange = function () {
                var div = document.getElementById("contactArea");
                div.innerHTML = "";
                if (this.status == 200) {
                    JSON.parse(this.responseText).forEach(function (data, index) {
                        div.innerHTML += "<div><input class='checkbox-custom' type='checkbox' value='"+data.account.id+"'>" + data.account.username +" (Phone: "+data.soDienThoai+")"+"</div>";
                    });
                }
            };
        }
	 

	    /*
	    <div>
			<input class="checkbox-custom" type="checkbox" name="fruit"
				value="Apple"> Sơn (Phone: 0968900475)
		</div>
	    
	    */
	
    </script>


	<script src="${contextPath}/js/sockjs.min.js" type="text/javascript"></script>
	<script src="${contextPath}/js/stomp.min.js" type="text/javascript"></script>
	<script src="${contextPath}/js/main.js" type="text/javascript"></script>

</body>
</html>