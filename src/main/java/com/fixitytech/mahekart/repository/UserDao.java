package com.fixitytech.mahekart.repository;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.fixitytech.mahekart.User;



@Repository
public class UserDao {
    
    public boolean  save(User user)
    {
        
        try
        {
        Connection con=DbConnection.getConnection();
        
         PreparedStatement ps=con.prepareStatement("insert into  users values(?,?,?,?,?)");
         
         ps.setString(1, user.getUname());
         ps.setString(2, user.getUpassword());
         ps.setString(3, user.getFullname());
         ps.setString(4, user.getMobilenumber());
         ps.setString(5, user.getEmail());
         int n=ps.executeUpdate();
         
         if(n>0)
         return true;
         else
             return false;
         
        }
         catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return false;
    }



   public int validate(String uname,String upassword)
    {
	   int n=0;
        try
        {
        Connection con=DbConnection.getConnection();
        
         PreparedStatement ps=con.prepareStatement("select * from users where username=? and password=?");
         
         ps.setString(1, uname);
         ps.setString(2, upassword);
        
         ResultSet rs=ps.executeQuery();
         if(rs.next())
         {
        	  User user=new User();
        	 user.setUname(rs.getString(1));
        	 user.setUpassword(rs.getString(2));
        	 user.setFullname(rs.getString(3));
        	 user.setMobilenumber(rs.getString(4));
        	 
             user.setEmail(rs.getString(5));
            n=1;
            
         }
         
         
         
        }
         catch(Exception e)
        {
            e.printStackTrace();
            
        }
        
    return n;
    }
   
   public User getUser(String userid)
   {
       try
       {
       Connection con=DbConnection.getConnection();
       
        PreparedStatement ps=con.prepareStatement("select * from users where username=?");
        
        ps.setString(1, userid);
        
       
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
       	 User user=new User();
       	 user.setUname(rs.getString(1));
       	 user.setUpassword(rs.getString(2));
       	 user.setFullname(rs.getString(3));
       	 user.setMobilenumber(rs.getString(4));
       	 
            user.setEmail(rs.getString(5));
            return user;
        }
        
        
        
       }
        catch(Exception e)
       {
           e.printStackTrace();
           
       }
       
   return null;
   }
  
   
   
   public boolean  update(User user)
   {
       
       try
       {
       Connection con=DbConnection.getConnection();
       //String fullname=user.getFullname();
       
        PreparedStatement ps=con.prepareStatement("update users set fullname =?, mobilenumber=?,email=?  where username=?");
        ps.setString(1,user.getFullname());
        ps.setString(2,user.getMobilenumber());
        ps.setString(3,user.getEmail());
        ps.setString(4, user.getUname());
       
        int n=ps.executeUpdate();
        
        if(n>0)
        return true;
        else
            return false;
        
       }
        catch(Exception e)
       {
           e.printStackTrace();
           
       }
       return false;
   }  
}