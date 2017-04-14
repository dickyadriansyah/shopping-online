<%-- 
    Document   : templateUser
    Created on : Feb 24, 2017, 8:29:40 PM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dicky.services.*" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@page import="org.springframework.context.ApplicationContext" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title }</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrapValidator.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/shop-homepage.css">

        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jQuery.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrapValidator.js"></script>
        <tiles:insertAttribute name="head" ignore="true"></tiles:insertAttribute>
        </head>
        <body>

        <%
            ApplicationContext applicationContext
                    = RequestContextUtils.getWebApplicationContext(request);
            KategoriService kategoriService = (KategoriService) applicationContext.getBean("kategoriService");
        %>

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="background-color: #950c0c">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Application Shopping Chart</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${pageContext.request.contextPath}/home.html">Home</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/about.html">About Us</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/product/list.html">Data Product</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <div class="row">

            <div class="col-md-3">

                <div class="list-group">
                    <%
                        if(session.getAttribute("username") != null){
                    %>
                    <a href="${pageContext.request.contextPath}/account/logout.html" class="list-group-item active">LogOut</a>
                    <%
                        }else{
                    %>
                    <a class="list-group-item active" href="${pageContext.request.contextPath}/account/myaccount.html">Login</a>
                    <%
                        }
                    %>
                    
                    <a class="list-group-item" href="${pageContext.request.contextPath}/cart.html">View Pembelian</a>
                </div>

                <p class="lead">Data Kategori</p>
                <div class="list-group">
                    <c:forEach var="kategori" items="<%= kategoriService.findAll() %>">
                        <a class="list-group-item" href="${pageContext.request.contextPath}/product/kategori/${kategori.idKategori}.html">${kategori.nama}</a>
                    </c:forEach>
                </div>

            </div>

            <div class="col-md-9">

                <div class="row">
                    <tiles:insertAttribute name="content"></tiles:insertAttribute>
                </div>

            </div>

        </div>

    </div>

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Dicky</p>
                </div>
            </div>
        </footer>

    </div>
</body>
</html>
