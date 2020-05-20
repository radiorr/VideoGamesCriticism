$(document).ready(function() {

    $(".regbox").hide();
    $(".reg").click(function () {
		$(".loginbox").toggle();
		$(".regbox").toggle();
    });


	function getEle(selector) {
		return document.querySelector(selector);
	}

	// 二、获取到需要用到的DOM元素
	var box = getEle("#box"), // 容器
		bgColor = getEle(".bgColor"), // 背景色
		txt = getEle(".txt"), // 文本
		slider = getEle(".slider"), // 滑块
		successMoveDistance = box.offsetWidth - slider.offsetWidth, // 解锁需要滑动的距离
		downX, // 用于存放鼠标按下时的位置
		isSuccess = false; // 是否解锁成功的标志，默认不成功


	$(window).resize(function() {
		isSuccess = false;
		box = getEle("#box"); // 容器
		bgColor = getEle(".bgColor"); // 背景色
		txt = getEle(".txt"); // 文本
		slider = getEle(".slider"); // 滑块
		successMoveDistance = box.offsetWidth -
			slider.offsetWidth; // 解锁需要滑动的距离
		downX; // 用于存放鼠标按下时的位置

		var e = e || window.event || e.which;
		mouseupHandler(e);
	});

	// 3.1鼠标按下事件的方法实现
	function mousedownHandler(e) {

		bgColor.style.transition = "";
		slider.style.transition = "";
		var e = e || window.event || e.which;
		downX = e.clientX;
		// 在鼠标按下时，分别给鼠标添加移动和松开事件
		document.onmousemove = mousemoveHandler;
		document.onmouseup = mouseupHandler;
	};

	// 四、定义一个获取鼠标当前需要移动多少距离的方法
	function getOffsetX(offset, min, max) {
		if (offset < min) {
			offset = min;
		} else if (offset > max) {
			offset = max;
		}
		return offset;
	}

	// 3.1.1鼠标移动事件的方法实现
	function mousemoveHandler(e) {

		var e = e || window.event || e.which;
		var moveX = e.clientX;
		var offsetX = getOffsetX(moveX - downX, 0,
			successMoveDistance);
		bgColor.style.width = offsetX + "px";
		slider.style.left = offsetX + "px";

		if (offsetX == successMoveDistance) {
			success();
		}
		// 如果不设置滑块滑动时会出现问题（目前还不知道为什么）
		e.preventDefault();
	};

	// 3.1.2鼠标松开事件的方法实现
	function mouseupHandler(e) {

		if (!isSuccess) {
			bgColor.style.width = 0 + "px";
			slider.style.left = 0 + "px";
			bgColor.style.transition = "width 0.8s linear";
			slider.style.transition = "left 0.8s linear";
			txt.innerHTML = "";
			bgColor.style.backgroundColor = "#92afd7";
			$(".slider>span").removeClass();
			$(".slider>span").addClass(
				"icon-arrow-right2");
			$(".logincheck").attr('disabled', true);
			slider.onmousedown = mousedownHandler;
		}
		document.onmousemove = null;
		document.onmouseup = null;
	};

	// 五、定义一个滑块解锁成功的方法
	function success() {

		$("#errbox").text("");
		isSuccess = true;
		txt.innerHTML = "解锁成功";
		bgColor.style.backgroundColor = "lightgreen";
		// 滑动成功时，移除鼠标按下事件和鼠标移动事件
		slider.onmousedown = null;
		document.onmousemove = null;
		$(".logincheck").attr('disabled', false);
		$(".slider>span").removeClass();
		$(".slider>span").addClass("icon-checkmark");
	};

	// 查询用户cookie，如果有直接登录
	var rem = $.cookie('remember');
	if (rem) {
		$(".remember").prop("checked", true);
		window.location.href = 'test'
	}
	/*
	 * 输入框得到焦点隐藏错误信息
	 */
	$("input").focus(function() {
		$("#errbox").text(""); // 把label的内容清空！
	});


	// 大写提示	
	$("#tpassword").keypress(function(e) {
		var e = event || window.event;
		var keyCode = e.keyCode || e.which; //按键的keyCode。
		var isShift = e.shiftKey || (keyCode == 16) || false; //shift键是否按住。
		if (((keyCode >= 65 && keyCode <= 90) && !isShift) | ((keyCode >= 97 && keyCode <= 122) && isShift))
			$("#errbox").text("正在使用大写");
		else
			$("#errbox").text("");
	});

	/*
	 * 输入框失去焦点进行校验
	 */
	$("input").blur(function() {
		var login = $("#tnumber").val();
		var pwsd = $("#tpassword").val();
		// 如果账户或者密码为空，则提示账号或密码为空
		if (login == "" || pwsd == "") {
			$("#rightbox").text("");
            $("#errbox").text("账号或密码不能为空!");
			$(".logincheck").attr('disabled', true);
			slider.onmousedown = null;
		} else {
			// 给滑块添加鼠标按下事件
			slider.onmousedown = mousedownHandler;
			if (isSuccess == false) {
				$("#errbox").text("请验证!");
				$(".logincheck").attr('disabled', true);
			}

		}
	});

	// 登录验证
	$(".logincheck")
		.click(
			function() {
                var tnumber = $("#tnumber").val();
                var tpassword = $("#tpassword").val();

				$("#rightbox").text("");
				$("#errbox").text("");
				$(".logincheck").attr('disabled', true);
				$("#rightbox").text("正在登录...");
				$
					.ajax({
						type: 'post',
						url: 'usercheck',
                        responseTime: 1000,
						data: {
                            tnumber: tnumber,
                            tpassword: tpassword
						},
						dataType: 'json',
						cache: false,
						success: function(result) {
							if (result == 1) {
								// 记住密码功能
								if ($(".remember")
									.prop(
										"checked")) {
									// 有效期七天
									$
										.cookie(
											"remember",
											"true", {
												expires: 7
											});
									$
										.cookie(
                                            "tnumber",
											login, {
												expires: 7
											});


								} else {
									$
										.cookie(
											"remember",
											"false", {
												expires: -1
											});
									$
										.cookie(
                                            "tnumber",
											"", {
												expires: -1
											});

								}
                                window.location.href = '/';
							} else {

								$("#rightbox")
									.text("");
								$('#errbox').text(
                                    '账号或密码错误');
								isSuccess = false;
								var e = e || window.event || e.which;
								mouseupHandler(e);
							}
						}
					});
			});

	// 回车登录
    /*
        $(document)
            .keyup(
                function(event) {
                    if (event.keyCode == 13 &&
                        $(".logincheck").prop(
                            "disabled") == false) {
                        $(".logincheck").trigger("click");
                    }
                });*/


    $(".rnumber").hide();
    $(".nickname").hide();
    $(".rpassword").hide();
    $(".regcheck").attr('disabled', true);

    $("#rnumber").focus(function () {
        $(".rnumber").toggle();
    });

    $("#nickname").focus(function () {
        $(".nickname").toggle();
    });

    $("#rpassword").focus(function () {
        $(".rpassword").toggle();
    });

    $("#rnumber").blur(function () {
        $(".rnumber").toggle();
    });

    $("#nickname").blur(function () {
        $(".nickname").toggle();
    });

    $("#rpassword").blur(function () {
        $(".rpassword").toggle();
    });

    $("input").focus(function () {
        $("#rerrbox").text(""); // 把label的内容清空！
    });


    $("input").blur(function () {
        var c = /^[a-zA-Z]\w{8,14}$/;
        var rnickname = /^\w{0,14}$/;

        var login = $("#rnumber").val();
        var nickname = $("#nickname").val();
        var pwsd = $("#rpassword").val();
        var pwsd2 = $("#rpassword2").val();

        if (!c.test(login)) {
            $(".rightbox").text("");
            $(".rerrbox").text("账号格式错误");
            return false;
        } else {
            $(".rightbox").text("");
        }
        if (!rnickname.test(nickname)) {
            $(".rightbox").text("");
            $(".rerrbox").text("昵称格式错误");
            return false;
        } else {
            $(".rightbox").text("");
        }
        if (!c.test(pwsd)) {
            $(".rightbox").text("");
            $(".rerrbox").text("密码格式错误");
            return false;
        } else {
            $(".rightbox").text("");
        }
        if (pwsd != pwsd2) {
            $(".rightbox").text("");
            $(".rerrbox").text("密码错误");
            return false;
        } else {
            $(".rightbox").text("");
        }

        if (!$(".ragree").prop("checked")) {
            $(".rightbox").text("");
            $(".rerrbox").text("未同意条款");
            return false;
        } else {
            $(".rightbox").text("");
        }
        // 如果账户或者密码为空，则提示账号或密码为空
        if (login == "" || pwsd == "" || nickname == "") {
            $(".rightbox").text("");
            $(".rerrbox").text("账号或密码或昵称不能为空!");
            return false;
        } else {
            $(".regcheck").attr('disabled', false);
            $(".rightbox").text("");
        }


    });


    $(".regcheck")
        .click(
            function () {
                var rnumber = $("#rnumber").val();
                var nickname = $("#nickname").val();
                var rpassword = $("#rpassword").val();

                $("#rightbox").text("");
                $("#errbox").text("");
                $(".logincheck").attr('disabled', true);
                $("#rightbox").text("正在登录...");

                $.ajax({
                    type: 'post',
                    url: 'regcheck',
                    data: {
                        rnumber: rnumber,
                        rpassword: rpassword,
                        nickname: nickname
                    },
                    dataType: 'json',
                    cache: false,
                    success: function (result) {

                        if ($(".remember")
                            .prop(
                                "checked")) {

                            $
                                .cookie(
                                    "remember",
                                    "true", {
                                        expires: 1
                                    });
                            $
                                .cookie(
                                    "rnumber",
                                    login, {
                                        expires: 1
                                    });
                            $(".indexhtml").toggle();
                            $(".loginouthtml").toggle();
                            window.location.href = '/'
                        } else {

                            $("#rightbox")
                                .text("");
                            $('#errbox').text(
                                '账号或密码错误');
                        }
                    }
                });
            });
	
	
	
});
