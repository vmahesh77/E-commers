package com.fixitytech.mahekart;





import java.util.List;

public class Order {

	
	String userId;
	

    String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	double bill;
	int orderId;
	
	

	
	
	List<OrderItem> orderItems;
	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	
	
	public void setOrderId(int orderId)
	{
	this.orderId=orderId;
	}
	
	public void setBill(double bill)
	{
	this.bill=bill;
	}
	

	public double getBill()
	{
	return bill;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	public int getOrderId()
	{
	return orderId;
	}
	
	
  

	}//class
	