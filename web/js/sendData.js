/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function performAjaxSend() {
//    This function is used to receive data from form and send it to the servlet LoginServlet

//    Data of a form field is taken by its ID and saved in a parameter 
    var usernameLogin = document.getElementById("userLogin").value;
    var passwordLogin = document.getElementById("passwLogin").value;
    
    
    alert(usernameLogin + ", " + passwordLogin);

//    Ajax call, where the parameters are send to the Servlet
    $.ajax({
        type: "POST",
        url: '../LoginServlet',
        cache: false,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
        dataType: "json",
        data: {
            user:usernameLogin,
            passwordUser:passwordLogin
        },
        success: function (data) {
            alert('yay');
        }
    });

}

function performAjaxRegSend() {
//    This function is used to receive data from form and send it to the servlet LoginServlet

//    Data of a form field is taken by its ID and saved in a parameter 
    var username = document.getElementById("username").value;
    var name = document.getElementById("name").value;
    var lastName = document.getElementById("lastName").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    
    alert(username + " " + name + " " + lastName + " " + email);

//    Ajax call, where the parameters are send to the Servlet
    $.ajax({
        type: "POST",
        url: '../RegisterServlet',
        cache: false,
        contentType: "application/x-www-form-urlencoded; charset=UTF-8;",
        dataType: "json",
        data: {
            user:username,            
            firstName:name,            
            lastName:lastName,
            email:email,
            password:password
        },
        success: function (data) {
            alert('yay');
        }
    });

}

