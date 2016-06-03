/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.Login;

/**
 *
 * @author g14944sy
 */
public class AccountDAO {
    private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/register";
    
    private final String DB_USER = "db";
    private final String DB_PASS = "db";
    
    public Account findByLogin(Login login) {
        Connection conn1 = null;
        Account account = null;
        try {
            //JDBCドライバを読み込む
            Class.forName(DRIVER_NAME);
                
            //データベースの接続
            conn1 = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            //SELECT文を準備
            String sql = "SELECT NAME, ID, PASS, SALARY FROM REGISTER WHERE ID = ? AND PASS = ?";
            PreparedStatement pStmt = conn1.prepareStatement(sql);
            pStmt.setString(1, login.getUserId());
            pStmt.setString(2, login.getPass());
            
            //SELECT文を実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();
            
            //一致したユーザーが存在した場合
            //そのユーザーを表すAccountインスタンスを生成
            if(rs.next()) {
                //結果表からデータを取得
                String userId = rs.getString("ID");
                String pass = rs.getString("PASS");
                String name = rs.getString("NAME");
                int salary = rs.getInt("SALARY");
                
                account = new Account(name, userId, pass, salary);
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            //データベースを切断
            if (conn1 != null) {
                try {
                    conn1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }                      
        }

        //見つかったユーザーまたはnullを返す   
        return account;
    }
    
    public boolean addUser(Account account) {
        Connection conn1 = null;
        int result = 1;

        try {
            Class.forName(DRIVER_NAME);
            conn1 = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            String sql = "INSERT INTO REGISTER(NAME, ID, PASS, SALARY) VALUES(?,?,?,?)";
            PreparedStatement pStmt = conn1.prepareStatement(sql);
            pStmt.setString(1, account.getName());
            pStmt.setString(2, account.getUserId());
            pStmt.setString(3, account.getPass());
            pStmt.setInt(4, account.getSalary());

            result = pStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //データベースを切断
            if (conn1 != null) {
                try {
                    conn1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //登録の成功、失敗を返す
        if (result == 1) {
            return true;
        } else {
            return true;
        }


    }
}
