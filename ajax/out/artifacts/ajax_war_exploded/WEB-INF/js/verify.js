function verify() {

    var jequeryObl = $("#username");
    var username = jequeryObl.val();

    //$.get()
    //jQuery.ajax()

    $.get("http://localhost:8080/AServlet", {name: $("#username").val()}, function (result) {
        $("#span").html(result);
    });


    alert(username);
}


function v2() {
    $.ajax(
        url
:
    "http://localhost:8080/a/a.html",
        type
:
    "get",
        dataType
:
    "json",
        suceess
:

    function (result) {
        alert(result);

    }

,
    error:function (err) {
        alert(err);
    }
)
    ;
}