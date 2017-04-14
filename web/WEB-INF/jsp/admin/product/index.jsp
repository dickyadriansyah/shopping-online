<%-- 
    Document   : index
    Created on : Mar 8, 2017, 7:41:28 PM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-bordered table-striped table-responsive" id="myTables">
    <thead>
        <tr>
            <th style="width: 35px; background-color: skyblue">No</th>
            <th style="width: 100px; background-color: skyblue">Kode Product</th>
            <th style="width: 200px; background-color: skyblue">Nama</th>
            <th style="width: 100px; background-color: skyblue">Price</th>
            <th style="width: 120px; background-color: skyblue">Foto</th>
            <th style="width: 150px; background-color: skyblue">Kategori</th>
            <th style="width: 110px; background-color: skyblue">Aksi</th>
        </tr>
    </thead>
    <tbody>
        <% int i = 1; %>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><%= i++ %></td>
                <td>${product.idProduct}</td>
                <td>${product.nameProduct}</td>
                <td>${product.price}</td>
                <td><img src="${pageContext.servletContext.contextPath}/uploads/${product.filename}" style="width: 30px; height: 30px;"></td>
                <td>${product.kategori.nama}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/product/delete/${product.idProduct}.html" onclick="return confirm('Apakah anda yakin ?')">Delete</a> |
                    <a href="${pageContext.request.contextPath}/admin/product/edit/${product.idProduct}.html" >Edit</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table> 
