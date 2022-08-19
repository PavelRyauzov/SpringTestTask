<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Оформление заявки</title>

    <link href="<c:url value="/res/bootstrap/bootstrap.min.css"/>" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="<c:url value="/res/css/form-validation.css"/>" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-4">
    <main>
        <a href="/" class="d-flex align-items-center text-dark text-decoration-none">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="32" fill="currentColor" class="bi bi-backspace-fill" viewBox="0 0 16 16">
                <path d="M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z"/>
            </svg>
            <span class="fs-4">Вернуться на главную</span>
        </a>

        <div class="py-5 text-center">
            <h2>Оформление заявки на кредит</h2>
            <p class="lead">Необходимо заполнить информацию о клиенте</p>
        </div>

        <div class="row g-5">
            <div>
                <h4 class="mb-3">Основные</h4>

                <c:url value="/create" var="var"/>
                <form class="needs-validation" action="${var}" method="post" novalidate>
                    <div class="row g-3">
                        <div class="col-12">
                            <label for="fullName" class="form-label">ФИО</label>
                            <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Фамилия Имя Отчество" value="" required>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="passportSerial" class="form-label">Серия паспорта</label>
                            <input type="text" class="form-control" id="passportSerial" name="passportSerial" placeholder="****" value=""
                                   required>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="passportNumber" class="form-label overflow-hidden">Номер паспорта</label>
                            <input type="text" class="form-control" id="passportNumber" name="passportNumber" placeholder="******" value=""
                                   required>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="maritalStatus" class="form-label">Семейное положение</label>
                            <select class="form-select" id="maritalStatus" name="maritalStatus" required>
                                <option value="1">В браке</option>
                                <option value="0">Не в браке</option>
                            </select>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="registrationAddress" class="form-label">Адрес прописки</label>
                            <input type="text" class="form-control" id="registrationAddress" name="registrationAddress" placeholder="Волгоградская обл., г. Волгоград, ул. Садовая, д. 5, кв. 23" required>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="contactNumber" class="form-label">Контактный телефон</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text">+7</span>
                                <input type="text" class="form-control" id="contactNumber" name="contactNumber" placeholder="**********" required>
                                <div class="invalid-feedback">
                                    error
                                </div>
                            </div>
                        </div>

                        <hr class="my-4">

                        <h4 class="mb-3">Сведения о занятости</h4>

                        <div class="col-md-5">
                            <label for="companyName" class="form-label">Название организации</label>
                            <input type="text" class="form-control" id="companyName" name="companyName" placeholder="Организация" required>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label for="post" class="form-label">Должность</label>
                            <input type="text" class="form-control" id="post" name="post" placeholder="Должность" required>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="workPeriod" class="form-label">Период работы(месяцев)</label>
                            <input type="text" class="form-control" id="workPeriod" name="workPeriod" placeholder="*" required>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>

                        <hr class="my-4">

                        <h4 class="mb-3">Желаемая сумма кредита</h4>

                        <div class="col-md-5">
                            <input type="text" class="form-control" id="desiredLoanAmount" name="desiredLoanAmount" placeholder="Сумма" required>
                            <div class="invalid-feedback">
                                error
                            </div>
                        </div>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Отправить заявку</button>

                    <div></div>
                </form>
            </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2022 Ryauzov Pavel</p>
    </footer>
</div>


<script src="<c:url value="/res/bootstrap/bootstrap.bundle.min.js"/>"></script>

<script src="<c:url value="/res/js/form-validation.js"/>"></script>
</body>
</html>
