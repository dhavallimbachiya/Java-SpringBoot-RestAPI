
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * To change this license hea der, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhaval
 */
public class CreateStudentTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        try {
            //Setting up Database Connection and connect with username and password
            Connection conn = DriverManager.getConnection (
            "jdbc:derby://localhost:1527/limbachiya","dhaval","limbachiya");
       
        //droping table
        try { 
            String data = "DROP TABLE STUDENT";
            conn.createStatement().execute(data);
        } catch (Exception e){
            System.out.println(e);
        }
        try {
            //create a table
            String sql = "CREATE TABLE STUDENT (";
            sql = sql + "sid VARCHAR(50) PRIMARY KEY,";//SID- Student ID
            sql = sql + "name VARCHAR(50),";
            sql = sql + "major VARCHAR(50),";
            sql = sql + "gpa DOUBLE";
            sql = sql +")";
        
        //execute query to create     
        conn.createStatement().execute(sql);
        
        } catch (SQLException e) {
            
        }
        } catch (Exception e){
            System.out.println(e);
            
        }
        
        
        
    }
    }

