package model;
import java.beans.*;
import java.io.Serializable;

public class Cart implements Serializable{
    private String cakeName;  //ケーキ名
    private String number;//個数
    
    //public Cart() {}
    public Cart(String cakeName,String number) {
        this.cakeName = cakeName;
        this.number = number;
    }
    
    public String getCakeName() { return cakeName;}
    public String getNumber() { return number; }
}
