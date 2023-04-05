package com.fixitytech.mahekart.repository;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Repository;


@Repository
public class DbConnection {
    
    
    static Connection con;
    
    static Connection getConnection() {
        
        
         try
         {
        if(con ==null)
        {
             Class.forName("com.mysql.cj.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scartdb","root","root");
        }
        
         }
         catch(Exception e)
         {
             e.printStackTrace();
             
         }
         
         return con;
    }



}

