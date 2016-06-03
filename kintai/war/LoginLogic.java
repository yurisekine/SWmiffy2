/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccountDAO;

/**
 *
 * @author g14944sy
 */
public class LoginLogic {
    public boolean execute(Login login) {
        AccountDAO dao = new AccountDAO();
        Account account = dao.findByLogin(login);
        return account != null;
    }
}
