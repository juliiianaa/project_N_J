<%-- 
    Document   : allUsers
    Created on : 26-sep-2016, 14:37:06
    Author     : juulz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" charset="utf8" src="js/jquery.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="js/dataTables.js"></script>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <link href="css/menu.css" rel="stylesheet">
        <link href="css/book.css" rel="stylesheet">
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
        <title>JSP Page</title>
    </head>
    
        
        <ul>
          <li><a class="active" href="../">Home</a></li>
          <li><a href="#">BookGame</a></li>
          <li class="dropdown">
            <a href="#" class="dropbtn">Extra info</a>
            <div class="dropdown-content">
              <a href="#">Help</a>
              <a href="#">FAQ</a>
              <a href="#">Contact us</a>
            </div>
          </li>
        </ul>

        
            <table id="user_table" class="display">
                <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>username</th>
                        <th>email</th>
                        <th>user access</th>
                    </tr>
                </thead>
                <c:if test="${not empty requestScope.usersList}">
                    <c:forEach items="${requestScope.usersList}" var="user">
                        <tr>
                            <td>${user.username }</td>
                            <td>${user.firstName }</td>
                            <td>${user.lastName }</td>
                            <td>${user.emailAdress }</td>
                            <td>${user.userAccess }</td>
                        </tr>
                    </c:forEach>
                </c:if>
                <tfoot>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>username</th>
                        <th>email</th>
                        <th>user access</th>
                    </tr>
                </tfoot>
            </table>
        
    
</html>
