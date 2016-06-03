package servlet;

import java.net.URL;
import java.util.Date;
 
import javax.jdo.annotations.*;
 
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private int title;
     
    //@Persistent
    //private String url;
     
    @Persistent
    private String comment;
     
    //@Persistent
    //private Date datetime;
 
    public LinkData(int title, String comment) {
        super();
        //int title2 = Integer.parseInt(title);
        this.title = title;
        //this.url = url;
        this.comment = comment;
        //this.datetime = datetime;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public int getTitle() {
        return title;
    }
 
    public void setTitle(int title) {
        this.title = title;
    }
 
    /*public String getUrl() {
        return url;
    }
 
    public void setUrl(String url) {
        this.url = url;
    }*/
 
    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
 
    /*public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }*/
}
