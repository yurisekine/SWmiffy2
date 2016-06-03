/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kaho
 */
public class KlDay {
    private int kl;
    private String id;
    public KlDay(){};

    public KlDay(String id,int kl) {
        this.id = id;
        this.kl = kl;
    }
    public int getKl() { return kl; }
    public String getId(){return id;}
}
