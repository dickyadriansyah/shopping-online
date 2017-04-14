<%-- 
    Document   : add
    Created on : Mar 10, 2017, 9:41:59 PM
    Author     : dicky-java
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="panel panel-info">
    <div class="panel-heading">
        Product Information
    </div>
    <div class="panel-body">
        <div class="row">
            <div class="col-lg-6">
                <form id="form-edit-product" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/admin/product/edit.html">
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Kode Product</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="idproduct" value="${product.idProduct}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Name Product</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="nama" value="${product.nameProduct}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Price</label>
                        <div class="col-lg-5">
                            <input type="text" class="form-control" name="price" value="${product.price}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Kategori</label>
                        <div class="col-lg-5">
                            <select name="idkategori" class="form-control">
                                <c:set var="select" value="null"></c:set>
                                <c:forEach var="kategori" items="${kategoris}">
                                    <c:choose>
                                        <c:when test="${kategori.idKategori eq product.kategori.idKategori}">
                                            <c:set var="select" value="selected"></c:set>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set var="select" value=""></c:set>
                                        </c:otherwise>
                                    </c:choose>
                                    <option value="${kategori.idKategori}" ${select}>${kategori.nama}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                        <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $('#form-edit-product')
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
                        },
                        
                        idkategori: {
                            message: 'The kategori is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'Kategori tidak boleh kosong'
                                }
                            }
                        },
                        
                        price: {
                            message: 'The price is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'Price tidak boleh kosong'
                                }
                            }
                        }
                        
                    }
                });
    });
</script>