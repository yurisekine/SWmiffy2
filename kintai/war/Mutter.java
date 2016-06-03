/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author g14944sy
 */
public class Mutter implements Serializable{
    private String name;
    private String day;
    private double time;
    public Mutter() {}
    public Mutter(String name, String day, double time) {
        this.name = name;
        this.day = day;
        this.time = time;
    }
    public String getName() { return name; }
    public String getDay() { return day; }
    public double getTime() { return time; }
}
