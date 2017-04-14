<%-- 
    Document   : templateAdmin
    Created on : Mar 4, 2017, 2:19:45 PM
    Author     : dicky-java
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Area</title>
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/font-awesome.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap-datepicker.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/assets/css/bootstrapValidator.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/assets/css/custom.css" rel="stylesheet" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

        <script src="${pageContext.request.contextPath}/assets/js/jQuery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/bootstrapValidator.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.metisMenu.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/morris/raphael-2.1.0.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/morris/morris.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/dataTables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/assets/js/dataTables/dataTables.bootstrap.js" type="text/javascript"></script>

        <script type="text/javascript">
            $(function (){
               $("#myTables").dataTable(); 
            });
        </script>
        
        <script type="text/javascript">
            window.history.forward();
            function noBack() {
                window.history.forward();
            }
        </script>
    </head>
    <body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Admin Area</a> 
                </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <i class="fa fa-asterisk fa-4x user-image img-responsive"></i>
                        </li>
                        <li>
                            <a class="active-menu"  href="#"><i class="fa fa-dashboard fa-2x"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-file-text-o fa-2x"></i> Data Kategori<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/kategori/add.html">Add Kategori</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/kategori.html">List Kategori</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-file-text-o fa-2x"></i> Data Product<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/product/add.html">Add Product</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/admin/product.html">List Product</a>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="<c:url value="/j_spring_security_logout" />"><i class="fa fa-sign-out fa-2x"></i> LogOut</a>
                        </li>
                    </ul>
                </div>

            </nav>  

            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <center>
                                <h2 style="color: #003399"><span class="fa fa-shopping-cart fa-2x"></span>Admin Area</h2>
                            </center>
                        </div>
                    </div>              
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row">
                        <div class="col-md-12">
                            <tiles:insertAttribute name="content"></tiles:insertAttribute>
                            </div>
                        </div>            
                    </div>
                </div>

            </div>

            <script src="${pageContext.request.contextPath}/assets/js/custom.js" type="text/javascript"></script>

       
    </body>
</html>

