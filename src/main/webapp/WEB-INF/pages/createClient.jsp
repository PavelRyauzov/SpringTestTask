<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Создать</title>
</head>
<body>
<h1>Создать клиента</h1>
<c:url value="/create" var="var"/>
<form action="${var}" method="POST">
    <label for="fullName">ФИО</label>
    <input type="text" name="fullName" id="fullName">

    <label for="passportSerial">Серия</label>
    <input type="text" name="passportSerial" id="passportSerial">

    <label for="passportNumber">Номер</label>
    <input type="text" name="passportNumber" id="passportNumber">

    <label for="maritalStatus">Семейное положение</label>
    <select name="maritalStatus" id="maritalStatus">
      <option value="1">В браке</option>
      <option value="0">Не в браке</option>
    </select>

    <label for="registrationAddress">Адрес регистрации</label>
    <input type="text" name="registrationAddress" id="registrationAddress">

    <label for="contactNumber">Контактный телефон</label>
    <input type="text" name="contactNumber" id="contactNumber">

    <label for="companyName">Название организации</label>
    <input type="text" name="companyName" id="companyName">

    <label for="post">Должность</label>
    <input type="text" name="post" id="post">

    <label for="workPeriod">Период работы</label>
    <input type="text" name="workPeriod" id="workPeriod">

    <input type="submit" value="Create client">
</form>
</body>
</html>
