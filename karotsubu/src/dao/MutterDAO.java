package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mutter;

/**
 *
 * @author g14932nk
 */
public class MutterDAO {
    private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
    private final String JDBC_URL ="jdbc:derby://localhost:1527/karoTsubuDB";
    private final String DB_USER = "db";
    private final String DB_PASS = "db";
    
    public List<Mutter> findAll(){
        Connection conn = null;
        System.out.println("******MuuterDAO findAll");
        List<Mutter> mutterList = new ArrayList<Mutter>();
        try{
            //Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            String sql = "SELECT ID,TEXT,KL FROM MUTTER ORDER BY NUM DESC";
            //ORDER BY ID DESC
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            ResultSet rs = pStmt.executeQuery();
            
            while(rs.next()){
                String id = rs.getString("ID");
                int kl = rs.getInt("KL");
                String text = rs.getString("TEXT");
                Mutter mutter = new Mutter(id,kl,text);
                mutterList.add(mutter);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
/*        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }*/}finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return mutterList;
    }
    public boolean create(Mutter mutter){
        System.out.println("■create");
        Connection conn = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
            
            String sql = "INSERT INTO MUTTER(ID,KL,TEXT) VALUES(?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            pStmt.setString(1,mutter.getId());
            pStmt.setInt(2,mutter.getUserKl());
            pStmt.setString(3,mutter.getText());
            
            System.err.println("mutterDAO 1");
            
            /*pStmt.setString(1, "aaa");
            pStmt.setString(2, "aaa");
            pStmt.setInt(3,1234);
            pStmt.setString(4, "aaa");*/
            
            int result = pStmt.executeUpdate();
             System.err.println("mutterDAO 2");        
            if(result != 1){
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
                 System.err.println("mutterDAO 3");
        return true;
    }
}
