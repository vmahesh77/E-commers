package com.fixitytech.mahekart;


public class Item {
    
    int id;
    String name;
    double price;
    byte[] image;
    
    public String[] base64Image;
   
    public Item(int itemid, String itemname, double itemprice) {
        
        id=itemid;
        name=itemname;
        price=itemprice;
        // TODO Auto-generated constructor stub
    }
    public Item() {
        // TODO Auto-generated constructor stub
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public String[] getBase64Image() {
        return base64Image;
    }
    public void setBase64Image(String[] base64Image) {
        this.base64Image = base64Image;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }




}