var game_id;
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
                    game_id = data[0].game_id;
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

    var commenttext;
    $(".comsub").click(function () {
        if (username == null) {
            alert("对不起，请登录!");
            window.location.href = "/login";
        }
        commenttext = $("#commenttext").val();
        $.ajax({
            type: "POST",
            url: "newCom",
            responseTime: 1000,
            data: {
                game_id: game_id,
                username: username,
                commenttext: commenttext
            },
            dataType: 'json',
            cache: false,
            success: function (result) {
                if (result == 1) {
                    //alert("评论成功!");用别的插入提示框
                    window.location.reload();
                } else {
                    //alert("评论失败!");用别的插入提示框
                }

            }
        });

    });
	




});
