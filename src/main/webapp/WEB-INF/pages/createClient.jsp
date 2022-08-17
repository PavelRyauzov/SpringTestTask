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
  <input type="submit" value="Create client">
</form>
</body>
</html>
