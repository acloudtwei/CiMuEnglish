$(document).ready(function () {
    $.ajax({
        url: "/getptharticle0",
        dataType: 'json',
        success: function (data) {
            var str = "";
            for (var i = 0; i < data.length; i++) {
                str = "<a class=\"list-group-item list-group-item-action\">" + data[i].name + "</a>";
                $(".list-group").append(str);
            }
            $(".list-group-item").click(function () {
                var value = $(this).html()
                $.ajax({
                    url: "/toptharticle1",
                    type: "GET",
                    // dataType: 'json',
                    data: {name: value},
                    success: function (data) {
                        // eval(data);
                        window.location.assign(data)
                    },
                    error: function (e) {
                        alert("sh");
                    }
                })
            });
        },
        error: function (e) {
            alert(e);
        }
    })
})