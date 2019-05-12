<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: swood
  Date: 11/12/2018
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="productForm" type="Forms.ProductForm"--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <title>Sell</title>
    <style>
        <%@include file="/WEB-INF/CSS/SellProduct.css"%>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
</head>
<body>

<div class="container">
    <div class="row main">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h1 class="title">Sell a product</h1>
                <hr />
            </div>
        </div>
        <div class="main-login main-center">
            <form:form class="form-horizontal" modelAttribute="productForm" method="POST" enctype="multipart/form-data">

                <div class="form-group">
                    <form:label class="cols-sm-2 control-label" path="partNumber">Part Number:</form:label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <form:input class="form-control" path="partNumber" required="required"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="name">Item Name:</form:label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <form:input class="form-control" path="name"  required="required"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <form:label class="cols-sm-2 control-label" path="price">Item Price:</form:label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <form:input  class="form-control" path="price"  required="required"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <form:label class="cols-sm-2 control-label" path="image">Upload a picture:</form:label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <input type="file" name="image"/><br>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Sell</button>
                </div>
            </form:form>

            <div class="form-group ">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/Products">
                    <button class="btn btn-success btn-lg btn-block login-button" type="submit">Continue Shopping</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
