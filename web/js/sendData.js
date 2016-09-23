/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function performAjaxSend() {
//    This function is used to receive data from form and send it to the servlet LoginServlet

//    Data of a form field is taken by its ID and saved in a parameter 
    var username = document.getElementById("username").value;
    var password = document.getElementById("passw").value;

//    Ajax call, where the parameters are send to the Servlet
    $.ajax({
        type: "POST",
        url: '../LoginServlet',
        cache: false,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
        dataType: "json",
        data: {
            user:username,
            passwordUser:password
        },
        success: function (data) {
            alert('yay');
        }
    });

}
