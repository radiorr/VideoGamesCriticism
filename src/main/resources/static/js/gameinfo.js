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
                    $("#chd").prepend(alertsuccess());

                    window.location.reload();
                } else {
                    $("#chd").prepend(alertdanger());

                }

            }
        });
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


    function alertsuccess() {
        return "<div class='alert alert-success alert-dismissable'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>评论成功!</div>"

    }

    function alertdanger() {
        return "<div class='alert alert-danger alert-dismissable'><button type='button' class='close' data-dismiss='alert' aria-hidden='true'>×</button>评论失败!</div>"
    }



});
