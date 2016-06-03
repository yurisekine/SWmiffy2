package com.sekine.pairpro;

//import java.net.URL;
import java.util.Date;
 
import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Data {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    
    @Persistent
    private String day;
     
    @Persistent
    private double time;
 
    public Data(String day, double time) {
        super();
        this.day = day;
        this.time = time;
    }
    
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getDay() {
    	return day;
    }
    
    public void setDay() {
    	this.day = day;
    }
    
    public double getTime() {
    	return time;
    }
    
    public void setTime() {
    	this.time = time;
    }
 
}
