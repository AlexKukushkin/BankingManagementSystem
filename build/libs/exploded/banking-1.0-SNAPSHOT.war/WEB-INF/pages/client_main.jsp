<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .navbar {
            margin-bottom: 20px;
            border-radius: 0;
        }

        .jumbotron {
            margin-bottom: 0px;
        }

        footer {
            background-color: #f2f2f2;
            padding: 10px;
        }

        .btn btn-lg btn-success {
            width: 80px;
        }
    </style>
</head>
<body>
<form method="post">
    <div class="jumbotron">
        <div class="container text-center">
            <h3>Личный кабинет</h3>
        </div>
    </div>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">

            </div>
        </div>
    </nav>
    <br>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <button name="edit" class="btn btn-lg btn-success" formaction="/web/client_main/client_edit"
                        value="edit"  type="submit" style="width: 330px">
                    <b>Изменить личные данные</b>
                </button>
            </div>
            <div class="col-sm-4">
                <button name="info" class="btn btn-lg btn-success" formaction="/web/client_main/client_info"
                        value="info" type="submit" style="width: 330px">
                    <b>Справочная информация</b>
                </button>
            </div>
            <div class="col-sm-4">
                <button name="location" class="btn btn-lg btn-success" formaction="/web/client_main/client_transfer_money"
                        value="location" type="submit" style="width: 330px">
                    <b>Перевести деньги на другой счёт</b>
                </button>
            </div>
        </div>
    </div>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
            </div>

            <div class="col-sm-4">
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <span class="logout-spn">
    <button name="exit" class="btn btn-lg btn-primary btn-block" formaction="logout"
            value="exit" type="submit">Выход
    </button>
    </span>
    <footer class="container-fluid text-center">
        <div class="col-lg-12">
            &copy; 2017 alex kukushkin
        </div>
    </footer>
</form>
</body>
</html>
