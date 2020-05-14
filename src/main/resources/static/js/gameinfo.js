$(document).ready(function () {

    $("#formdiv").hide();
    $("#postnewcomment").click(function () {
        $("#formdiv").toggle();
        $("#postnewcomment").hide();
    })
    $.ajax({
            url: "getCom01",
            responseTime: 1000,
            dataType: 'json',
            success: function (data) {
                if (data) {
                    if (data.length > 0) {
                        var com = "";
                        for (x in data) {
                            com = cominfoTemplate(data[x]);
                            $("#cdiv").prepend(com);
                        }

                    } else {
                    }
                }
            }
        }
    );

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

});
