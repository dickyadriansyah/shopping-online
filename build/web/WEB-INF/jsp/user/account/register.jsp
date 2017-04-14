<%-- 
    Document   : register
    Created on : Feb 16, 2017, 5:24:07 PM
    Author     : dicky-java
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>


${error }
<s:form id="form-registrasi" method="post" commandName="account" cssClass="form-horizontal"
        action="${pageContext.request.contextPath}/account/register.html">
    <div class="form-group">
        <label class="col-lg-3 control-label">Username</label>
        <div class="col-lg-5">
            <s:input path="username" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label">Password</label>
        <div class="col-lg-5">
            <s:password path="password" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-lg-3 control-label">Full Name</label>
        <div class="col-lg-5">
            <s:input path="fullname" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-lg-9 col-lg-offset-5">
            <button type="submit" class="btn btn-success">Saved</button>
        </div>
    </div>

</s:form>

<script type="text/javascript">
    $(document).ready(function() {
        $('#form-registrasi')
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
                        },
                        
                        fullname: {
                            message: 'The username is not valid',
                            validators: {
                                notEmpty: {
                                    message: 'Full Name tidak boleh kosong'
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