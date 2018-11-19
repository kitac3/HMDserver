/**
 *
 */

//var chatServerUrl = 'http://localhost:8080/';
//var chatServerUrl = '/';
var chatServerUrl = '';

var userId;
var messageId=1;

function addComment(c) {
//	console.log(c.userId);
	if (c.userId == userId) {
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
	}else
	{
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
	p=$("#bms_messages")[0].scrollHeight;
//	p=document.scrollingElement .scrollHeight;
	console.log(p);
	$("#bms_messages").scrollTop(p);
//	$("#bms_messages").animate({scrollTop:p}, 500, "swing");
	read();
}

function init() {
	userId=purl().param('userId');
	if(userId == null)
		alert("UserId is not defined");
	else
	read();
}

function read() {
	$.ajax({
		type : 'get',
		url : chatServerUrl + 'getMessage?id='+messageId,
		// data : JSON.stringify(JSONdata),
		contentType : 'application/json',
		dataType : 'json',
		scriptCharset : 'utf-8'
	}).then(function(data){
		messageId++;
		addComment(data)
	}, function(data) {
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
	var b=$("#bms_send_message").val();
	mess={
			userId : userId,
			body : b
		};
	$.ajax({
		type : 'post',
		url : chatServerUrl + 'putMessage',
		data : JSON.stringify(mess),
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