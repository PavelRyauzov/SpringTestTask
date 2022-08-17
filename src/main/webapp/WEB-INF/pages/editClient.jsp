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
        <input type="submit" value="Edit client">
    </form>
</body>
</html>
