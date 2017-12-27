<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <title>Личные данные</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/client_save" method="post">
<table style="width:100%">
    <tr>
        <th>Id Клиента</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Дата рождения</th>
        <th>Паспорт</th>
        <th>Адрес регистрации</th>
        <th>Адрес проживания</th>
        <th>Пол</th>
        <th>Номер телефона</th>
        <th>Действие</th>
    </tr>
    <tr>
        <td>
            <p><input type="text" name="id_client" size="10" value="<c:out value="${client.idClient}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="first_name" size="10" value="<c:out value="${client.firstName}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="family_name" size="10"
                      value="<c:out value="${client.familyName}"></c:out>"/></p>
        </td>
        <td>
            <p><input type="text" name="patronymic" size="10"
                      value="<c:out value="${client.patronymic}"></c:out>"/></p>
        </td>
        <td>
            <p><input type="text" name="birth_date" size="10" value="<c:out value="${client.birthDate}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="passport" size="10" value="<c:out value="${client.passport}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="registration" size="10" value="<c:out value="${client.registerLocation}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="address" size="10" value="<c:out value="${client.address}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="sextype" size="10" value="<c:out value="${client.sexType}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="phone_number" size="10" value="<c:out value="${client.phoneNumber}"></c:out>"/>
            </p>
        </td>
        <td>
            <p>
                <button type="submit" name="save" formaction="/web/client_main/client_save">Сохранить
                </button>
            </p>
        </td>
    </tr>
</table>
</br>
</br>
</br>
</br>

<button class="button button1" type="returnBack" name="return" formaction="/web/client_main"
        style="margin: auto; display: block">Вернуться на главную страницу
</button>
</form>
</body>
</html>