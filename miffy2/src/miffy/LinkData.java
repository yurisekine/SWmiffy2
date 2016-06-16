package miffy;

import java.net.URL;
import java.util.Date;
 
import javax.jdo.annotations.*;
 
//複数フィールドにデータを保存するクラス
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData {
	//このフィールドがプライマリキー
    @PrimaryKey
    //シリアライズ可能。直列化。
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
     
    @Persistent
    private String title;
     
    @Persistent
    private String url;
     
    @Persistent
    private String comment;
     
    @Persistent
    private Date datetime;
    
    @Persistent
    private String join;
 
    @Persistent
    private String name;
    
    @Persistent
    private String place;
    
    @Persistent
    private String time;
    
    public LinkData(String title, String url, String comment, Date datetime , String name, String place, String time/*, String join*/) {
        super();
        this.title = title;
        this.url = url;
        this.comment = comment;
        this.datetime = datetime;
        this.name = name;
        this.place = place;
        this.time = time;
        //this.join = join;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getUrl() {
        return url;
    }
 
    public void setUrl(String url) {
        this.url = url;
    }
 
    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
 
    public Date getDatetime() {
        return datetime;
    }
 
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
    public String getJoin() {
        return join;
    }
 
    public void setJoin(String join) {
        this.join = join;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) { 
    	this.name = name;
    	
    }
    
    public String getPlace() {
    	return place;
    }
    
    public void setPlace(String place){
    	this.place = place;
    }
    
    public String getTime() {
    	return time;
    }
    
    public void setTime(String time) {
    	this.time = time;
    }
    
}
