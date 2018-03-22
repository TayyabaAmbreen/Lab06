/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;

public class JDBC {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   Statement stmt0 = null;
   Statement stmt1 = null;
   Statement stmt2 = null;
   Statement stmt3 = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/University", USER, PASS);

      //STEP 4: Execute a query
      stmt = conn.createStatement();
    
      ResultSet rs=stmt.executeQuery("select * from Student");  
      System.out.println("ID   Name   Reg#   Class   Sec   Contact    Address");
      while(rs.next())  
      System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getString(7)); 
      
      System.out.println("Enter 1 for delete by name and 2 for delete by registration No.");     
      Scanner in =new Scanner(System.in);
        int var = in.nextInt();
        
        if(var==1)
        {
            System.out.println( "Enter name: ");
            Scanner input =new Scanner(System.in);
            String n = input.next();
             
            String sql = "delete from student where name='"+n+"'";
            
            stmt0 = conn.createStatement();
            stmt0.executeUpdate(sql);
            System.out.println("Data deleted sucessfully");
            
        }
        
        if(var==2)
        {
            System.out.println( "Enter registration no.: ");
            Scanner input =new Scanner(System.in);
            String n = input.next();
             
            String sql = "delete from student where RegNo="+n;
            
            stmt1 = conn.createStatement();
            stmt1 = conn.createStatement();
            stmt1.executeUpdate(sql);
            System.out.println("Data deleted sucessfully");         
        }
        
        System.out.println("Enter 1 for search by name and 2 for search by registration No.");     
        int vr = in.nextInt();
        
        if(vr==1)
        {
            System.out.println( "Enter name: ");
            Scanner input =new Scanner(System.in);
            String n = input.next();
            
            stmt2 = conn.createStatement();
          
            rs=stmt2.executeQuery("select * from student where name='"+n+"'");
            if(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getString(7)); 
            
        }
        
        if(vr==2)
        {
            System.out.println( "Enter registration no.: ");
            Scanner input =new Scanner(System.in);
            String n = input.next();
           
            stmt3 = conn.createStatement();
         
            rs=stmt3.executeQuery("select * from student where RegNo="+n);
            if(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getString(7)); 
         
        }
      
      
   }
   catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample