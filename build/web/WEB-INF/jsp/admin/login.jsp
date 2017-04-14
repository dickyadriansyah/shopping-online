<%-- 
    Document   : login
    Created on : Mar 4, 2017, 10:24:01 AM
    Author     : dicky-java
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrapValidator.css">

        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrapValidator.js"></script>
    </head>
    <body>

        <div class="container">
            <div class="row text-center ">
                <div class="col-md-12">
                    <br /><br />
                    <h2>Login Admin</h2>
                </div>
            </div>
            <div class="row ">

                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong>   Enter Details To Login </strong>  
                        </div>
                        <div class="panel-body">
                            ${msg}<br>
                            <form name="loginForm" action="<c:url value='/j_spring_security_check' />" method="POST">
                                <br />
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                                    <input type="text" class="form-control" placeholder="Your Username " name="username" />
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                                    <input type="password" class="form-control"  placeholder="Your Password" name="password" />
                                </div>
                                
                                <input name="submit" type="submit" value="Login" class="btn btn-lg btn-success btn-block">
                            </form>
                        </div>

                    </div>
                </div>


            </div>
        </div>

    </body>
</html>
