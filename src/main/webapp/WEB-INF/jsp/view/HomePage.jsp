<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: swood
  Date: 11/4/2018
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
        <%@include file="/WEB-INF/CSS/Home.css"%>
    </style>
    <title>Home Page</title>
</head>
<body>

<div class="container">
    <br/>
    <br/>
    <br/>
    <br/>

<b id="login-name">Welcome</b>
    <div class="row">
        <div class="col-md-6 col-md-offset-3" id="login">
            <div class="form-group" style="align-content: center">
                <form action="<c:out value="Login"/>"><input type="submit" class="btn btn-success" value="Login" style="border-radius:0;"></form>
                <form action="<c:out value="Register"/>"><input type="submit" class="btn btn-danger" value="Register" style="border-radius:0;"></form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
