$(document).ready(function () {
    $("body").prepend("<div href='#top' id='back-to-top'>" +
        "<span aria-hidden='true' class='icon-arrow-up'></span>" +
        "</div>"
    );

    $("body").prepend("<nav class='navbar navbar-expand-md bg-dark navbar-dark fixed-top'>" +
        "<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#collapsibleNavbar'>" +
        "<span class='navbar-toggler-icon'></span>" +
        "</button>" +
        "<div style='width: 40%;'>" +
        "</div>" +
        "<div class='collapse navbar-collapse' id='collapsibleNavbar'>" +
        "<ul class='navbar-nav'>" +
        "<li class='nav-item'><a class='nav-link' href='/'>首页</a></li>" +
        "<li class='nav-item'><a class='nav-link' href='/login'>登录</a></li>" +
        "<li class='nav-item'><a class='nav-link' href='/gra'>评分</a></li>" +
        "<li class='nav-item'><a class='nav-link' href='#'>设置</a></li>" +
        "<li class='nav-item'>" +
        "</li>" +
        "</ul>" +
        "</div>" +
        "</nav>"
    );

    //首先将#back-to-top隐藏
    $("#back-to-top").hide();
    //当滚动条的位置处于距顶部600像素以下时，跳转链接出现，否则消失
    $(function () {
        $(window).scroll(function () {
            if ($(window).scrollTop() > 300) {
                $("#back-to-top").fadeIn(500);
            } else {
                $("#back-to-top").fadeOut(500);
            }
        });
        //当点击跳转链接后，回到页面顶部位置
        $("#back-to-top").click(function () {
            $('body,html').animate({
                scrollTop: 0
            }, 800);
            return false;
        });
    });
});
