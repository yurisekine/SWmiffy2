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
public class Mutter {
    /*private String id;
    private String userName;
    private String text;
    private int kl;
    public Mutter(){}
    public Mutter(String id,String userName,int kl,String text){
        this.id = id;
        this.userName = userName;
        this.kl = kl;
        this.text = text;
    }
    public String getId(){return id;}
    public String getUserName(){return userName;}
    public String getText(){return text;}
    public int getUserKl(){return kl;}*/
    private String id;
    private int userkl;
    private String text;
    //public Mutter(){}
    public Mutter(String id,int kl,String text){
        this.id = id;
        this.userkl = kl;
        this.text = text;
    }
    /*public Mutter(String id,String userName,int kl,String text){
        this.id = id;
        this.userName = userName;
        //this.userkl = kl;
        this.text = text;
    }*/
    public String getId(){return id;}
    public String getText(){return text;}
    public int getUserKl(){return userkl;}
}
