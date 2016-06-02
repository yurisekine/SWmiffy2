/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.RegisterDAO;
import java.util.List;

/**
 *
 * @author g13953ts
 */
public class GetRegisterLogic {
    public List<User> execute() {
        RegisterDAO dao = new RegisterDAO();
        List<User> userList = dao.findAll();
        return userList;
    }
    
}
