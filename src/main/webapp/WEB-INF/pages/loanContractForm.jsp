<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Кредитный договор</title>

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

        <div class="py-5 text-center">
            <h2>Кредитный договор</h2>
        </div>

        <div class="row g-5">
            <div class="row g-3">
                <div class="col-12">
                    <label class="form-label">ФИО</label>
                    <p class="form-control">авп${loanApplication.client.fullName}</p>
                </div>

                <div class="col-sm-6">
                    <label class="form-label">Серия паспорта</label>
                    <p class="form-control">${loanApplication.client.passportSerial}</p>
                </div>

                <div class="col-sm-6">
                    <label class="form-label">Номер паспорта</label>
                    <p class="form-control">${loanApplication.client.passportNumber}</p>
                </div>

                <div class="col-12">
                    <label class="form-label">Семейное положение</label>
                    <p class="form-control">
                        <c:if test="${loanApplication.client.maritalStatus}">В браке</c:if>
                        <c:if test="${!loanApplication.client.maritalStatus}">Не в браке</c:if>
                    </p>
                </div>

                <div class="col-12">
                    <label class="form-label">Адрес прописки</label>
                    <p class="form-control">${loanApplication.client.registrationAddress}</p>
                </div>

                <div class="col-12">
                    <label class="form-label">Контактный номер</label>
                    <p class="form-control">+7${loanApplication.client.contactNumber}</p>
                </div>

                <hr class="my-4">

                <h4 class="mb-3">Сведения о занятости</h4>

                <div class="col-md-5">
                    <label class="form-label">Название организации</label>
                    <p class="form-control">${loanApplication.client.companyName}</p>
                </div>

                <div class="col-md-4">
                    <label class="form-label">Должность</label>
                    <p class="form-control">${loanApplication.client.post}</p>
                </div>

                <div class="col-md-3">
                    <label class="form-label">Период работы(месяцев)</label>
                    <p class="form-control">${loanApplication.client.workPeriod}</p>
                </div>

                <hr class="my-4">

                <h4 class="mb-3">Желаемая сумма кредита</h4>

                <div class="col-md-5">
                    <p class="form-control">${loanApplication.desiredLoanAmount}</p>
                </div>

                <hr class="my-4">

                <c:if test="${loanApplication.approvedLoanDecision != null}">
                    <h4 class="mb-3" style="color: green">Кредит одобрен</h4>

                    <div class="col-md-5">
                        <label class="form-label">Предложенный срок в днях</label>
                        <p class="form-control">${loanApplication.approvedLoanDecision.loanMaturity}</p>
                    </div>

                    <div class="col-md-4">
                        <label class="form-label">Одобренная сумма кредита</label>
                        <p class="form-control">${loanApplication.approvedLoanDecision.approvedLoanAmount}</p>
                    </div>
                </c:if>

                <hr class="my-4">

                <form action="/loan-processing/step-3" method="post">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="signingStatus" id="signStatus1" value="0">
                        <label class="form-check-label" for="signStatus1">
                            Не подписывать
                        </label>
                    </div>
                    <div class="form-check ">
                        <input class="form-check-input" type="radio" name="signingStatus" id="signStatus2" value="1" checked>
                        <label class="form-check-label" for="signStatus2">
                            Подписать
                        </label>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Отправить договор</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2022 Ryauzov Pavel</p>
    </footer>
</div>
</body>
</html>
