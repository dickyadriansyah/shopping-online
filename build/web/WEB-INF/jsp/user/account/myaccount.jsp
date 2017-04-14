<%-- 
    Document   : myaccount
    Created on : Feb 16, 2017, 6:07:00 PM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-8 col-xs-10 col-xs-offset-1">
    <div class="panel panel-info">
        <div class="panel-heading">
            <strong>   Login Sistem </strong>  
        </div>
        <div class="panel-body">
            ${error }
            <b>${message}</b>
            <br><br>
            <h4>Silahkan Login Terlebih Dahulu Untuk Melakukan Pembelian</h4>
            <br><br>
            <form id="form-login" role="form" action="${pageContext.request.contextPath}/account/myaccount.html" method="POST">
                <br />
                <div class="form-group input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-tag"  ></i></span>
                    <input style="width: 300px;" class="form-control" type="text" name="username"/>
                </div>
                
                 <div class="form-group input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"  ></i></span>
                    <input style="width: 300px;" class="form-control" type="password" name="password"/>
                </div>
                
                <button type="submit" class="btn btn-info" ><span class="glyphicon glyphicon-log-in"></span> Masuk</button>
                
                <hr />
                <a href="${pageContext.request.contextPath}/account/register.html">Registration Here</a>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        $('#form-login')
                .bootstrapValidator({
                    message: 'This value is not valid',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {

                        username: {
                            message: 'The username is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'Username tidak boleh kosong'
                                },
                                stringLength: {
                                    min: 5, 
                                    max: 30,
                                    message: 'Panjang minimal 5 karakter dan panjang maksismu 30 karakter'
                                }
                            }
                        },

                        password: {
                            message: 'The username is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'Password tidak boleh kosong'
                                },
                                stringLength: {
                                    min: 5,
                                    max: 30,
                                    message: 'Panjang minimal 5 karakter dan panjang maksismu 30 karakter'
                                }
                            }
                        }
                    }
                });
    });
</script>