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
public class AccountLogic {
    public boolean addUser(Account account) {
        AccountDAO dao = new AccountDAO();
        boolean rc = dao.addUser(account);
        return rc;
    }

}
