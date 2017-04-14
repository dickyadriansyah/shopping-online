<%-- 
    Document   : welcome
    Created on : Feb 18, 2017, 10:15:15 PM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<center>
    <h3>
        Welcome ${fullname}
    </h3>
    
    <img src="${pageContext.request.contextPath}/gambar/user.png">
    <br><br>
    Silahkan Click Untuk Melanjutkan Proses Pembelian
    <a href="${pageContext.request.contextPath}/cart.html">Here</a>
</center>
