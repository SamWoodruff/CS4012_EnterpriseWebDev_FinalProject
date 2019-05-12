<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--@elvariable id="products" type="java.util.ArrayList<entities.Product>"--%>
<%--@elvariable id="shoppingCart" type="java.util.ArrayList<entities.OrderItem>"--%>
<html>
<head>
    <title>Products</title>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
    <style>
        <%@include file="/WEB-INF/CSS/ProductListing.css"%>
    </style>
</head>

<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="">Yun & Samuel</a>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <li class="nav-item m-auto">
                    <a class="nav-link" href="<c:out value="Products" />">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:out value="SellProduct"/>">Sell</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:out value="orders"/>">Orders</a>
                </li>
            </ul>

            <form class="form-inline my-2 my-lg-0">
                <a class="btn btn-success btn-sm ml-3" href="<c:out value="ViewCart"/>">
                    <i class="fa fa-shopping-cart"></i> Cart
                    <span class="badge badge-light">
                        <c:if test="${empty shoppingCart}">0</c:if>
                        <c:if test="${not empty shoppingCart}">${shoppingCart.size()}</c:if>
                    </span>
                </a>
            </form>
        </div>
    </div>
</nav>

<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Products</h1>
    </div>
</section>

<div class="container">
    <div class="row" style="margin-bottom: 20px">
    <c:forEach items="${products}" var="current" varStatus="loop">
        <c:if test="${loop.index % 4 == 0 && loop.index != 0}">
            </div>
            <div class="row" style="margin-bottom: 20px">
        </c:if>
        <div class="col-md-3 col-sm-6">
            <div class="product-grid">
                <div class="product-image">
                    <img class="pic-1" src="${pageContext.request.contextPath}/image/${current.product_id}">
                </div>
                <div class="product-content">
                    <h3 class="title">Item Number: <c:out value="${current.partNumber}"/></h3>
                    <h3 class="title">Item Name: <c:out value="${current.name}"/></h3>
                    <div class="price">$<c:out value="${current.price}"/></div>
                    <form action="<c:out value="addToCart/${current.product_id}"/>" method="post">
                        Quantity: <input type="number" pattern="[1-9]" title="Quantity" value="1" name="quantity">
                        <input class="add-to-cart" type="submit" value="Add to cart">
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
    </div>
</div>

</body>

</html>