<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Testme</title>
    <style>
        body, html {
            height: 100%;
        }


        .hero-image {
            background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("https://cdn.wallpapersafari.com/96/20/psPtvc.jpg");


            height: 70%;


            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }


        .hero-text {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
        }

        input {
            background-color: dodgerblue;
            width: 250px;
            padding: 5px;
        }

        form {
            padding: 10px;
        }

    </style>
</head>
<jsp:include page="nav.jsp" flush="true" />
<body>
<div class="hero-image">
    <div class="hero-text">
        <h1>Welcome to the Test App</h1>
        <h3>Start a test and increase your knowledge!</h3>
        <br>
        <br>
        <div class="login-form">
            <form action="${pageContext.request.contextPath}/login" method="POST">
                <h2 class="text-center">Log in</h2>
                <div class="form-group">
                    <input type="email" class="form-control" name="username" placeholder="Email" required="required">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Password" required="required">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                </div>
            </form>
            <p class="text-center"><a href="${pageContext.request.contextPath}/register-form">Create an Account</a></p>
        </div>
    </div>
</div>
</body>
</html>
