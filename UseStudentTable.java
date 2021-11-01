
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhaval
 */
public class UseStudentTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection
        ("jdbc:derby://localhost:1527/limbachiya","dhaval","limbachiya");
        
        
        //Report whether there is a student with the employee ID of 900000000 (9 followed by all
        //0’s) in the list or not
        //we can perform a query to check if there is student exists with 900000000 sid
        String sql = "SELECT * FROM STUDENT WHERE SID ='900000000'";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        
        if(rs.next()){
            System.out.println("DB found the student with requested sid");
        } else{
            System.out.println("DB did not find student with requested sid");
            
        }
        // Report the Student ID and Names of all students who have been GPAs lower than 2.0.
        sql = "SELECT sid, NAME FROM STUDENT WHERE GPA < 2.0";
        rs= conn.createStatement().executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString("sid")+ "\t" + rs.getString("name"));
        }
        
        // Change the major of all students in major CS to Computer Science 
        sql = "UPDATE STUDENT SET MAJOR = 'Computer Science' WHERE MAJOR= 'CS'";
        int query = conn.createStatement().executeUpdate(sql);
        System.out.println("DB has updated student "  + query +" student's major");
        
        // Remove all students from the table with SIDs less than 900000000
        sql = "DELETE FROM STUDENT WHERE SID < '900000000'";
        query = conn.createStatement().executeUpdate(sql);
        System.out.println("student with sid 900000000 deleted");
        
        //finally get remainder count
        //Report the number of students left in the database
        sql = "SELECT COUNT(*) FROM STUDENT";
        rs = conn.createStatement().executeQuery(sql);
        rs.next();
        
        System.out.println("We have final number of count  " +rs.getInt(1)+" students");
  
    
    
}
}