<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Заявка</title>

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
            <h2>Заявка на кредит 1</h2>
        </div>

        <div class="row g-5">
            <div class="row g-3">
                <div class="col-12">
                    <label class="form-label">ФИО</label>
                    <p class="form-control">Ряузов Павел Евгеньевич</p>
                </div>

                <div class="col-sm-6">
                    <label class="form-label">Серия паспорта</label>
                    <p class="form-control">1215</p>
                </div>

                <div class="col-sm-6">
                    <label class="form-label">Номер паспорта</label>
                    <p class="form-control">621822</p>
                </div>

                <div class="col-12">
                    <label class="form-label">Семейное положение</label>
                    <p class="form-control">В браке</p>
                </div>

                <div class="col-12">
                    <label class="form-label">Адрес прописки</label>
                    <p class="form-control">Ахтубинск</p>
                </div>

                <div class="col-12">
                    <label class="form-label">Контактный номер</label>
                    <p class="form-control">89171823105</p>
                </div>

                <hr class="my-4">

                <h4 class="mb-3">Сведения о занятости</h4>

                <div class="col-md-5">
                    <label class="form-label">Название организации</label>
                    <p class="form-control">Аксиоматика</p>
                </div>

                <div class="col-md-4">
                    <label class="form-label">Должность</label>
                    <p class="form-control">джун</p>
                </div>

                <div class="col-md-3">
                    <label class="form-label">Период работы(месяцев)</label>
                    <p class="form-control">6</p>
                </div>

                <hr class="my-4">

                <h4 class="mb-3">Желаемая сумма кредита</h4>

                <div class="col-md-5">
                    <p class="form-control">5000000</p>
                </div>
            </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2022 Ryauzov Pavel</p>
    </footer>
</div>
</body>
</html>
