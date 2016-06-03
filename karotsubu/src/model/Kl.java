/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author kaho
 */
public class Kl extends HttpServlet {
    private int kl;
    private String id;
    public Kl(){};

    public Kl(String id,int kl) {
        this.id = id;
        this.kl = kl;
    }
    public int getKl() { return kl; }
    public String getId(){return id;}
}
