/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author g14940nm
 */
public class Kuchikomi /*implements Serializable*/ {

    private String value; // 評価
    private String text; // 口コミ内容

    public Kuchikomi() {
    }

    public Kuchikomi(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
