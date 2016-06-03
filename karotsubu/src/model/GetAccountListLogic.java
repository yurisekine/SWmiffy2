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
import java.util.List;

public class GetAccountListLogic {


    public List<User> execute2(User user) {
        AccountDAO dao = new AccountDAO();
        List<User> loginUser = dao.findAccount();
        return loginUser;
    }
}
