/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.RegisterDAO;

/**
 *
 * @author g13953ts
 */
public class RegisterUserLogic {
     public void execute(User user) {
            RegisterDAO dao = new RegisterDAO();  
           dao.create(user);
    }
}
