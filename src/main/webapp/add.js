$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080//job4j_cars_war_exploded/add',
        dataType: 'json'
    }).done(function (data) {
        for (var mark of data) {
            var r = "<option value=" + mark.id + ">" + mark.name + "</option>";
            $('#mark').append(r)
        }
    }).fail(function (err) {
        console.log(err);
    })
});
$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080//job4j_cars_war_exploded/body',
        dataType: 'json'
    }).done(function (data) {
        for (var body of data) {
            var r = "<option value=" + body.id + ">" + body.name + "</option>";
            $('#body').append(r)
        }
    }).fail(function (err) {
        console.log(err);
    })
});
$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080//job4j_cars_war_exploded/engine',
        dataType: 'json'
    }).done(function (data) {
        for (var engine of data) {
            var r = "<option value=" + engine.id + ">" + engine.name + "</option>";
            $('#engine').append(r)
        }
    }).fail(function (err) {
        console.log(err);
    })
});

function add() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080//job4j_cars_war_exploded/index.do',
        data: {
            description: $('#description').val(),
            mark: $('#mark').val(),
            body: $('#body').val(),
            engine: $('#engine').val()
        }
    }).done(function (data) {

    }).fail(function (err) {
        console.log(err);
    })
}

function addIn() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080//job4j_cars_war_exploded/index.do'
    }).done(function () {
        window.location.href = 'http://localhost:8080//job4j_cars_war_exploded/index.do'
    }).fail(function (err) {
        console.log(err);
    })
}