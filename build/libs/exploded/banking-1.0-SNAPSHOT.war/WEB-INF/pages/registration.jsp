<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel="stylesheet" href="../web/bootstrap/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../web/assets/signup-form.css">
</head>

<body>

<div class="container">
    <div class="signup-form-container">
        <!-- form start -->
        <form method="post" action="/web/register" id="register-form" autocomplete="off">

            <div class="form-header">
                <h3 class="form-title"><i class="fa fa-user"></i> Sign Up</h3>

                <div class="pull-right">
                    <h3 class="form-title"><span class="glyphicon glyphicon-pencil"></span></h3>
                </div>

            </div>

            <div class="form-body">

                <div class="alert alert-info" id="message" style="display:none;">
                    submitted
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="firstName" name="firstName" type="text" value="Alex" class="form-control"
                               placeholder="Имя">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="familyName" name="familyName" type="text" value="Kukushkin" class="form-control"
                               placeholder="Фамилия">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="patronymic" name="patronymic" type="text" value="Vladislav" class="form-control"
                               placeholder="Отчество">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="birthDate" name="birthDate" type="text" value="1991-06-19" class="form-control"
                               placeholder="yyyy-mm-dd">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="passport" name="passport" type="text" value="b12345" class="form-control"
                               placeholder="Паспортные данные">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="registerLocation" name="registerLocation" type="text" value="Кишинёв" class="form-control"
                               placeholder="Адрес регистрации">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="address" name="address" type="text" value="Кишинёв" class="form-control"
                               placeholder="Адрес проживания">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="sexType" name="sexType" type="text" value="м" class="form-control" placeholder="Пол">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="phoneNumber" name="phoneNumber" type="text" value="+37368655678" class="form-control" placeholder="Телефон">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></div>
                        <input id="inputLogin" name="inputLogin" type="text" value="alex" class="form-control"
                               placeholder="Логин">
                    </div>
                    <span class="help-block" id="error"></span>
                </div>

                <div class="row">

                    <div class="form-group col-lg-6">
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                            <input name="inputPassword" id="inputPassword" type="password" class="form-control"
                                   placeholder="Пароль">
                        </div>
                        <span class="help-block" id="error"></span>
                    </div>

                    <div class="form-group col-lg-6">
                        <div class="input-group">
                            <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
                            <input name="retypeInputPassword" type="password" class="form-control"
                                   placeholder="Повторите пароль">
                        </div>
                        <span class="help-block" id="error"></span>
                    </div>
                </div>
            </div>

            <div class="form-footer">
                <button class="button btn btn-lg btn-success"
                        type="submit" style="margin: auto; display: block">
                    Завершить регистрацию
                </button>
            </div>
        </form>
    </div>
</div>
<script src="../web/assets/jquery-1.11.2.min.js"></script>
<script src="../web/assets/jquery.validate.min.js"></script>
<script src="../web/bootstrap/js/bootstrap.min.js"></script>
<script src="../web/assets/register.js"></script>

</body>
</html>
