/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.gamebook.jn.database;

import java.io.IOException;
import java.sql.*;

/**
 *
 * Class which is used for anything that has to do with the database
 * Make connection, retrieve data from the database, disconnects the database when needed
 * 
 * @author Juliana Goh
 */
public class MysqlDatabaseConnector {
    
    private final static String USERDB = "root";
    private final static String USERPW = "java2016" ;
    private static Connection con;
    
    /**
     *
     * connectDB, makes a connection with the database with the help of the url, user and password
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void connectDB()throws SQLException, ClassNotFoundException, InstantiationException,IllegalAccessException {
        String url="jdbc:mysql://localhost:3306/test";
        
        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        con = DriverManager.getConnection(url,USERDB, USERPW);
        
        if(con==null)   {
            System.out.println("connection failed");
        }
        
    }
     
    /**
     *
     * disconnectDB, stops the connection of the database
     * 
     * @throws IOException
     */
    public void disconnectDB() throws IOException {
        try {
	    //close the connection
            con.close();
        } catch (SQLException ex) {
            
            System.out.println("SQL EXCEPTION message: " + ex);
        }
    }

    /**
     *
     * LoginUser, checks if the user is valid or not with the given username and password
     * 
     * @param username
     * @param password
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public User LoginUser(String username, String password) throws IOException, SQLException {

        //SQL query for retrieving data from "users_information" table to log in user
        String sqlStatement = "SELECT * FROM users_information WHERE username=? AND password=md5(?)";

        //Maka a prepared statement with query and fill in placeholders
        PreparedStatement ps = con.prepareStatement(sqlStatement);
        //username is placed in the first ?
        ps.setString(1, username);
        //password is placed in the 2nd ? and hashed with md5
        ps.setString(2, password);

//        executes the query
        ResultSet rs = ps.executeQuery();

//        if no data is found
        if (!rs.next() ) {
            System.out.println("no data");
        }else{
                
                
                String userDB = rs.getString("username");
                String firstName= rs.getString("name");
                String uPasswordDB = rs.getString("password");
                String ln = rs.getString("lastName"); 
                String email = rs.getString("email");
                
                System.out.println("user found" + " username: " + userDB + " lastname: " + ln + " email: " + email);
                
                
        }
       
        return null;
                
    }
    
}
