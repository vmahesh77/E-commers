package com.fixitytech.mahekart.repository;






import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.fixitytech.mahekart.Order;
import com.fixitytech.mahekart.OrderItem;






@Repository
public class OrderDao {
    
    
    public  int addOrder(Order o)
    {
        int n=0;
        try
        {
            
        Connection c=DbConnection.getConnection();
        
        
        c.setAutoCommit(false);
        PreparedStatement pt=c.prepareStatement("insert into orderstable(bill,userID) values(?,?)",Statement.RETURN_GENERATED_KEYS);
        
        pt.setDouble(1,o.getBill());
        pt.setString(2,o.getUserId());
        int n1=pt.executeUpdate();
    if(n1>0)
    {
        
        ResultSet rs=pt.getGeneratedKeys();
        rs.next();
        int oId=rs.getInt(1);
        PreparedStatement ps=c.prepareStatement("insert into orderItems(itId,itName,itPrice,quantity,subAmount,orderId) values(?,?,?,?,?,?)");
        for(OrderItem orderItem:o.getOrderItems())
        {
            ps.setInt(1,orderItem.getId());
            ps.setString(2,orderItem.getName());
            ps.setDouble(3,orderItem.getPrice());
            ps.setInt(4,orderItem.getQuantity());
            ps.setDouble(5, orderItem.getAmount());
            ps.setInt(6,oId);
            ps.executeUpdate();
        }
        c.commit();
        
         
    return oId;
    }
        
     c.rollback();
     n=-1;
        }
        catch(Exception e)
        {
            e.printStackTrace();





       }
        return n;
    }
    
public List<Order> viewOrders(String uid)
    {
     List<Order> order=new Vector<Order>();
     try
     {
        Connection c=DbConnection.getConnection();
    PreparedStatement pt=c.prepareStatement("select * from orderstable where UserId=?");
        pt.setString(1,uid);
       ResultSet rs= pt.executeQuery();
     while(rs.next())
     {
        Order odd=new Order();
      odd.setOrderId(rs.getInt(1));
      odd.setBill(rs.getDouble(2));
      odd.setUserId(rs.getString(3));
      odd.setStatus(rs.getString(4));
      odd.setOrderItems(viewOrderItems(rs.getInt(1)));
      order.add(odd);
      
        
        }
     }
     catch(Exception e)
     {
         e.printStackTrace();
         
     }
     return order;
    }
   
    
    
    
public List<OrderItem> viewOrderItems(int uId)
{
     try
     {
    Connection c=DbConnection.getConnection();
    PreparedStatement pt=c.prepareStatement("select * from orderItems where orderId=?");
        pt.setInt(1,uId);
        ResultSet rs= pt.executeQuery();
     if(rs!=null)
     {
     List<OrderItem> odd=new ArrayList<OrderItem>();
       while(rs.next())
        {
         OrderItem it=new OrderItem(rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getDouble(6));
            odd.add(it);
        }
       return odd;
      }
     else
         return null;
     }
     catch(Exception e)
     {
         e.printStackTrace();
         
     }
       
    
return null;
    }
public List<Order> viewOrders()
{
 List<Order> order=new Vector<Order>();
 try
 {
    Connection c=DbConnection.getConnection();
PreparedStatement pt=c.prepareStatement("select * from orderstable");
   
   ResultSet rs= pt.executeQuery();
 while(rs.next())
 {
    Order odd=new Order();
  odd.setOrderId(rs.getInt(1));
  odd.setBill(rs.getDouble(2));
  odd.setUserId(rs.getString(3));
  odd.setStatus(rs.getString(4));
  odd.setOrderItems(viewOrderItems(rs.getInt(1)));
  order.add(odd);
  
    
    }
 }
 catch(Exception e)
 {
     e.printStackTrace();
     
 }
 return order;
}
public List<Order> pendingOrders(String status)
{
 List<Order> order=new Vector<Order>();
 try
 {
    Connection c=DbConnection.getConnection();
PreparedStatement pt=c.prepareStatement("select * from orderstable where status=?");
    pt.setString(1,status);
   ResultSet rs= pt.executeQuery();
 while(rs.next())
 {
    Order odd=new Order();
  odd.setOrderId(rs.getInt(1));
  odd.setBill(rs.getDouble(2));
  odd.setUserId(rs.getString(3));
  odd.setStatus(rs.getString(4));
  odd.setOrderItems(viewOrderItems(rs.getInt(1)));
  order.add(odd);
  
    
    }
 }
 catch(Exception e)
 {
     e.printStackTrace();
     
 }
 return order;
}

public boolean acceptOrders(int orderid)
{
 
 try
 {
	
    Connection c=DbConnection.getConnection();
PreparedStatement pt=c.prepareStatement("update orderstable set status='accept' where orderId=?");
    pt.setInt(1,orderid);
   int n= pt.executeUpdate();
   if(n>0)
   {
	   return true;
   }
 }
 catch(Exception e)
 {
     e.printStackTrace();
     
 }
 return false;
}
public boolean rejectOrders(int orderid)
{
 
 try
 {
	
    Connection c=DbConnection.getConnection();
PreparedStatement pt=c.prepareStatement("update orderstable set status='reject' where orderId=?");
    pt.setInt(1,orderid);
   int n= pt.executeUpdate();
   if(n>0)
   {
	   return true;
   }
 }
 catch(Exception e)
 {
     e.printStackTrace();
     
 }
 return false;
}
public List<Order> sucessOrders(String status)
{
 List<Order> order=new Vector<Order>();
 try
 {
    Connection c=DbConnection.getConnection();
PreparedStatement pt=c.prepareStatement("select * from orderstable where status=?");
    pt.setString(1,status);
   ResultSet rs= pt.executeQuery();
 while(rs.next())
 {
    Order odd=new Order();
  odd.setOrderId(rs.getInt(1));
  odd.setBill(rs.getDouble(2));
  odd.setUserId(rs.getString(3));
  odd.setStatus(rs.getString(4));
  odd.setOrderItems(viewOrderItems(rs.getInt(1)));
  order.add(odd);
  
    
    }
 }
 catch(Exception e)
 {
     e.printStackTrace();
     
 }
 return order;
}
public List<Order> failedOrders(String status)
{
 List<Order> order=new Vector<Order>();
 try
 {
    Connection c=DbConnection.getConnection();
PreparedStatement pt=c.prepareStatement("select * from orderstable where status=?");
    pt.setString(1,status);
   ResultSet rs= pt.executeQuery();
 while(rs.next())
 {
    Order odd=new Order();
  odd.setOrderId(rs.getInt(1));
  odd.setBill(rs.getDouble(2));
  odd.setUserId(rs.getString(3));
  odd.setStatus(rs.getString(4));
  odd.setOrderItems(viewOrderItems(rs.getInt(1)));
  order.add(odd);
  
    
    }
 }
 catch(Exception e)
 {
     e.printStackTrace();
     
 }
 return order;
}
}//class