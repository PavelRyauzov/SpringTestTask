<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Решение о кредите</title>

    <link href="<c:url value="/res/bootstrap/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>

<div class="container py-4">
    <header class="d-flex justify-content-center py-3">
        <ul class="nav nav-pills">
            <li class="nav-item"><a href="/" class="nav-link active" aria-current="page">Главная</a></li>
            <li class="nav-item"><a href="/loan-processing/step-1" class="nav-link">Оформить заявку</a></li>
            <li class="nav-item"><a href="/clients" class="nav-link">Список клиентов</a></li>
            <li class="nav-item"><a href="/loanApplications" class="nav-link">Список заявок</a></li>
            <li class="nav-item"><a href="/loanContracts" class="nav-link">Список договоров</a></li>
        </ul>
    </header>

    <main>

        <div class="row g-5">
            <div class="row g-3">
                <c:if test="${loanDecision == null}">
                    <h4 class="mb-3" style="color: red">Кредит не одобрен</h4>
                </c:if>

                <c:if test="${loanDecision != null}">
                    <h4 class="mb-3" style="color: green">Кредит одобрен</h4>

                    <a class="btn btn-primary" href="/loan-processing/step-3" role="button">Оформить кредитный договор</a>
                </c:if>
            </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2022 Ryauzov Pavel</p>
    </footer>
</div>
</body>
</html>
