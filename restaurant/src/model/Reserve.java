/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author g14940nm
 */
public class Reserve {

    private String date; // 日付
    private String name;//名前
    private String mail; // メアド

    public Reserve() {
    }

    public Reserve(String mail, String date, String name) {
        this.mail = mail;
        this.date = date;
        this.name = name;
    }

    public Reserve(String mail, String date) {
        this.mail = mail;
        this.date = date;
    }

    public String getMail() {
        return mail;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
