
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Kl;
import model.KlDay;
import model.User;
import kadai7.Main;

/**
 *
 * @author g14932nk
 */
public class KlDAO {

    private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/karoTsubuDB";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";

    public List<Kl> findAll(User user) {
        Connection conn = null;
        List<Kl> klList = new ArrayList<Kl>();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String userId = user.getId();
            String sql = "SELECT ID,KL FROM AKL WHERE id = $userId";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("ID");
                int kl = rs.getInt("KL");
                Kl KL = new Kl(id, kl);
                klList.add(KL);
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
        return klList;
    }

    public boolean create(Kl kl) {
        //System.out.println(kl.getKl());
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO AKL(ID,KL) VALUES(?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            //pStmt.setString(1,Main.getloginUser().getId());
            pStmt.setString(1, kl.getId());
            pStmt.setInt(2, kl.getKl());
            
            //pStmt.setString(1, "aaa");
            //pStmt.setInt(2, 123);

            int result = pStmt.executeUpdate();

            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }catch (ClassNotFoundException e) {
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

    public boolean delete() {
        Connection conn = null;
        List<Kl> klList = new ArrayList<Kl>();
        //KlDay klDay;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            
            String sqlD = "DELETE FROM AKL WHERE ID = $loginUser.getId()";
            PreparedStatement pStmt2 = conn.prepareStatement(sqlD);

            int result = pStmt2.executeUpdate();

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
