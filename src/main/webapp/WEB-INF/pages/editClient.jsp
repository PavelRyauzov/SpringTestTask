<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Редактировать</title>
</head>
<body>
    <h1>Редактировать клиента</h1>
    <c:url value="/edit" var="var"/>
    <form action="${var}" method="post">
        <input type="hidden" name="id" value="${client.id}">

        <label for="fullName">ФИО</label>
        <input type="text" name="fullName" id="fullName" value="${client.fullName}">

        <label for="passportSerial">Серия</label>
        <input type="text" name="passportSerial" id="passportSerial" value="${client.passportSerial}">

        <label for="passportNumber">Номер</label>
        <input type="text" name="passportNumber" id="passportNumber" value="${client.passportNumber}">

        <label for="maritalStatus">Семейное положение</label>
        <select name="maritalStatus" id="maritalStatus">
            <option value="1" <c:if test="${client.maritalStatus}">selected</c:if>>В браке</option>
            <option value="0" <c:if test="${!client.maritalStatus}">selected</c:if>>Не в браке</option>
        </select>

        <label for="registrationAddress">Адрес регистрации</label>
        <input type="text" name="registrationAddress" id="registrationAddress" value="${client.registrationAddress}">

        <label for="contactNumber">Контактный телефон</label>
        <input type="text" name="contactNumber" id="contactNumber" value="${client.contactNumber}">

        <label for="companyName">Название организации</label>
        <input type="text" name="companyName" id="companyName" value="${client.companyName}">

        <label for="post">Должность</label>
        <input type="text" name="post" id="post" value="${client.post}">

        <label for="workPeriod">Период работы</label>
        <input type="text" name="workPeriod" id="workPeriod" value="${client.workPeriod}">

        <input type="submit" value="Edit client">
    </form>
</body>
</html>
