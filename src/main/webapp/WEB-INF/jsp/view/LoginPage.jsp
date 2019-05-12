
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--@elvariable id="signInForm" type="Forms.SignInForm"--%>
<%--@elvariable id="error" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <title>Login</title>
    <style>
        <%@include file="/WEB-INF/CSS/Registration.css"%>
    </style>
</head>
<body>
<h3 style="text-align: center; background-color: red;font-size:35px;">${error}</h3>

<section class="register-block">
    <div class="container">
        <div class="row">
            <div class="col-md-4 register-sec">
                <h2 class="text-center">Log in</h2>
                <form:form class="register-form" modelAttribute="signInForm" method="POST">
                    <div class="form-group">
                        <form:label class="text-uppercase" path="loginId">Email Address:</form:label>
                        <form:input type="text" class="form-control" path="loginId" required="required"/>
                    </div>
                    <div class="form-group">
                        <form:label class="text-uppercase" path="password">Password:</form:label>
                        <form:password class="form-control" path="password"  required="required"/>
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