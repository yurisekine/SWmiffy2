package model;
import java.beans.*;
import java.io.Serializable;

public class Account implements Serializable{
    private String name;
    private String userId;
    private String pass;
    private String mail;
    private String tell;
    private String address;
    
    public Account() {}
    public Account(String name, String userId, String pass, String mail, String tell,String address) {
        this.name = name;
        this.userId = userId;
        this.pass = pass;
        this.mail = mail;
        this.tell = tell;
        this.address = address;
    }
    
    public String getName() { return name; }
    public String getUserId() { return userId; }
    public String getPass() { return pass; }
    public String getMail() { return mail; }
    public String getTell() { return tell; }
    public String getAddress(){ return address;}
}
