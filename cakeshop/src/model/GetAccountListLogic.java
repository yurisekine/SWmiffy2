package model;

import java.util.List;
import dao.AccountDAO;

public class GetAccountListLogic {
    public List<Account> execute() {
        AccountDAO dao = new AccountDAO();
        List<Account> accountList = dao.findAll();
        return accountList;
    }
}