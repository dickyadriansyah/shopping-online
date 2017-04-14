<%-- 
    Document   : index
    Created on : Mar 14, 2017, 6:27:17 AM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<h3> Transaksi Pembelian Barang </h3>
<table class="table table-bordered table-striped table-hover">
    <tr>
        <th style="background-color: skyblue">Action</th>
        <th style="background-color: skyblue">Item Pic</th>
        <th style="background-color: skyblue">Nama Barang</th>
        <th style="background-color: skyblue">Qty</th>
        <th style="background-color: skyblue">Price</th>
        <th style="background-color: skyblue">Sub Total</th>
    </tr>
    <c:set var="s" value="0"></c:set>
    <c:forEach var="item" items="${sessionScope.cart}" varStatus="i">
        <c:set var="s" value="${s + item.product.price * item.quantity}"></c:set>
        <tr>
            <td><a href="${pageContext.request.contextPath}/cart/delete/${i.index}.html">Delete</a></td>
            <td>
                <a href="#"><img src="${pageContext.request.contextPath}/uploads/${item.product.filename}" style="width: 30px; height: 31px;"></a>
            </td>
            <td>${item.product.nameProduct}</td>
            <td>${item.quantity}</td>
            <td>Rp. ${item.product.price}</td>
            <td>${item.product.price * item.quantity}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5" align="right">Total Jumlah</td>
        <td>Rp. ${s }</td>
    </tr>
    
    
</table>
    
    <a href="${pageContext.request.contextPath}/cart/checkout.html" class="btn btn-primary">CheckOut</a>
