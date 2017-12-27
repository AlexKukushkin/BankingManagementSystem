<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Управление банковскими счетами</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <link href="../web/admin_css/bootstrap.min.css" rel="stylesheet">
    <link href="../web/admin_css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
          rel="stylesheet">
    <link href="../web/admin_css/font-awesome.css" rel="stylesheet">
    <link href="../web/admin_css/style.css" rel="stylesheet">
    <link href="../web/admin_css/dashboard.css" rel="stylesheet">
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <%--<![endif]-->--%>
</head>
<body>
<div class="navbar navbar-fixed-top">
    <form class="navbar-inner" method="post">
        <div class="navbar-inner">
            <div class="container"><a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span
                    class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span> </a><a
                    class="brand">ADMIN DASHBOARD </a>
                <div class="nav-collapse">
                    <ul class="nav pull-right">
                        <button name="exit" class="btn btn-md btn-success btn-block" formaction="logout"
                                value="exit" type="submit">
                            Выход
                        </button>
                    </ul>
                </div>
            </div>
        </div>
</div>
<div class="main">
    <div class="main-inner">
        <div class="container">
            <div class="row">
                <div class="span6">
                    <div class="widget widget-nopad">
                        <div class="widget-header"><i class="icon-list-alt"></i>
                            <h3> Календарь событий</h3>
                        </div>
                        <div class="widget-content">
                            <div id='calendar'>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="span6">
                    <div class="widget">
                        <div class="widget-header"><i class="icon-bookmark"></i>
                            <h3>Выполнить операции :</h3>
                        </div>
                        <div class="widget-content">
                            <div class="shortcuts">
                                <button type="submit" name="showClients" value="showClients" class="shortcut" style="height:130px; width:130px"
                                        formaction="/web/admin_main/admin_client_list">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Просмотр базы клиентов</span>
                                </button>
                                <button type="submit" name="showAccounts" value="showAccounts" class="shortcut" style="height:130px; width:130px"
                                        formaction="/web/admin_main/admin_account_list">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Просмотреть список всех банковских счетов</span>
                                </button>
                                <button type="submit" name="addAccount" value="addAccount" class="shortcut" style="height:130px; width:130px"
                                        formaction="/web/admin_main/admin_add_account">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Открыть новый банковский счёт</span>
                                </button>
                                <button type="submit" name="deleteAccount" value="deleteAccount" class="shortcut" style="height:130px; width:130px"
                                        formaction="/web/admin_main/admin_delete_account">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Удалить банковский счёт</span>
                                </button>
                                <button type="submit" name="getBalance" value="getBalance" class="shortcut" style="height:130px; width:130px"
                                        formaction="/web/admin_main/admin_current_balance">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Просмотреть остаток средств на указанном банковском счёте</span>
                                </button>
                                <button type="submit" name="subBalance" value="subBalance" class="shortcut" style="height:130px; width:130px"
                                        formaction="/web/admin_main/admin_subtract_balance">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Вычесть из баланса указанную сумму с указанного банковского счёта</span>
                                </button>
                                <button type="submit" name="addBalance" value="addBalance" class="shortcut" style="height:130px; width:130px"
                                        formaction="/web/admin_main/admin_add_balance">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Добавить указанную сумму на указанный банковский счёт</span>
                                </button>
                                <button type="submit" name="transferMoney" value="transferMoney" class="shortcut" style="height:130px; width:130px"
                                        formaction="/web/admin_main/admin_transfer_money">
                                    <i class="shortcut-icon icon-list-alt"></i><span class="shortcut-label">Перевести указанную сумму с одного счёта на другой</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="footer-inner">
        <div class="container">
            <div class="row">
                <div class="span12"> &copy; 2017 alex kukushkin</div>
            </div>
        </div>
    </div>
    </form>
</div>

<script src="../web/admin_css/js/excanvas.min.js"></script>
<script src="../web/admin_css/js/jquery-1.7.2.min.js"></script>
<script src="../web/admin_css/js/chart.min.js" type="text/javascript"></script>
<script src="../web/admin_css/js/bootstrap.js"></script>
<script language="javascript" type="text/javascript" src="../web/admin_css/js/full-calendar/fullcalendar.min.js"></script>
<script src="../web/admin_css/js/base.js"></script>
<script>

    var lineChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                pointColor: "rgba(151,187,205,1)",
                pointStrokeColor: "#fff",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]

    }

    var barChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                fillColor: "rgba(220,220,220,0.5)",
                strokeColor: "rgba(220,220,220,1)",
                data: [65, 59, 90, 81, 56, 55, 40]
            },
            {
                fillColor: "rgba(151,187,205,0.5)",
                strokeColor: "rgba(151,187,205,1)",
                data: [28, 48, 40, 19, 96, 27, 100]
            }
        ]

    }

    $(document).ready(function () {
        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();
        var calendar = $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            selectable: true,
            selectHelper: true,
            select: function (start, end, allDay) {
                var title = prompt('Event Title:');
                if (title) {
                    calendar.fullCalendar('renderEvent',
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay
                        },
                        true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },
            editable: true,
            events: [
                {
                    title: 'All Day Event',
                    start: new Date(y, m, 1)
                }
            ]
        });
    });
</script><!-- /Calendar -->
</body>
</html>
