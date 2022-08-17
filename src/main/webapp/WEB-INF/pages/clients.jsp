<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Клиенты</title>
</head>
<body>
<h1>Клиенты</h1>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>ФИО</th>
            <th>Действие</th>
        </tr>
        <c:forEach var="client" items="${clientsList}">
            <tr>
                <td>${client.id}</td>
                <td>${client.fullName}</td>
                <td>
                    <a href="/edit/${client.id}">edit</a>
                    <form method="post" action="/${client.id}">
                        <input type="submit" value="delete"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<h2>Добавить</h2>
<c:url value="/create" var="create"/>
<a href="${create}">Добавить клиента</a>
</body>
</html>
