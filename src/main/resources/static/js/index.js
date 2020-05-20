$(document).ready(function() {
	
	$.ajax({
			url: "getAllGame",
			responseTime: 1000,
			dataType: 'json',
			success: function(data) {
				if (data) {
					if (data.length > 0) {
						var html = "";

						for (x in data) {
							html += gameinfoTemplate(data[x]);
						}
						$(".itg").append(html);
                        $(".none").hide();
					} else {
                        $(".itg").append(nongameinfoTemplate());
                        $(".none").hide();
					}
				}
			}
		}


	);

	function gameinfoTemplate(game) {

		var cstype;

		switch (game.game_group) {
			case 'RPG':
				cstype = 'ct2';
				break;
			case 'MOBA':
				cstype = 'ct3';
				break;
			case 'FPS':
				cstype = 'ct4';
				break;
			case 'TPS':
				cstype = 'ct5';
				break;
			case 'TCG':
				cstype = 'cta';
				break;
			case 'ACT':
				cstype = 'ct9';
				break;
			case 'FTG':
				cstype = 'ct6';
				break;
			case 'STG':
				cstype = 'ct7';
				break;
			case 'RTS':
				cstype = 'ct8';
				break;
			case 'AVG':
				cstype = 'ct1';
				break;
		}
		//游戏信息div
		return "<div class='gl1t' data-new='1'>" +
			"<a class='gameinfo' href='"+ game.game_id+"' >" +
			"<div class='gl4t glname glink' >" + game.game_zname + "</div>" +
			"</a>" +
			"<div class='gl3t' style='height:340px;width:250px' >" +
			"<div class='fica'>" +
			"<div class='cs " + cstype + "' >" + game.game_group + "</div>" +
			"</div>" +
			"<div class='num'>"+game.game_info+"</div>" +
			"<a class='gameinfo' href='"+game.game_id+"' > " +
			"<img class='img-fluid m-auto' style='height:348px;top:-4px' alt='" + game.game_zname + "' title='" + game.game_zname +
			"' src='/" + game.game_pic_url + "' class=''></a>" +
			"</div>" +
			"</div>";
	}

    function nongameinfoTemplate() {
        return "<div class='none'><p>数据库连接错误</p></div>"

    }

});
