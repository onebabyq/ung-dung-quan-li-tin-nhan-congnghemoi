<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="css/style.css" var="jstlCss" />
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ</title>
    
    <link rel="stylesheet" href="css/signin.css">

</head>
<body>

	<div class="container">
        <div class="blueBg">
            <div class="box signin">
                <h2>Đã có tài khoản?</h2>
                <button class="signinBtn">Đăng Nhập</button>
            </div>
            <div class="box signup">
                <h2>Chưa có tài khoản</h2>
                <button class="signupBtn">Đăng Ký</button>
            </div>
        </div>
        <div class="formBx">
            <div class="form signinForm">
                <form action="/perform_login" method="post">
                    <h3>Đăng Nhập</h3>
                    <input type="tel" id="telephone" name="soDienThoai" value="0123123123" onblur="kiemtrasdt();" placeholder="Số điện thoại"><span hidden id="er">(*)</span>
                    <input type="password" id="pass" name="password" value="12345" onblur="kiemtramk();" placeholder="Mật khẩu"><span hidden id="ermk">(*)</span>
                    <input type="submit" value="Đăng Nhập">
                    <input type="submit" value="Đăng Nhập Google">
                    <a href="#" class="forgot">Quên mật khẩu</a>
                </form>
            </div>

            <div class="form signupForm">
                <form:form action="/register" method="post" modelAttribute="user">
                    <h3>Đăng Ký</h3>
                    <form:input  id="telephone" path="soDienThoai" onblur="kiemtrasdt();" placeholder="Số điện thoại" /><span hidden id="er2">(*)</span>
                    <input name="hoten" id="hoten" path="user.account.username" onblur="kiemtrasdt();" placeholder="Họ Tên" /><span hidden id="er2">(*)</span>
                    <form:password id="pass" path="password" onblur="kiemtramk();" placeholder="Mật khẩu" /><span hidden id="ermk">(*)</span>
                    <input type="password" name="repass" id="repass" onblur="kiemtralaimk();" placeholder="Nhập lại mật khẩu"><span hidden id="erremk">(*)</span>
                    <input type="submit" value="Đăng Ký">
                </form:form>
            </div>
        </div>
    </div>
    
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script> 

    <script>
        const signinBtn = document.querySelector('.signinBtn');
        const signupBtn = document.querySelector('.signupBtn');
        const formBx = document.querySelector('.formBx');
        const body = document.querySelector('body');

        signupBtn.onclick = function(){
            formBx.classList.add('active');
            body.classList.add('active')
        }

        signinBtn.onclick = function(){
            formBx.classList.remove('active');
            body.classList.remove('active');
        }

        function kiemtramk()
        {
            //Có tối thiểu 8 ký tự, Có ít nhất một kí tự viết thường (a-z), Có ít nhất một kí tự viết hoa (A-Z), Có ít nhất một chữ số (0-9), Có ít nhất một ký tự đặc biệt (!@#$%^&)
            var regmk = /^[a-zA-Z0-9]+$/;
               var mk = document.getElementById("pass").value;
               if(regmk.test(mk))
               {
                   document.getElementById("ermk").innerHTML = "";
                   return true;
               }
               else
               {
                   document.getElementById("ermk").innerHTML = "Mật khẩu không hợp lệ!";
                   return false;
               }
        }
        function kiemtralaimk()
           {
               var mk=document.getElementById("pass").value;
               var mk2=document.getElementById("repass").value;
               if(kiemtramk()&&mk==mk2)
               {
                   document.getElementById("erremk").innerHTML = "";
                   return true;
               }
               else
               {
                   document.getElementById("erremk").innerHTML = "Mật khẩu không khớp!";
                   return false;
               }
           }
        function kiemtramail()
            {
                var remail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                var mail = document.getElementById("email").value;
                if (remail.test(mail) == false) 
                {
                    document.getElementById("er1").innerHTML = "Không hơp lệ";
                    return false;
                }
                else
                    document.getElementById("er1").innerHTML = " ";
                    return  true;
            }
        function kiemtrasdt()
            {   
                var regSDT = /^0\d{9}$/;
                var sdt = document.getElementById("telephone").value;
                if(regSDT.test(sdt))
                {
                    document.getElementById("er2").innerHTML = "";
                }
                else
                {
                    document.getElementById("er2").innerHTML = "Không hợp lệ!";
                }
            }
    </script>
</body>
</html>