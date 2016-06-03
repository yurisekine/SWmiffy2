package model;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author g14944sy
 */
public class Login implements Serializable{
    private String name;
    private String userId;
    private String pass;
    public Login() {}
    public Login(String name, String userId, String pass) {
        this.name = name;
        this.userId = userId;
        this.pass = pass;
    }
    public String getName() { return name; }
    public String getUserId() { return userId; }
    public String getPass() { return pass; }
}
