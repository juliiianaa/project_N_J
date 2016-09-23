/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.gamebook.jn.database;

import java.io.IOException;

/**
 *
 * @author Juliana Goh
 */
public interface UserDAO {
    
     /**
     * Connects to the database.
     * @param dbUrl String
     * @param dbUser String
     * @param dbPass String
     * @throws IOException ex
     */
    void connect(String dbUrl, String dbUser, String dbPass) throws IOException;

    /**
     * Logs in an user.
     * @param username String
     * @param password String
     * @return User
     * @throws IOException e
     */
    UserDAO loginUser(String username, String password) throws IOException;

    /**
     * Registers a new user.
     * @param username String
     * @param firstName String
     * @param lastName String
     * @param emailAdress String
     * @param password String
     * @return User
     * @throws IOException e
     */
    UserDAO registerUser(String username,
            String firstName,
            String lastName,
            String emailAdress,
            String password) throws IOException;

    /**
     * Disconnects from the database.
     * @throws IOException ex
     */
    void disconnect() throws IOException;

    /**
     * Checks if an username already exists in the database.
     * @param username String
     * @return boolean userExists
     * @throws IOException ex
     */
    boolean checkUsername(String username) throws IOException;

    /**
     * Checks if an emailadress already exists in the database.
     * @param email String
     * @return boolean emailExists
     * @throws IOException ex
     */
    boolean checkEmail(String email) throws IOException;
    
}
