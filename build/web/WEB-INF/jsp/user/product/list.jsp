<%-- 
    Document   : list
    Created on : Feb 14, 2017, 6:23:31 AM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="product" items="${productlist}">

    <div class="col-sm-4 col-lg-4 col-md-4">
        <div class="thumbnail">
            <img src="${pageContext.request.contextPath}/uploads/${product.filename}" style="width: 100px; height: 100px;">
            <div class="caption">
                <h4 class="pull-right">Rp. ${product.price}</h4>
                <h4><a href="${pageContext.request.contextPath}/cart/buy/${product.idProduct}.html">${product.nameProduct}</a>
                </h4>
            </div>
            <div class="ratings">
                <p>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                    <span class="glyphicon glyphicon-star"></span>
                </p>
            </div>
        </div>
    </div>
</c:forEach>
