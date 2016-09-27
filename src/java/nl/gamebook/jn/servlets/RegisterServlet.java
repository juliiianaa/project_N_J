/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.gamebook.jn.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.gamebook.jn.database.MysqlDatabaseConnector;
import nl.gamebook.jn.database.UpdateMysqlTable;
import nl.gamebook.jn.database.User;

public class RegisterServlet extends HttpServlet {

    
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
        String name = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");        
        String password = request.getParameter("password");

            
        System.out.println(username + " " + name + " " + lastName + " " + email + " " + password);
        
        try{
//            connects with the database
            MysqlDatabaseConnector.connectDB();
            
            UpdateMysqlTable ut = new UpdateMysqlTable();
            
            ut.RegisterUser(username, name, lastName, email, password);
//                       }       
//            disconnects the database
            MysqlDatabaseConnector.disconnectDB();

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
