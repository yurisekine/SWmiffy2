package model;

import dao.CartDAO;

public class PostCartLogic {
    public void execute(Cart cart) {  //引数を1つに変更
        CartDAO dao = new CartDAO();
        dao.create(cart);
    }
}
