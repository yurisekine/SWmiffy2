package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Account;

public class AccountDAO {
    
    private final String DRIVER_NAME="org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL =
            "jdbc:derby://localhost:1527/db5859";
    private final String DB_USER ="db";
    private final String DB_PASS ="db";
    
    public List<Account> findAll(){
        Connection conn = null;
        List<Account> accountList = new ArrayList<Account>();
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/db5859";
            conn = DriverManager.getConnection(driverURL, "db", "db");
            
            //SELECT文の準備
            String sql =
                    "SELECT NAME USER_ID PASS MAIL TELL ADDRESS FROM ACCOUNT ORDER BY ID DESC";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            //SELECを実行
            ResultSet rs = pStmt.executeQuery();
            
            //SELECT文の結果をArrayListに格納
            while(rs.next()){
                String name = rs.getString("NAME");
                String userId =rs.getString("USER_ID");
                String pass = rs.getString("PASS");
                String mail = rs.getString("MAIL");
                String tell = rs.getString("TELL");
                String address = rs.getString("ADDRESS");
                Account account = new Account(name,userId,pass,mail,tell,address);
                accountList.add(account);
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
        return accountList;
        }
    
    public boolean create(Account account){
        Connection conn=null;
        try{
            //データベースへ接続
            String driverURL = "jdbc:derby://localhost:1527/db5859";
            conn = DriverManager.getConnection(driverURL, "db", "db");
            
            //INSERT文の準備(idは自動連番なので指定しなくてよい)
            String sql ="INSERT INTO ACCOUNT(NAME,USER_ID,PASS,MAIL,TELL,ADDRESS) VALUES(?,?,?,?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            //INSERT文中の「？」に使用する値を設定しSQLを完成
            pStmt.setString(1,account.getName());
            pStmt.setString(2,account.getUserId());
            pStmt.setString(3,account.getPass());
            pStmt.setString(4,account.getMail());
            pStmt.setString(5,account.getTell());
            pStmt.setString(6,account.getAddress());
            
            
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
