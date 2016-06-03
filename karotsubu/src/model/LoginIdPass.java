/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author g14932nk
 */
public class LoginIdPass {

    private String userId;
    private String pass;

    public LoginIdPass(String userId, String pass) {
        this.userId = userId;
        this.pass = pass;
    }

    public String getUserId() {
        return userId;
    }

    public String getPass() {
        return pass;
    }
}
