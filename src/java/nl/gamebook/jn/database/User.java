/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.gamebook.jn.database;

/**
 *
 * @author Juliana Goh
 */
public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String emailAdress;

    /**
     * Constructor of the class.
     * 
     * @param username
     * @param firstName
     * @param lastName
     * @param emailAdress
     */
     User(String username, String firstName, String lastName, String emailAdress) {
        this.username = username;
        this.firstName = firstName;
	this.lastName = lastName;
        this.emailAdress = emailAdress;
    }

    User() {
        this.username = username;
        this.firstName = firstName;
	this.lastName = lastName;
        this.emailAdress = emailAdress;
    }


    /**
     * Getter for username.
     * @return username
     */
    final public String getUsername() {
        return username;
    }

    /**
     * Setter for username.
     * @param username
     */
    final public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for firstname.
     * @return firstName
     */
    final public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstname.
     * @param firstName
     */
    final public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastname.
     * @return lastName
     */
    final public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastname.
     * @param lastName
     */
    final public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for emailadress.
     * @return
     */
    final public String getEmailAdress() {
        return emailAdress;
    }

    /**
     * Setter for emailadress.
     * @param emailAdress
     */
    final public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

}
