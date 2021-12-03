<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="css/style.css" var="jstlCss" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    
    <link rel="stylesheet" href="${contextPath}/css/admin_dashboard.css">
    <link rel="stylesheet" href="${contextPath}/css/chat.css">
    <link rel="stylesheet" href="${contextPath}/css/home.css">

</head>
<body>
	<div class="navigation">
        <ul>
            <li>
                <a href="${contextPath}/home">
                    <span class="icon"><ion-icon name="person-circle-outline"></ion-icon></span>
       <%--              <span class="title" id="name">${username}</span> --%>
                     <span class="title" id="name" >${username}</span> 
                </a>
            </li>
            <li>
                <a href="${contextPath}/home">
                    <span class="icon"><ion-icon name="home-outline"></ion-icon></span>
                    <span class="title">Trang Chủ</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/chat">
                    <span class="icon"><ion-icon name="chatbubbles-outline"></ion-icon></span>
                    <span class="title">Tin Nhắn</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/group">
                    <span class="icon"><ion-icon name="chatbubbles-outline"></ion-icon></span>
                    <span class="title">Nhóm chat</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/info">
                    <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                    <span class="title">Cá Nhân</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/logout">
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
            <div class="hero">
                <nav>
                
                </nav>
                <div class="detel">
                    <h1>${firstname} <span>${lastname} <button><ion-icon name="pencil-outline"></ion-icon></button></span></h1>
                    <p>Email: ${email}</p>
                    <p>${content}</p>
                </div>
                <div class="images">
                    <img src="${contextPath}/image//user_img.jpg" class="shape" style="height: 600px; width: 600px; border-radius: 50%;" alt="">
                </div>
            </div>
        </div>
    </div>
    
    
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script> 

    <script>

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
</body>
</html>