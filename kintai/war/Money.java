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
public class Money implements Serializable{
    private double allMoney; 
    public Money() {} 
    public Money(double allMoney) {
        this.allMoney = allMoney;
    }
    public double getAllMoney() { return allMoney; }
}
