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
import model.Login;
import model.Mutter;

/**
 *
 * @author g14944sy
 */
public class MutterDAO {
    public List<Mutter> findAll() {
        Connection conn = null;
        List<Mutter> mutterList = new ArrayList<Mutter>(); 
        try {
            //JDBCドライバを読み込む
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //データベースの接続
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "db", "db");
            //SELECT文を準備
            String sql = "SELECT NAME, DAY, TIME FROM TIME ";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            //SELECT文を実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();
            
            //SELECT文の結果をArrayListに格納
            while(rs.next()) {
                String name = rs.getString("NAME");
                String day = rs.getString("DAY");
                double time = rs.getDouble("TIME");
                Mutter mutter = new Mutter(name, day, time);
                mutterList.add(mutter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }finally{
        //データベース切断
            if(conn != null) {
                try {
                    conn.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return mutterList;
    }

    public boolean create(Mutter mutter) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "db", "db");

            String sql = "INSERT INTO TIME(NAME, DAY, TIME) VALUES(?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, mutter.getName());
            pStmt.setString(2, mutter.getDay());
            pStmt.setDouble(3, mutter.getTime());
            
            int result = pStmt.executeUpdate();
            
            if(result != 1) {
                return false;
            }
        }catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //データベース切断
            if(conn != null) {
                try {
                    conn.close();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }        
}
