/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author g14931mh
 */
public class User implements Serializable {
    private String name;
    private String pass;
    
    public User(){}
    public User(String name, String pass){
        this.name = name;
        this.pass = pass;
    }
    public String getName() {return name;}
    public String getPass(){return pass;}
    
    
}
