$(document).ready(function () {
    $.ajax({
        url: "/getpthword0",
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
                    url: "/topthword1",
                    type: "GET",
                    data: {name: value},
                    success: function (data) {
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
    });

})