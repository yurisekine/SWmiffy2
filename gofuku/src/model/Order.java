/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class Order {
	@Persistent
    private String userName;
	@Persistent
    private String clothes;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    public Order() {
    }

    public Order(Long id, String userName, String clothes) {
        this.userName = userName;
        this.clothes = clothes;
        this.id = id;
    }

    public Order(String userName, String clothes) {
        this.userName = userName;
        this.clothes = clothes;
    }

    public Order(String clothes) {
    	this.clothes = clothes;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getClothes() {
        return clothes;
    }

    public Long getId() {
        return id;
    }
}
