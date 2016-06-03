package model;


import java.net.URL;
import java.util.Date;
 
import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)


public class LinkData {
	  @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Long id;
	     
	    @Persistent
	    private String name;
	     
	    @Persistent
	    private String mail;
	     
	    @Persistent
	    private String reserveDate;
	 
	    public LinkData(String name, String mail, String reserveDate) {
	        super();
	        //this.id = id;
	        this.name = name;
	        this.mail = mail;
	        this.reserveDate = reserveDate;
	    }
	 
	    public Long getId() {
	        return id;
	    }
	 
	    public void setId(Long id) {
	        this.id = id;
	    }
	 
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public String getMail() {
	        return mail;
	    }
	    
	    public void setMail(String mail) {
	        this.mail = mail;
	    }

	 
	    public String getreserveDate() {
	        return reserveDate;
	    }
	 
	    public void setreserveDate(String reserveDate) {
	        this.reserveDate = reserveDate;
	    }
}
