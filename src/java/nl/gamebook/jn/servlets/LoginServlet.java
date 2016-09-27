/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.gamebook.jn.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.gamebook.jn.database.MysqlDatabaseConnector;
import nl.gamebook.jn.database.RetrieveMysqlData;
import nl.gamebook.jn.database.User;

/**
 *
 * A servlet which receive the data from the ajax call in sendData.js (function called performAjaxSend)
 * 
 * 
 * @author Juliana Goh
 */
public class LoginServlet extends HttpServlet {

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        gets the parameter value given from AJAX
        String username = request.getParameter("user");
        String password = request.getParameter("passwordUser");

        User user = new User();

        try{
//            connects with the database
            MysqlDatabaseConnector.connectDB();

//            If username and password is not empty, check users Login
            if (username!=null&&password!=null) {
                System.out.println(username + " " + password);
                
                RetrieveMysqlData rd = new RetrieveMysqlData();
                
//                Sends the data to the LoginUser method in MysqlDatabaseConnector class to check if the user already is registrated
                rd.LoginUser(username, password, user);
                
                
                if(user.getUserAccess().equals("yes")){
                    System.out.println("yaaayyy admin");
                    RequestDispatcher view = request.getRequestDispatcher("/AdminServlet");
                    view.forward(request, response);
                }
            }    
//            disconnects the database
            MysqlDatabaseConnector.disconnectDB();

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
