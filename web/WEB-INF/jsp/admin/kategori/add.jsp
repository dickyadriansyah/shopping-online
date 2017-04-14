<%-- 
    Document   : add
    Created on : Mar 6, 2017, 7:39:52 PM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@page import="dicky.services.*" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@page import="org.springframework.context.ApplicationContext" %>

<%
            ApplicationContext applicationContext
                    = RequestContextUtils.getWebApplicationContext(request);
            MakeIdService makeidService = (MakeIdService)applicationContext.getBean("makeidService");
            KategoriService kategoriService = (KategoriService) applicationContext.getBean("kategoriService");
            
            String make=makeidService.getId(kategoriService.setId(), "K", 5);
%>

<div class="panel panel-info">
    <div class="panel-heading">
        Kategori Information
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-6">
                <s:form id="form-add-kategori" method="post" commandName="kategori" action="${pageContext.request.contextPath}/admin/kategori/add.html">
                    <div class="form-group">
                        <label>Kode Kategori</label>
                        <s:input path="idKategori" class="form-control" value="<%= make %>" readonly=""/>
                    </div>
                    <div class="form-group">
                        <label>Nama Kategori</label>
                        <s:input path="nama" class="form-control" />
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </s:form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $('#form-add-kategori')
                .bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {

                        nama: {
                            message: 'The name is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'Nama tidak boleh kosong'
                                },
                                stringLength: {
                                    min: 3, 
                                    max: 30,
                                    message: 'Panjang minimal 3 karakter dan panjang maksismu 30 karakter'
                                }
                            }
                        }
                    }
                });
    });
</script>