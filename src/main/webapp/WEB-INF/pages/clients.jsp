<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Клиенты</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/res/bootstrap/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>

<div class="container py-4">
    <main>
        <a href="/" class="d-flex align-items-center text-dark text-decoration-none">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="32" fill="currentColor" class="bi bi-backspace-fill" viewBox="0 0 16 16">
                <path d="M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z"/>
            </svg>
            <span class="fs-4">Вернуться на главную</span>
        </a>

        <div class="py-5 text-center">
            <h2>Список клиентов</h2>
        </div>

        <div class="table-responsive">
            <table class="table text-center">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ФИО</th>
                    <th scope="col">Паспорт</th>
                    <th scope="col">Адрес прописки</th>
                    <th scope="col">Контактный телефон</th>
                    <th scope="col">Действие</th>
                </tr>
                </thead>
                <tbody class="table-group-divider">
                <c:forEach var="client" items="${clientsList}">
                    <tr>
                        <th scope="row">${client.id}</th>
                        <td>${client.fullName}</td>
                        <td>${client.passportSerial} ${client.passportNumber}</td>
                        <td>${client.registrationAddress}</td>
                        <td>${client.contactNumber}</td>
                        <td>
                            <a href="/clients/${client.id}">Подробнее</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2022 Ryauzov Pavel</p>
    </footer>
</div>



<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>id</th>--%>
<%--            <th>ФИО</th>--%>
<%--            <th>Паспорт</th>--%>
<%--            <th>Семейное положение</th>--%>
<%--            <th>Адрес прописки</th>--%>
<%--            <th>Контактный телефон</th>--%>
<%--            <th>Сведения о занятости</th>--%>
<%--            <th>Действие</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="client" items="${clientsList}">--%>
<%--            <tr>--%>
<%--                <td>${client.id}</td>--%>
<%--                <td>${client.fullName}</td>--%>
<%--                <td>${client.passportSerial} ${client.passportNumber}</td>--%>
<%--                <td>--%>
<%--                    <c:if test="${client.maritalStatus}">В браке</c:if>--%>
<%--                    <c:if test="${!client.maritalStatus}">Не в браке</c:if>--%>
<%--                </td>--%>
<%--                <td>${client.registrationAddress}</td>--%>
<%--                <td>${client.contactNumber}</td>--%>
<%--                <td>${client.post}, ${client.companyName}, период работы ${client.workPeriod} месяц</td>--%>
<%--                <td>--%>
<%--                    <a href="/edit/${client.id}">edit</a>--%>
<%--                    <form method="post" action="/${client.id}">--%>
<%--                        <input type="submit" value="delete"/>--%>
<%--                    </form>--%>
<%--                    <a href="/${client.id}">Подробнее</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

<%--<h2>Добавить</h2>--%>
<%--<c:url value="/create" var="create"/>--%>
<%--<a href="${create}">Добавить клиента</a>--%>
</body>
</html>
