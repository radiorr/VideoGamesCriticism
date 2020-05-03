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
	
});
