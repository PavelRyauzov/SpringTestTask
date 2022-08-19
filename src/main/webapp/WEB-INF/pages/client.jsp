<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/res/bootstrap/bootstrap.min.css"/>" rel="stylesheet">
</head>
<body>

<div class="container py-4">
    <main>
        <a href="/clients" class="d-flex align-items-center text-dark text-decoration-none">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="32" fill="currentColor" class="bi bi-backspace-fill" viewBox="0 0 16 16">
                <path d="M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z"/>
            </svg>
            <span class="fs-4">Вернуться к списку клиентов</span>
        </a>

       <h2 class="my-3">
           Клиент ${client.id}
       </h2>

        <div class="my-3 p-3 bg-body rounded shadow-sm">
            <h6 class="border-bottom pb-2 mb-0">Основные</h6>
            <div class="d-flex text-muted pt-3">
                <p class="pb-3 mb-0 lh-sm border-bottom">
                    <strong class="d-block text-black">ФИО</strong>
                    ${client.fullName}
                </p>
            </div>

            <div class="d-flex text-muted pt-3">
                <p class="pb-3 mb-0 lh-sm border-bottom">
                    <strong class="d-block text-black">Паспорт</strong>
                    Серия: ${client.passportSerial} Номер: ${client.passportNumber}
                </p>
            </div>
            <div class="d-flex text-muted pt-3">
                <p class="pb-3 mb-0 lh-sm border-bottom">
                    <strong class="d-block text-black">Семейное положение</strong>
                    <c:if test="${client.maritalStatus}">В браке</c:if>
                    <c:if test="${!client.maritalStatus}">Не в браке</c:if>
                </p>
            </div>
            <div class="d-flex text-muted pt-3">
                <p class="pb-3 mb-0 lh-sm border-bottom">
                    <strong class="d-block text-black">Адрес прописки</strong>
                    ${client.registrationAddress}
                </p>
            </div>
            <div class="d-flex text-muted pt-3">
                <p class="pb-3 mb-0 lh-sm border-bottom">
                    <strong class="d-block text-black">Контактный номер</strong>
                    +7${client.contactNumber}
                </p>
            </div>
        </div>

        <div class="my-3 p-3 bg-body rounded shadow-sm">
            <h6 class="border-bottom pb-2 mb-0">Сведения о занятости</h6>
            <div class="d-flex text-muted pt-3">
                <p class="pb-3 mb-0 lh-sm border-bottom">
                    <strong class="d-block text-black">Название организации</strong>
                    ${client.companyName}
                </p>
            </div>
            <div class="d-flex text-muted pt-3">
                <p class="pb-3 mb-0 lh-sm border-bottom">
                    <strong class="d-block text-black">Должность</strong>
                    ${client.post}
                </p>
            </div>
            <div class="d-flex text-muted pt-3">
                <p class="pb-3 mb-0 lh-sm border-bottom">
                    <strong class="d-block text-black">Период работы(месяцев)</strong>
                    ${client.workPeriod}
                </p>
            </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2022 Ryauzov Pavel</p>
    </footer>
</div>

</body>
</html>
