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
import nl.gamebook.jn.database.User;

/**
 *
 * @author juulz
 */
public class AdminServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<User> users = null; 
        
//          Makes a new object of MysqlDatabaseConnector
//        MysqlDatabaseConnector con = new MysqlDatabaseConnector();

        try {
//            connects with the database
            MysqlDatabaseConnector.connectDB();
        
       
           users = MysqlDatabaseConnector.getAllUser();
           
           MysqlDatabaseConnector.disconnectDB();
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        System.out.println(users.get(0).getFirstName());
        
        request.setAttribute("usersList", users); 
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/html/allUsers.jsp");  
        rd.forward(request, response);
        
        
    }

}
