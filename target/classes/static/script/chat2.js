/**
 *
 */

var chatServerUrl = 'http://localhost:8080/';

function addComment(c) {
	if (c.userId == 1) {
		var mess = c.body;

		$("body")
				.append(
						'<div class="chat-box"><div class="chat-face">\
			<img src="Pict/f430.png" alt="自分のチャット画像です。" width="90" height="90">\
	  </div>\
	  <div class="chat-area">\
	    <div class="chat-hukidashi">'
								+ mess + '</div>\
	  </div>\
	</div>');
	}
	if (c.userId == 2) {
		var mess = c.body;

		$("body")
				.append(
						'<div class="chat-box"><div class="chat-face">\
			<img src="Pict/server.png" alt="Seleniumのチャット画像です。" width="90" height="90">\
	  </div>\
	  <div class="chat-area">\
	    <div class="chat-hukidashi">'
								+ mess + '</div>\
	  </div>\
	</div>');
	}
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
	$('input[name="textBox"]').val("");
}