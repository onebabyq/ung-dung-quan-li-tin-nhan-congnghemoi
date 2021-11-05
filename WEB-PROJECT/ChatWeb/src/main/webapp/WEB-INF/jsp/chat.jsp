<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="css/style.css" var="jstlCss" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat Room</title>
    
    <link rel="stylesheet" href="css/chat.css">
    <link rel="stylesheet" href="css/admin_dashboard.css">
 
</head>
<body>
    <div class="navigation">
        <ul>
            <li>
                <a href="/home">
                    <span class="icon"><ion-icon name="person-circle-outline"></ion-icon></span>
       <%--              <span class="title" id="name">${username}</span> --%>
                     <span class="title" id="name" >${username}</span> 
                </a>
            </li>
            <li>
                <a href="/home">
                    <span class="icon"><ion-icon name="home-outline"></ion-icon></span>
                    <span class="title">Trang Chủ</span>
                </a>
            </li>
            <li>
                <a href="/view">
                    <span class="icon"><ion-icon name="chatbubbles-outline"></ion-icon></span>
                    <span class="title">Tin Nhắn</span>
                </a>
            </li>
            <li>
                <a href="/info">
                    <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                    <span class="title">Cá Nhân</span>
                </a>
            </li>
            <li>
                <a href="/logout">
                    <span class="icon"><ion-icon name="log-out-outline"></ion-icon></span>
                    <span class="title">Đăng Xuất</span>
                </a>
            </li>
        </ul>
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
                </div>
                <div class="search_box">
                    <input class="in" type="text" placeholder="Tìm kiếm...">
                    <div class="ico">
                        <span><ion-icon class="icon1" name="search-outline"></ion-icon></span>
                    </div>
                </div>
                <ul>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p><span>Đang nhập ...</span></p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="friend">
                            <div class="img_name"></div>
                            <img src="image//none-avatar.png" class="ava" alt="">
                            <div>
                                <h3>Hoàng Sơn</h3>
                                <p>Chào Sơn!</p>
                            </div>
                            <div class="time">
                                <p class="p">Today</p>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="right">
                <div class="right_top">
                    <div class="img_name">
                        <img src="image//none-avatar.png" class="ava" alt="">
                        <div>
                            <h3>Hoàng Sơn</h3>
                            <p>Active 30 seconds ago...</p>
                        </div>
                    </div>
                    <span><ion-icon class="icon2" name="ellipsis-horizontal-outline"></ion-icon></span>
                </div>
                <div class="mid">
                	<ul id="messageArea">
                		<li class="me">
		                        <p>Chào! Khỏe không</p>
		                </li>
		                <li class="u">
		                        <p>Chào! Khỏe không</p>
	                   	</li>
                    </ul>
                </div>
                <div class="btm" >
                    <form >
                        <div>+</div>
                        <input type="text" name="" placeholder="Bạn đang nghĩ gì?" class="in2" id="message" >
                        <div class="ico3">
                            <button id="messageForm" name="messageForm">Send</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    



    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script> 

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
    
    
    <script src="js/sockjs.min.js" type="text/javascript"></script>
  	<script src="js/stomp.min.js" type="text/javascript"></script>
  	<script src="js/main.js" type="text/javascript"></script>
  	
</body>
</html>