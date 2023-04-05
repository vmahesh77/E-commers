package com.fixitytech.mahekart.repository;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.fixitytech.mahekart.Item;

@Repository
public class ItemDao {
	
	 public boolean  save(Item item)
	    {
	        
	        try
	        {
	        	 Connection con=DbConnection.getConnection();
	        
	         PreparedStatement ps=con.prepareStatement("insert into  items(id,name,price) values(?,?,?)");
	         
	         ps.setInt(1, item.getId());
	         ps.setString(2, item.getName());
	         ps.setDouble(3, item.getPrice());
	        
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





	  public List<Item> getItems()
	    {
	        
	        List<Item> items=new Vector<Item>();
	        try
	        {
	     
	        Connection con=DbConnection.getConnection();
	        
	         PreparedStatement ps=con.prepareStatement("select * from items");
	         
	        
	        
	         ResultSet rs=ps.executeQuery();
	         
	         while(rs.next())
	         {
	             Item it=new Item();
	             it.setId(rs.getInt(1));
	             it.setName(rs.getString(2));
	             it.setPrice(rs.getDouble(3));
	             /*Blob blob=rs.getBlob(4);
	             InputStream inputStream = blob.getBinaryStream();
	             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	             byte[] buffer = new byte[4096];
	             int bytesRead = -1;
	             
	             while ((bytesRead = inputStream.read(buffer)) != -1) {
	                 outputStream.write(buffer, 0, bytesRead);                  
	             }
	              
	             byte[] imageBytes = outputStream.toByteArray();
	             String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	              
	              
	             inputStream.close();
	             
	             outputStream.close();
	             */
	             it.setImage(null);
	             
	             
	             items.add(it);
	             
	             
	             
	             
	             
	             
	         }
	         
	        }
	         catch(Exception e)
	        {
	            e.printStackTrace();
	            
	        }
	        
	    return items;
	    }
	    
	public Item getItem(int id)
	{
	    
	    try
	    {
	    	 Connection con=DbConnection.getConnection();
	    
	     PreparedStatement ps=con.prepareStatement("select * from items where id=?");
	     
	    ps.setInt(1,id);
	    
	     ResultSet rs=ps.executeQuery();
	     
	     if(rs.next())
	     {
	         Item it=new Item();
	         it.setId(rs.getInt(1));
	         it.setName(rs.getString(2));
	         it.setPrice(rs.getDouble(3));
	         
	         return it;
	     }
	     
	    }
	     catch(Exception e)
	    {
	        e.printStackTrace();
	        
	    }
	    
	return null;
	}






	public Item getItem(String name)
	{
	    
	    try
	    {
	 
	    Connection con=DbConnection.getConnection();
	    
	     PreparedStatement ps=con.prepareStatement("select * from items where name=?");
	     
	    ps.setString(1,name);
	    
	     ResultSet rs=ps.executeQuery();
	     
	     if(rs.next())
	     {
	         Item it=new Item();
	         it.setId(rs.getInt(1));
	         it.setName(rs.getString(2));
	         it.setPrice(rs.getDouble(3));
	         
	         return it;
	     }
	     
	    }
	     catch(Exception e)
	    {
	        e.printStackTrace();
	        
	    }
	    
	return null;
	}
}