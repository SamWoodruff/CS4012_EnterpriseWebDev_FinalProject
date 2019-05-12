<%--
  Created by IntelliJ IDEA.
  User: swood
  Date: 11/4/2018
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="registerForm" type="Forms.RegisterForm"--%>
<%--@elvariable id="error" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <title>Register</title>
    <style>
        <%@include file="/WEB-INF/CSS/Registration.css"%>
    </style>
</head>

<%@ page isELIgnored="false" %>
<body>
<h3 style="text-align: center; background-color: red;font-size:35px;">${error}</h3>

<section class="register-block">
    <div class="container">
        <div class="row">
            <div class="col-md-4 register-sec">
                <h2 class="text-center">Register Now</h2>
                <form:form class="register-form" modelAttribute="registerForm" method="POST">
                    <div class="form-group">
                        <form:label class="text-uppercase" path="loginId">Email Address:</form:label>
                        <form:input type="text" class="form-control" path="loginId" required="required"/>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="password">Password:</form:label>
                        <form:input type="text" class="form-control" path="password"  required="required"/><br>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="password2">Re-enter Password:</form:label>
                        <form:input type="text" class="form-control" path="password2"  required="required"/>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="firstName">First Name:</form:label>
                        <form:input type="text" class="form-control" path="firstName"  required="required"/>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="lastName">Last Name:</form:label>
                        <form:input type="text" class="form-control" path="lastName"  required="required"/>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="address">Address:</form:label>
                        <form:input type="text" class="form-control" path="address"  required="required"/>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="city">City:</form:label>
                        <form:input type="text" class="form-control" path="city"  required="required"/>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="state">State:</form:label>
                        <form:input type="text" class="form-control" path="state"  required="required"/>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="zipCode">State:</form:label>
                        <form:input type="text" class="form-control" path="zipCode"  required="required"/>
                    </div>

                    <div class="form-check">
                        <button type="submit" class="btn btn-register float-right">Submit</button>
                    </div>
                </form:form>
            </div>
            <div class="col-md-8 banner-sec"></div>
        </div>
    </div>
</section>
</body>
</html>
