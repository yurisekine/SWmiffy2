package model;

import dao.AccountDAO;

public class PostAccountLogic {
    public void execute(Account account) {
        AccountDAO dao = new AccountDAO();
        dao.create(account);
    }
}
