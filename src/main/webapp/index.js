$(document).ready(getList()
);

function getList() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080//job4j_cars_war_exploded/index.do',
        dataType: 'json'
    }).done(function (data) {
        for (var item of data) {
            $('#tableId thead').after('<tr id="' + item.id + '">'
                + '<td>' + item.car.mark.name + '</td>'
                + '<td>' + item.car.body.name + '</td>'
                + '<td>' + item.car.engine.name + '</td>'
                + '<td>' + item.description + '</td>'
                + '<td>' + item.car.price + '</td></tr>')
        }
    }).fail(function (err) {
        console.log(err);
    })
}
