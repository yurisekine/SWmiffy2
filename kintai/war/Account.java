/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author g14944sy
 */
public class Account {
    private String name;
    private String userId;
    private String pass;
    private int salary;

    public Account(String name, String userId, String pass, int salary) {
        this.userId = userId;
        this.pass = pass;
        this.name = name;
        this.salary = salary;
    }
    
    public String getUserId() { return userId; }
    public String getPass() { return pass; }
    public String getName() { return name; }
    public int getSalary() { return salary; }
}
