/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author g13953ts
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User implements Serializable {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String userId;
    @Persistent
    private String pass;
    @Persistent
    private String mail;
    @Persistent
    private String name;
        
    public User() {
    }

    public User(String userId, String pass, String mail, String name) {
        this.userId = userId;
        this.pass = pass;
        this.mail = mail;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPass() {
        return pass;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }
}

