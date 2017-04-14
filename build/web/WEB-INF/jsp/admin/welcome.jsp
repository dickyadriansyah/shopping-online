<%-- 
    Document   : welcome
    Created on : Mar 4, 2017, 10:39:08 AM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Welcome : ${pageContext.request.userPrincipal.name}</h3>
<a href="<c:url value="/j_spring_security_logout" />">LogOut</a>
