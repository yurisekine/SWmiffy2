/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author g14940nm
 */
public class Account {
  private String pass;
  private String mail;
  private String name;

  public Account(String pass, String mail,
      String name) {
    this.pass = pass;
    this.mail = mail;
    this.name = name;
  }

    public Account() {
        //throw new UnsupportedOperationException("Not yet implemented");
    }


  public String getPass() {
    return pass;
  }

  public String getMail() {
    return mail;
  }

  public String getName() {
    return name;
  }

}
