$(document).ready(function () {
    $.ajax({
        url: "/getpthdata0",
        dataType: 'json',
        success: function (data) {
            var str = "";
            for (var i = 0; i < data.length; i++) {
                str = "<a class=\"list-group-item list-group-item-action\" download=\"" + data[i].name + "\" href=\"" + data[i].path + ".zip\">" + data[i].name + "  下载</a>";
                $(".list-group").append(str);
            }
        },
        error: function (e) {
            alert(e);
        }
    });

})