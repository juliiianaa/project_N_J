/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.gamebook.jn.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author juulz
 */
public class RetrieveMysqlData extends MysqlDatabaseConnector{
    
     /**
     *
     * LoginUser, checks if the user is valid or not with the given username and password
     * 
     * @param username
     * @param password
     * @param u
     * @throws IOException
     * @throws SQLException
     */
    public void LoginUser(String username, String password, User u) throws IOException, SQLException {

        //SQL query for retrieving data from "users_information" table to log in user
        String sqlStatement = "SELECT * FROM users_information WHERE username=? AND password=md5(?)";
        
//        System.out.println(username + "," + password);
        
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
                
            u.setUsername(rs.getString("username"));
            u.setFirstName(rs.getString("name"));
            u.setLastName(rs.getString("lastName"));
            u.setEmailAdress(rs.getString("email"));
            u.setUserAccess(rs.getString("userAccess"));
                
        }
       
    }
    
        
        
    public static List<User> getAllUser() throws SQLException{
        
        //SQL query for retrieving data from "users_information" table to log in user
        String sqlStatement = "SELECT * FROM users_information";
        Statement stm=(Statement) con.createStatement();
//        executes the query
        ResultSet rs = stm.executeQuery(sqlStatement);
        
        List<User> list = new ArrayList<>();

        while (rs.next()) {
            User u = new User();
           
            u.setUsername(rs.getString("username"));
            u.setFirstName(rs.getString("name"));
            u.setLastName(rs.getString("lastName"));
            u.setEmailAdress(rs.getString("email"));
            u.setUserAccess(rs.getString("userAccess"));
            
            list.add(u);
            
        }
        
        return list;
      
    }
    
}
