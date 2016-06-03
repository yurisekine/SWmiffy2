/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.ArrayList;
import java.util.List;
import model.LoginIdPass;
import model.User;
import kadai7.Login;

/**
 *
 * @author g14932nk
 */
public class AccountDAO {

    private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/karoTsubuDB";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";

    public User findByLogin(LoginIdPass loginIdPass) {
        Connection conn = null;
        User user = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(JDBC_URL, "db", "db");
            
            //conn = DriverManager.getConnection("jdbc:derby://localhost:1527/docoTsubuDB","db","db");
            
            //String userId = loginIdPass.getUserId();
            //String userPass = loginIdPass.getPass();
            String sql = "SELECT ID,PASS FROM USERS WHERE ID = ? AND PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,loginIdPass.getUserId());
            pStmt.setString(2,loginIdPass.getPass());
            
            ResultSet rs = pStmt.executeQuery();
            
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

            //System.out.println(rs.getString("ID"));
            if (rs.next()) {
                String id = rs.getString("ID");
                String pass = rs.getString("PASS");
                
                user = new User(id,pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return user;
    }

    public List<User> findAccount() {
        Connection conn = null;
        List<User> accountList3 = new ArrayList<User>();
        try {
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql = "SELECT ID, NAME, MW, PASS FROM USERS";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("NAME");
                int mw = rs.getInt("MW");
                String pass = rs.getString("PASS");
                User user = new User(id, name, mw, pass);
                accountList3.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return accountList3;
    }

    public boolean create(User user) {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO USERS(ID,PASS) VALUES(?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, user.getId());
            pStmt.setString(2, user.getPass());

            int result = pStmt.executeUpdate();
            System.out.println("◆" + result);
            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
