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
import dao.AccountDAO;
public class PostAccountLogic {
    public void execute(User user) {
        AccountDAO dao = new AccountDAO();
        dao.create(user);
    }
}
