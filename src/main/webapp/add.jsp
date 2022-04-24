<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/job4j_cars_war_exploded/body',
                dataType: 'json'
            }).done(function (data) {
                for (var body of data) {
                    var r = "<option value=" + body.id + ">" + body.name + "</option>";
                    $('#bodySelect').append(r)
                }
            }).fail(function (err) {
                console.log(err);
            });
        });
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/job4j_cars_war_exploded/mark',
                dataType: 'json'
            }).done(function (data) {
                for (var mark of data) {
                    var r = "<option value=" + mark.id + ">" + mark.name + "</option>";
                    $('#markSelect').append(r)
                }
            }).fail(function (err) {
                console.log(err);
            });
        });
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/job4j_cars_war_exploded/engine',
                dataType: 'json'
            }).done(function (data) {
                for (var engine of data) {
                    var r = "<option value=" + engine.id + ">" + engine.name + "</option>";
                    $('#engineSelect').append(r)
                }
            }).fail(function (err) {
                console.log(err);
            });
        });
    </script>
    <title>Работа мечты</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <li class="nav">
            <a class="nav-link" href="<%=request.getContextPath()%>/reg.jsp">Регистрация</a>
        </li>
        <div class="card" style="width: 100%">
            <div class="card-header">
                Авторизация
            </div>
            <div class="card-body">
                <form action="<%=request.getContextPath()%>/ads.do" method="post">
                    <div class="form-group">
                        <label>Описания</label>
                        <input type="text" class="form-control" name="description" id="description">
                    </div>
                    <div class="form-group">
                        <label>Кузов</label>
                        <select class="form-control" id="bodySelect" required name="body" >
                            <option></option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Марка</label>
                        <select class="form-control" id="markSelect" required name="mark" >
                            <option></option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Двигатель</label>
                        <select class="form-control" id="engineSelect" required name="engine" >
                            <option></option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Цена</label>
                        <input type="text" class="form-control" name="price" id="price">
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="validate()">Войти</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>