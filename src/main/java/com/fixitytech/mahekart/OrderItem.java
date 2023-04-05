package com.fixitytech.mahekart;






public class OrderItem extends Item
{
  int quantity;
  double amount;
  
  public OrderItem()
	{
	}
	
  public OrderItem (CartItem citem)
  {
	  this.id=citem.getId();
	  this.name=citem.getName();
	  this.price=citem.getPrice();
	  this.quantity=citem.getQuantity();
  }
  
	public OrderItem(int id,String name,double price,int quantity,double amount)
	{
	this.id=id;
	this.name=name;
	this.price=price;
	this.quantity=quantity;
	this.amount=amount;
	}
	
    public int getQuantity() {
	      return quantity;
       }
    public void setQuantity(int quantity) {
	      this.quantity = quantity;
      }
     public double getAmount() {
	         return amount;
      }
     public void setAmount(double amount) {
	        this.amount = amount;
      }
	
	
      }

