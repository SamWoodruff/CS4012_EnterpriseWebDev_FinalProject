<%--
  Created by IntelliJ IDEA.
  User: swood
  Date: 11/13/2018
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--@elvariable id="shoppingCart" type="java.util.ArrayList<entities.OrderItem>"--%>
<html>
<head>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <title>Shopping Cart</title>
    <style>
        <%@include file="/WEB-INF/CSS/OrderPages.css"%>
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
        <h1 class="jumbotron-heading">Shopping Cart</h1>
    </div>
</section>

<div class="container mb-4">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col"> </th>
                        <th scope="col" class="text-center">Part Number</th>
                        <th scope="col" class="text-center">Item Name</th>
                        <th scope="col" class="text-center">Quantity</th>
                        <th scope="col" class="text-right">Price</th>
                        <th> </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="total" value="${0}"/>
                    <c:forEach items="${shoppingCart}" var="oI" >
                        <tr>
                            <td><img src="${pageContext.request.contextPath}/image/${oI.product.product_id}" /> </td>
                            <td class="text-center">${oI.product.partNumber}</td>
                            <td class="text-center">${oI.product.name}</td>
                            <td class="text-center">
                                <form action="updateCart/${oI.product.product_id}" method="post">
                                    <input type="number" pattern="[1-9]" title="Quantity" value="${oI.quantity}" name="quantity">
                                    <input type="submit" value="Update">
                                </form>
                            </td>
                            <td class="text-right">$${oI.totalPrice}</td>
                            <td class="text-right">
                                <form action="removeFromCart/${oI.product.product_id}">
                                    <button class="btn btn-sm btn-danger" type="submit"><i class="fa fa-trash"></i> </button>
                                </form>
                            </td>
                        </tr>
                        <c:set var="total" value="${total+oI.totalPrice}" />
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td class="text-center"><strong>Total</strong></td>
                        <td class="text-right"><strong>$${total}</strong></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <form action="<c:out value="${pageContext.request.contextPath}/Products"/>">
                        <button class="btn btn-lg btn-block btn-light text-uppercase" type="submit">Continue Shopping</button>
                    </form>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <form action="<c:out value="confirmOrder"/>">
                        <button class="btn btn-lg btn-block btn-success text-uppercase" type="submit">Confirm Order</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

