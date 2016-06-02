package model;

import java.util.List;
import dao.CartDAO;

public class GetCartListLogic {
    public List<Cart> execute() {
       CartDAO dao = new CartDAO();
       List<Cart> cartList = dao.findAll();
       return cartList;
   }
}
