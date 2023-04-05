package com.fixitytech.mahekart.repository;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;
@Repository
public class AdminDao {
	
	
	
	public int uploadData(String id,String name,String image,String price)
	   {
		   int n=0;
	       try
	       {
	       Connection con=DbConnection.getConnection();
	       
	        PreparedStatement ps=con.prepareStatement("insert into admin values(?,?,?,?)");
	       
	        
	        InputStream in = new FileInputStream("image");
	        ps.setString(1,id);
	        ps.setString(2,name);
	       
	        ps.setString(3,price);
	        ps.setBlob(4,in);
	       
	        int n1=ps.executeUpdate();
	        if(n1>0)
	        	n=1;
	        
	        
	       }
	        catch(Exception e)
	       {
	           e.printStackTrace();
	           
	       }
	       
	   return n;
	   }
	  
	   

}
