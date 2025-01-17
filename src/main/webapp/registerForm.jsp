<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style><%@include file="/css/login.css"%></style>
    <title>Title</title>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
<div class="login-form">
    <form action="${pageContext.request.contextPath}/register" method="POST">
        <h2 class="text-center">Register</h2>
        <div class="form-group">
            <input type="email" class="form-control" name="username" placeholder="Email" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Register</button>
        </div>
    </form>
    <p class="text-center"><a href="${pageContext.request.contextPath}/login-form">Have an account? Log in instead.</a></p>
</div>
</body>
</html>