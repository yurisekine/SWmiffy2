/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccountDAO;

/**
 *
 * @author g14932nk
 */
public class LoginLogic {
    public boolean execute(LoginIdPass LIP) {
        AccountDAO dao = new AccountDAO();
        User user = dao.findByLogin(LIP);
        System.out.println("◆◆◆"+user.getId());
        return user != null;
    }
}
