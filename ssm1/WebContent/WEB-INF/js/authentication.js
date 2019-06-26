function v1() {

	alert("onblur.....");
	
	

	$.ajax({
			url : "/userController",
			type : "get",
			data : {
				name : $("username"),
			},

			success : function rollBack(result) {

				$("pid").html(result);
			},
			error : function(err) {
				confirm(err);
			}
		});
}

function v2() {
	$.ajax({
		url : "/userController",
		type : "get",
		data : {
			password : $("password")
		},

		success : function(result) {
			$("uid").html(result);

		},
		error : function(err) {

		}
	});
}

function v3() {
	alert("v3....");
}