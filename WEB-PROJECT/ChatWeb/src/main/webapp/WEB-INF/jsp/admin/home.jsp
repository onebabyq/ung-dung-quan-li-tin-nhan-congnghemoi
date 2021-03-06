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
    <title>Trang Chủ</title>
    
    <link rel="stylesheet" type="text/css" href="css/admin_dashboard.css">

</head>
<body>

	<div class="container">
        <div class="navigation">
            <ul>
                <li>
                    <a href="/home">
                        <span class="icon"><ion-icon name="person-circle-outline"></ion-icon></span>
                        <span class="title">Admin</span>
                    </a>
                </li>
            </ul>
        </div>
    
        <div class="main">
            <div class="topbar">
                <div class="toggle">
                    <ion-icon name="menu-outline" class="open"></ion-icon>
                </div>
                <!-- Search -->
                <div class="search">
                    <label>
                        <input type="text" placeholder="Tìm kiếm tại đây">  
                        <ion-icon name="search-outline"></ion-icon>
                    </label>
                </div>
                <!-- User img -->
                <div class="user">
                    <img src="./user_img.jpg" alt="">
                </div>
            </div>

            <!-- Cards -->
            <div class="cardBox">
                <div class="card">
                    <div>
                        <div class="numbers">80</div>
                        <div class="cardName">Đã đăng ký</div>
                    </div>
                    <div class="iconBx"><ion-icon name="eye-outline"></ion-icon></div>
                </div>
                <div class="card">
                    <div>
                        <div class="numbers">50</div>
                        <div class="cardName">Đã đăng nhập</div>
                    </div>
                    <div class="iconBx"><ion-icon name="log-in-outline"></ion-icon></div>
                </div>
                <div class="card">
                    <div>
                        <div class="numbers">3</div>
                        <div class="cardName">Đã đăng xuất</div>
                    </div>
                    <div class="iconBx"><ion-icon name="log-out-outline"></ion-icon></div>
                </div>
                <div class="card">
                    <div>
                        <div class="numbers">3</div>
                        <div class="cardName">Vô hiệu hóa</div>
                    </div>
                    <div class="iconBx"><ion-icon name="alert-circle-outline"></ion-icon></div>
                </div>
            </div>

            <div class="details">
                <!-- data list user -->
                <div class="listUser">
                    <div class="cardHeader">
                        <h2>Danh sách người dùng</h2>
                        <a href="#" class="btn">Xem tất cả</a>
                    </div>
                    <table>
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Tên người dùng</td>
                                <td>Số điện thoại</td>
                                <td>Email</td>
                                <td>Giới tính</td>
                                <td>Cập nhật</td>
                                <td>Vô hiệu hóa</td>
                                <td>Trạng thái</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>01</td>
                                <td>Lê Văn Toàn</td>
                                <td>0819490540</td>
                                <td>lvtoan.cv@gmail.com</td>
                                <td>Nam</td>
                                <td><button>Cập nhật</button></td>
                                <td><button>Vô hiệu hóa</button></td>
                                <td><span class="status online">Online</span></td>
                            </tr>
                            <tr>
                                <td>02</td>
                                <td>Trần Vũ Hoàng Sơn</td>
                                <td>0123456789</td>
                                <td>tvhson@gmail.com</td>
                                <td>Nam</td>
                                <td><button>Cập nhật</button></td>
                                <td><button>Vô hiệu hóa</button></td>
                                <td><span class="status offline">Offline</span></td>
                            </tr>
                            <tr>
                                <td>02</td>
                                <td>Trần Vũ Hoàng Sơn</td>
                                <td>0123456789</td>
                                <td>tvhson@gmail.com</td>
                                <td>Nam</td>
                                <td><button>Cập nhật</button></td>
                                <td><button>Vô hiệu hóa</button></td>
                                <td><span class="status blocking">Blocking</span></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <!-- New User -->
                <div class="recentUsers">
                    <div class="cardHeader">
                        <h2>Truy cập gần đây</h2>
                    </div>
                    <table>
                        <tr>
                            <td width="60px">
                                <div class="imgBx">
                                    <img src="./user_img.jpg" alt="">
                                </div>
                            </td>
                            <td>
                                <h4>Lê Văn Toàn<br><span>VietNam</span></h4>
                            </td>
                        </tr>
                        <tr>
                            <td width="60px">
                                <div class="imgBx">
                                    <img src="./user_img.jpg" alt="">
                                </div>
                            </td>
                            <td>
                                <h4>Lê Văn Toàn<br><span>VietNam</span></h4>
                            </td>
                        </tr>
                        <tr>
                            <td width="60px">
                                <div class="imgBx">
                                    <img src="./user_img.jpg" alt="">
                                </div>
                            </td>
                            <td>
                                <h4>Lê Văn Toàn<br><span>VietNam</span></h4>
                            </td>
                        </tr>
                        <tr>
                            <td width="60px">
                                <div class="imgBx">
                                    <img src="./user_img.jpg" alt="">
                                </div>
                            </td>
                            <td>
                                <h4>Lê Văn Toàn<br><span>VietNam</span></h4>
                            </td>
                        </tr>
                        <tr>
                            <td width="60px">
                                <div class="imgBx">
                                    <img src="./user_img.jpg" alt="">
                                </div>
                            </td>
                            <td>
                                <h4>Lê Văn Toàn<br><span>VietNam</span></h4>
                            </td>
                        </tr>
                        <tr>
                            <td width="60px">
                                <div class="imgBx">
                                    <img src="./user_img.jpg" alt="">
                                </div>
                            </td>
                            <td>
                                <h4>Lê Văn Toàn<br><span>VietNam</span></h4>
                            </td>
                        </tr>
                    </table>
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