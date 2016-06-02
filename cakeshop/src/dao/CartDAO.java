package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cart;

public class CartDAO {
    private final String DRIVER_NAME="org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL =
            "jdbc:derby://localhost:1527/db5859";
    private final String DB_USER ="db";
    private final String DB_PASS ="db";
    
    public List<Cart> findAll(){
        Connection conn = null;
        List<Cart> cartList = new ArrayList<Cart>();
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/db5859";
            conn = DriverManager.getConnection(driverURL, "db", "db");
            
            //SELECT文の準備
            String sql =
                    "SELECT CAKE_NAME NUMBER FROM CAKE ORDER BY ID DESC";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            //SELECを実行
            ResultSet rs = pStmt.executeQuery();
            
            //SELECT文の結果をArrayListに格納
            while(rs.next()){
                String cakeName = rs.getString("CAKE_NAME");
                String number =rs.getString("NUMBER");
                Cart cart = new Cart(cakeName,number);
                cartList.add(cart);
            } 
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        } catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        } finally {
            //データベース切断
            if(conn != null){
                try{
                    conn.close();
                } catch(SQLException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return cartList;
    }
    
    public boolean create(Cart cart){
        Connection conn=null;
        try{
            //データベースへ接続
            String driverURL = "jdbc:derby://localhost:1527/db5859";
            conn = DriverManager.getConnection(driverURL, "db", "db");
            
            //INSERT文の準備(idは自動連番なので指定しなくてよい)
            String sql ="INSERT INTO CART(CAKE_NAME,NUMBER) VALUES(?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            //INSERT文中の「？」に使用する値を設定しSQLを完成
            pStmt.setString(1,cart.getCakeName());
            pStmt.setString(2,cart.getNumber());
            
            //INSERT文を実行
            int result = pStmt.executeUpdate();
            
            if(result != 1){
                return false;
            }
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        } finally {
            
            //データベース切断
            if(conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
