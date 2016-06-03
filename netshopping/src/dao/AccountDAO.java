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
import model.User;

/**
 *
 * @author kishi
 */
public class AccountDAO {
 private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver"; //"org.h2.Driver";
  private final String JDBC_URL =
       "jdbc:derby://localhost:1527/docoTsubuDB"; // "jdbc:h2:file:C:/data/docoTsubu";
          
  private final String DB_USER = "db";
  private final String DB_PASS = "db";

   public Account findByLogin(User user) {
       
    Connection conn = null;
    Account account = null;
    try {
      // JDBCドライバを読み込む
      Class.forName(DRIVER_NAME);

      // データベースに接続
      conn = DriverManager.getConnection(
          JDBC_URL,DB_USER,DB_PASS);

      // SELECT文を準備
      String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, user.getName());
      pStmt.setString(2, user.getPass());

      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();

      // 一致したユーザーが存在した場合
      // そのユーザーを表すAccountインスタンスを生成
      if (rs.next()) {
        // 結果表からデータを取得
        String userId = rs.getString("USER_ID");
        String pass = rs.getString("PASS");
        String mail = rs.getString("MAIL");
        String name = rs.getString("NAME");
        int age = rs.getInt("AGE");

        account = new Account(userId, pass, mail, name, age);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    } finally {
      // データベースを切断
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
          return null;
        }
      }
    }
    // 見つかったユーザーまたはnullを返す
    return account;
  }  

    public boolean addUser(Account account) {       
    Connection conn = null;
    int result = 1;
    
    try {
      // JDBCドライバを読み込む
      Class.forName(DRIVER_NAME);

      // データベースに接続
      conn = DriverManager.getConnection(
          JDBC_URL,DB_USER,DB_PASS);
     // INSERT文の準備(idは自動連番なので指定しなくてよい）
      String sql = "INSERT INTO ACCOUNT(USER_ID, PASS, MAIL,NAME,AGE) VALUES(?, ?,?,?,?)";
      // SELECT文を準備
      // String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, account.getUserId());
      pStmt.setString(2, account.getPass());
      pStmt.setString(3, account.getMail());
      pStmt.setString(4, account.getName());
      pStmt.setInt(5, account.getAge());
   
      result = pStmt.executeUpdate();
     
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      // データベースを切断
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    // 登録の成功、不成功を返す
    if (result == 1) {
         return true;
      }else{
          return false;
      }
     
    }
}
