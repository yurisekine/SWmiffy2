/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AccountDAO;
import model.User;

/**
 *
 * @author g14931mh
 */
public class LoginLogic {
    
    
    public boolean execute(User user){
        AccountDAO dao = new AccountDAO();
          Account account = dao.findByLogin(user);
          return account != null;
    }
}