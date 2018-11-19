/**
 *
 */

//var chatServerUrl = 'http://localhost:8080/';
//var chatServerUrl = '/';
var chatServerUrl = '';

function addComment(c) {
//	console.log(c.userId);
	if (c.userId == 2) {
		var mess = c.body;

		$("#bms_messages").append(
						'<div class="bms_message bms_left">\
                    <div class="bms_message_box">\
                        <div class="bms_message_content">\
                            <div class="bms_message_text">'+mess+
                            '</div>\
                        </div>\
                    </div>\
                </div>\
                <div class="bms_clear"></div>');
	}
	if (c.userId == 1) {
		var mess = c.body;

		$("#bms_messages").append(
								'<div class="bms_message bms_right">\
		                    <div class="bms_message_box">\
		                        <div class="bms_message_content">\
		                            <div class="bms_message_text">'+mess+
		                            '</div>\
		                        </div>\
		                    </div>\
		                </div>\
		                <div class="bms_clear"></div>');
	}
	p=$("#bms_messages")[0].scrollHeight;
//	p=document.scrollingElement .scrollHeight;
	console.log(p);
	$("#bms_messages").scrollTop(p);
//	$("#bms_messages").animate({scrollTop:p}, 500, "swing");
	read();
}

function init() {
	read();
}

function read() {
	$.ajax({
		type : 'get',
		url : chatServerUrl + 'seleSide',
		// data : JSON.stringify(JSONdata),
		contentType : 'application/json',
		dataType : 'json',
		scriptCharset : 'utf-8'
	}).then(addComment, function(data) {
		if (data.responseText == "")
			read();
		else {
			alert("get error:" + JSON.stringify(data))
			// alert("get error:"+data)
		}
	});
}
function put(message) {
	$.ajax({
		type : 'post',
		url : chatServerUrl + 'seleComment',
		data : message.value,
		contentType : 'application/json;charset=UTF-8',
		dataType : 'text',
		scriptCharset : 'UTF-8',
	}).done(function(data) {

		// Success
		console.log("success:" + data);
	}).fail(function(data) {

		// Error
		console.log("Fail:" + data);
	});
	$('textarea[id="bms_send_message"]').val("");
}

function putM() {
	mess=$("#bms_send_message").val();
	$.ajax({
		type : 'post',
		url : chatServerUrl + 'seleComment',
		data : mess,
		contentType : 'application/json;charset=UTF-8',
		dataType : 'text',
		scriptCharset : 'UTF-8',
	}).done(function(data) {

		// Success
		console.log("success:" + data);
	}).fail(function(data) {

		// Error
		console.log("Fail:" + data);
	});
	$('textarea[id="#bms_send_message"]').val("");
}