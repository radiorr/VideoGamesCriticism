$(document).ready(function() {

	$(".loginout").click(function() {
		$
			.cookie(
				"remember",
				"false", {
					expires: -1
				});
		$
			.cookie(
				"username",
				"", {
					expires: -1
				});

		window.location.href = '/'
	});




	/* $(".pttdiv").append(
		"<ul class='pagination ptt' style='margin: 0px auto 0px;'>" +
		"<li><a href='#'>&laquo;</a></li>" +
		"<li class='active'><a href='#'>1</a></li>" +
		"<li><a href='#'>2</a></li>" +
		"<li><a href='#'>3</a></li>" +
		"<li><a href='#'>4</a></li>" +
		"<li><a href='#'>5</a></li>" +
		"<li><a href='#'>6</a></li>" +
		"<li><a href='#'>7</a></li>" +
		"<li><a href='#'>&raquo;</a></li>" +
		"</ul>"
	); */
});
