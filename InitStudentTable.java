
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhaval
 */
public class InitStudentTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection
        ("jdbc:derby://localhost:1527/limbachiya","dhaval","limbachiya");
        //array of 10 random names and majors
        String[] firstName = {"Dhaval","Mike","Abolaji","Malik","Sunny","Mikel","Marty","David","Mark","Jeff"};
        String[] lastName = {"Johnson","Limbachiya","Wolpert","Langmore","Byrde","Garcia","Bezos","Jobs","Cruz","Ricci"};
        String[] majors = {"CS","Chemistry","MBA","MS","IT","Finance","LAW","Arts","Math","Biology"};
        
        Random random = new Random();
        int count = 0;
        
        while (count<5000){
            //get random sid
            int sid = 100000000 + random.nextInt(899999999);
           //getting random name and major out of the list
            String name = lastName[random.nextInt(lastName.length)]+"," + firstName[random.nextInt(firstName.length)];
            String major = majors[random.nextInt(majors.length)];
            //assigning random double gpa
            double gpa = random.nextDouble() *4;
            
            //put all data together
            String sql = "INSERT INTO student VALUES('" + sid + "','"
                    + name + "','" + major + "'," + gpa + ")";
                 System.out.println(sql);
            
            try{
                //execute the query
                conn.createStatement().execute(sql);
                count++;
                
                
            } catch (Exception e){
                System.out.println(e);
            }
            
        }
            
        }
    
                    
}
