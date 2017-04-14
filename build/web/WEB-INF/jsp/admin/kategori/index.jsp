<%-- 
    Document   : index
    Created on : Mar 4, 2017, 2:23:17 PM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

${username}
<table class="table table-bordered table-striped table-responsive" id="myTables"> 
    <thead>
        <tr>
            <th style="width: 35px; background-color: skyblue">No</th>
            <th style="width: 100px; background-color: skyblue">Kode Kategori</th>
            <th style="width: 200px; background-color: skyblue">Nama Kategori</th>
            <th style="width: 110px; background-color: skyblue">Aksi</th>
        </tr>
    </thead>
    <tbody>
        <% int i = 1; %>
        <c:forEach var="kategori" items="${kategoris}">
            <tr>
                <td><%= i++ %></td>
                <td>${kategori.idKategori}</td>
                <td>${kategori.nama}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/kategori/edit/${kategori.idKategori}.html">Update</a>|
                    <a href="${pageContext.request.contextPath}/admin/kategori/delete/${kategori.idKategori}.html" onclick="return confirm('Apakah anda yakin ?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
    
</table>
