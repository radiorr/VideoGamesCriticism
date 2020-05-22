$(document).ready(function() {
    $.ajax({
        url: "getgra",
        responseTime: 1000,
        dataType: 'json',
        success: function (data) {
            var com = "";

            if (data) {
                if (data.length > 0) {
                    game_id = data[0].game_id;
                    for (x in data) {
                        com = graTemplate(data[x]);
                        $("#cdiv").prepend(com);
                    }
                    $(".noncom").hide();

                } else {

                    com = graTemplate();
                    $("#cdiv").prepend(com);
                    $(".noncom").hide();
                }
            }
        }
    });

    function graTemplate(comment) {
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
        return "<div class='nonecom'>暂无评论" +
            "</div>";
    }
	
	
	
});
