// ajax 之 $.get()

function verify() {

	// 得到jQuery对象
	var jequeryObl = $("#username");
	// 得到jQuery对象的值
	var username = jequeryObl.val();

	// 使用ajax发送请求,并且调用回调函数
	$.get("/a/AServlet", {
		name : username,
		pass : "110"
	}, rollback);
}

function rollback(data) {

	// alert("1101023");
	// alert(data);

	var span = $("#span");
	span.html(data);

}

// ajax 之 $.get()
// 简洁写法
function v2() {

	$.get("/a/AServlet", {
		name : $("#username").val()
	}, function(data) {
		$("#span").html(data);

	});
}

// ajax 之 $.post()
function v3() {

	$.get("/a/AServlet", {
		name : $("#username").val()
	}, function(result) {
		$("#span").html(result);
	});
}

function v4() {
	$.ajax({

		url : "http://192.168.1.105:8080/a/AServlet",
		type : "get",
		data : {
			name : $("#username").val()
		},
		dataType : "text",

		success : function(result) {
			$("#span").html(result);
			// alert("success\n" + result);
		},
		error : function(err) {
			alert("error\n" + err);
		}
	});

}
