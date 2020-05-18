$(document).ready(function () {
    $("#formdiv").hide();
    $("#postnewcomment").click(function () {
        $("#formdiv").toggle();
        $("#postnewcomment").hide();
    })

    $.ajax({
        url: "getCom",
        responseTime: 1000,
        dataType: 'json',
        success: function (data) {
            var com = "";
            if (data) {
                if (data.length > 0) {

                    for (x in data) {
                        com = cominfoTemplate(data[x]);
                        $("#cdiv").prepend(com);
                    }

                } else {
                    com = nonconinfoTemplate();
                    $("#cdiv").prepend(com);
                }
            }
        }
    });

    function cominfoTemplate(comment) {
        return "<div class='c1'>" +
            "<div class='c2'>" +
            "<div class='c3'>" + comment.com_time + " &nbsp; " + comment.nickname + "</div>" +
            "<div class='c4 nosel'><a name='ulcomment'></a></div>" +
            "<div class='c'></div>" +
            "</div>" +
            "<div class='c6'>" + comment.game_comment + "</div>" +
            "<div class='c7' style='display:none'></div>" +
            "</div>";
    }


    function nonconinfoTemplate() {
        return "<div class='noncom'>暂无评论" +
            "</div>";
    }


});
