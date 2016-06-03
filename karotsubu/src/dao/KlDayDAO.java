/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import model.Kl;
import model.KlDay;

/**
 *
 * @author kaho
 */
public class KlDayDAO {
    private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL = "jdbc:derby://localhost:1527/karoTsubuDB";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";


    public boolean create(KlDay klDay) {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO AKL(ID,KL) VALUES(?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            //pStmt.setString(1,Main.getloginUser().getId());
            pStmt.setString(1, klDay.getId());
            pStmt.setInt(2, klDay.getKl());

            int result = pStmt.executeUpdate();

            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }  catch (ClassNotFoundException e) {
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
