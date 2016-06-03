/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kaho
 */
public class User {
    private String name;
    private String pass;
    private int mw;
    private String id;
    
    public User(){}
    public User(String id,String name,int mw,String pass){
        this.name = name;
        this.pass = pass;
        this.mw = mw;
        this.id = id;
    }
    public User(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
    public String getName(){return name;}
    public String getPass(){return pass;}
    public int getMw(){return mw;}
    public String getId(){return id;}
}
